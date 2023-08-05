package com.GestioneDevices.entity;

import com.GestioneDevices.enumerators.EDeviceState;
import com.GestioneDevices.enumerators.EDeviceType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "smartphones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Smartphone extends Device {
	
	private Double inch;
	
	private String storage;
	
	private String camera;
	
	private String os;
	
	public Smartphone(String name, EDeviceType type, EDeviceState state, Double _inch, String _storage, String _camera, String _os) {
		super(name, type, state);
		this.inch = _inch;
		this.storage = _storage;
		this.camera = _camera;
		this.os = _os;
	}

	@Override
	public String toString() {
		return "Smartphone [inch=" + inch + ", storage=" + storage + ", camera=" + camera + ", os=" + os
				+ ", getName()=" + getName() + ", getType()=" + getType() + ", getState()=" + getState() + "]";
	}
}
