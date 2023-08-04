package com.GestioneDevices.entity;

import com.GestioneDevices.enumerators.EDeviceState;
import com.GestioneDevices.enumerators.EDeviceType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "laptops")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Laptop extends Device {
	
	private String storage;
	
	private String ram;
	
	private String os;
	
	public Laptop(String name, EDeviceType type, EDeviceState state, String _storage, String _ram, String _os) {
		super(name, type, state);
		this.storage = _storage;
		this.ram = _ram;
		this.os = _os;
	}
	
}
