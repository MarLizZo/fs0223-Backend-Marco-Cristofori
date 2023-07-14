package com.epicode.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String lastname;
	private Long cardnumber;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Prestito> prestiti = new ArrayList<Prestito>();

	public Utente() {
		super();
	}

	public Utente(Long id, String name, String lastname, Long cardnumber) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.cardnumber = cardnumber;
	}

	public Utente(String name, String lastname, Long cardnumber) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.cardnumber = cardnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(Long cardnumber) {
		this.cardnumber = cardnumber;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", cardnumber=" + cardnumber + "]";
	}
}






















