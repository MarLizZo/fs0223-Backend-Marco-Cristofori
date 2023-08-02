package com.GestionePrenotazioni.models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<User> users;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@ManyToOne
	private WorkStation workStation;
	
	public Reservation(Set<User> _users, LocalDate _date, WorkStation _workStation) {
		this.users = _users;
		this.date = _date;
		this.workStation = _workStation;
	}

	@Override
	public String toString() {
		String userStr = "";
		for (User u : users) {
			userStr = userStr.concat(u.getUsername() + ", ");
		}
		return "Reservation [id=" + id + ", users=" + userStr + "date=" + date + ", workStation=" + workStation + "]";
	}
}
