package com.GestioneDevices.entity;

import java.util.ArrayList;
import java.util.List;

import com.GestioneDevices.enumerators.EDeviceState;
import com.GestioneDevices.enumerators.EDeviceType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "devices")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Device {
	
	@Id
	@SequenceGenerator(name = "my_seq", sequenceName = "my_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EDeviceType type;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EDeviceState state;
	
	@OneToMany(mappedBy = "device")
	@JsonIgnore
	private List<User_Device> user_devices = new ArrayList<>();
	
	public Device(String name, EDeviceType type, EDeviceState state) {
		this.name = name;
		this.type = type;
		this.state = state;
	}
}




















