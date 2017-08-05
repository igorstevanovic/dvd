package com.dvdteka.dto;


public class TipKaroserijeDTO {

	protected Long id;
	protected String name;
	
	public TipKaroserijeDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public TipKaroserijeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipKaroserijeDTO(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
