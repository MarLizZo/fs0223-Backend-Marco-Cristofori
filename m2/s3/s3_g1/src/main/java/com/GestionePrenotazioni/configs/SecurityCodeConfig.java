package com.GestionePrenotazioni.configs;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SecurityCodeConfig implements AttributeConverter<String, String> {
	
	@Value("${app-cipher-key}") private String secretKey;
	@Value("${app-algorithm}") private String algorithm;
	@Value("${app-init-vector}") private String initVector;

	@Override
	public String convertToDatabaseColumn(String attribute) {
		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
		Key my_key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
		try {
			Cipher cry = Cipher.getInstance(algorithm);
			cry.init(Cipher.ENCRYPT_MODE, my_key, iv);
			return Base64.getEncoder().encodeToString((cry.doFinal(attribute.getBytes())));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new RuntimeException();
		}
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
		Key my_key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
		try {
			Cipher cry = Cipher.getInstance(algorithm);
			cry.init(Cipher.DECRYPT_MODE, my_key, iv);
			return new String(cry.doFinal(Base64.getDecoder().decode(dbData)));
		} catch (Exception ex) {
			throw new RuntimeException();
		}
	}
}


























