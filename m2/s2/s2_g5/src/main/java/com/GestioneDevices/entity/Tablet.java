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
@Table(name = "tablets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tablet extends Device {
	
	private Double inch;
	
	private Boolean with_pen;
	
	public Tablet(String name, EDeviceType type, EDeviceState state, Double _inch, Boolean _with_pen) {
		super(name, type, state);
		this.inch = _inch;
		this.with_pen = _with_pen;
	}

	@Override
	public String toString() {
		return "Tablet [inch=" + inch + ", with_pen=" + with_pen + ", getName()=" + getName() + ", getType()="
				+ getType() + ", getState()=" + getState() + "]";
	}
}
