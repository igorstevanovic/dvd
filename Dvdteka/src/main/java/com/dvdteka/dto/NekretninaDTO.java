package com.dvdteka.dto;


public class NekretninaDTO {

	
	Long id;
	int povrsina;
	int cena;
	String adresa;
	
	TipDTO tipDTO;

	public NekretninaDTO() {
		super();
	}

	public NekretninaDTO(Long id, int povrsina, int cena, String adresa,
			TipDTO tipDTO) {
		super();
		this.id = id;
		this.povrsina = povrsina;
		this.cena = cena;
		this.adresa = adresa;
		this.tipDTO = tipDTO;
	}

	public NekretninaDTO(int povrsina, int cena, String adresa, TipDTO tipDTO) {
		super();
		this.povrsina = povrsina;
		this.cena = cena;
		this.adresa = adresa;
		this.tipDTO = tipDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPovrsina() {
		return povrsina;
	}

	public void setPovrsina(int povrsina) {
		this.povrsina = povrsina;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public TipDTO getTipDTO() {
		return tipDTO;
	}

	public void setTipDTO(TipDTO tipDTO) {
		this.tipDTO = tipDTO;
	}
	
	
	
	
	
}
