package com.GestionePrenotazioni.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "facilities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Facility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String city;
	
	@OneToMany(mappedBy = "facility", fetch = FetchType.LAZY)
	private List<WorkStation> workStations;
	
	public Facility(String _address, String _city) {
		this.address = _address;
		this.city = _city;
	}

	@Override
	public String toString() {
		return "Facility [id=" + id + ", address=" + address + ", city=" + city + "]";
	}
}
