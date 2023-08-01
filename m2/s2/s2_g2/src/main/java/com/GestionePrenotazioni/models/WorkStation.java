package com.GestionePrenotazioni.models;

import java.util.List;

import com.GestionePrenotazioni.enums.WSType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "workstations")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkStation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String code;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private WSType type;

	@ManyToOne(fetch = FetchType.EAGER)
	private Facility facility;

	@Column(nullable = false)
	private Integer maxSeats;
	
	@OneToMany(mappedBy = "workStation", fetch = FetchType.EAGER)
	private List<Reservation> reservations;
	
	public WorkStation(String _code, String _description, WSType _type, Facility _facility) {
		this.code = _code;
		this.description = _description;
		this.type = _type;
		this.maxSeats = _type == WSType.BOARDROOM ? 8 : _type == WSType.OPENSPACE ? 3 : 1;
		this.facility = _facility;
	}

	@Override
	public String toString() {
		return "WorkStation [id=" + id + ", code=" + code + ", description=" + description + ", type=" + type
				+ ", facility=" + facility + ", maxSeats=" + maxSeats + ", reservations Count=" + reservations.size() + "]";
	}
}
