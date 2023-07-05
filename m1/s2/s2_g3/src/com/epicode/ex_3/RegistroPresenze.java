package com.epicode.ex_3;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
	
	File file = new File("doc/test.txt");
	private static Map<String, String> presenze = new HashMap<String, String>();
	
	public Map<String, String> leggiPresenze() throws IOException {
		String text = FileUtils.readFileToString(file, "UTF-8");
		
		String[] arrText = text.split("#");
		
		for (int i = 0; i < arrText.length; i++) {
			presenze.put(arrText[i].substring(0, arrText[i].length() - 2), arrText[i].substring(arrText[i].length() - 1, arrText[i].length()));
		}
		
		return presenze;
	}
	
	public void salvaPresenza(String nome, int presenze) throws IOException {
		FileUtils.write(file, nome + "@" + presenze + "#", "UTF-8", true);
	}
}
























