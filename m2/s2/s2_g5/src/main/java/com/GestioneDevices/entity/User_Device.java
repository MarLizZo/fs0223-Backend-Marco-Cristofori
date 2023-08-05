package com.GestioneDevices.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users_devices")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User_Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "device_id")
	private Device device;
	
	@Column(nullable = false)
	private LocalDate dataAssegnazione;
	
	private LocalDate dataRestituzione;
	
	
	public User_Device(User _user, Device _device) {
		this.user = _user;
		this.device = _device;
		this.dataAssegnazione = LocalDate.now();
	}
}





















