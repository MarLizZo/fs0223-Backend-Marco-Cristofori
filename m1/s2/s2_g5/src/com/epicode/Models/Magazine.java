package com.epicode.Models;

import java.time.LocalDate;

import com.epicode.Enums.Periodicita;

public class Magazine extends Readable {
	private Periodicita periodicita;

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
