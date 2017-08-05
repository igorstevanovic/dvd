package com.dvdteka.dto;


public class TipDTO {

	Long id;

	String naziv;

	public TipDTO() {
		super();
	}

	public TipDTO(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public TipDTO(String naziv) {
		super();
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	
	
}
