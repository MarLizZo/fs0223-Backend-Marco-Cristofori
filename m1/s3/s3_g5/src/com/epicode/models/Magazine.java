package com.epicode.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import com.epicode.enumerations.Periodicita;

@Entity
@NamedQuery(name = "Magazine.getAll", query = "SELECT m FROM Magazine m")
public class Magazine extends ElementoBiblioteca {
	
	@Column(nullable = false)
	private Periodicita periodicita;

	public Magazine() {
		super();
	}

	public Magazine(Long id, String iSBN, String title, LocalDate publishedDate, Integer pages, Periodicita periodicita) {
		super(id, iSBN, title, publishedDate, pages);
		this.periodicita = periodicita;
	}

	public Magazine(String iSBN, String title, LocalDate publishedDate, Integer pages, Periodicita periodicita) {
		super(iSBN, title, publishedDate, pages);
		this.periodicita = periodicita;
	}
	
	public Periodicita getPeriodicita() {
		return periodicita;
	}

	@Override
	public String toString() {
		return "Magazine [periodicita=" + periodicita + ", ISBN=" + getISBN() + ", Title=" + getTitle()
				+ ", PublishedDate=" + getPublishedDate() + ", Pages=" + getPages() + "]";
	}
}
