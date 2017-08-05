package com.dvdteka.dto;



public class AutomobilDTO {

	
	protected Long id;
	protected String madeAndModel;
	protected int volume;
	protected int power;
	protected String year;

	protected TipKaroserijeDTO tipKaroserijeDTO;

	public AutomobilDTO() {
		super();
	}

	public AutomobilDTO(Long id, String madeAndModel, int volume, int power,
			String year, TipKaroserijeDTO tipKaroserijeDTO) {
		super();
		this.id = id;
		this.madeAndModel = madeAndModel;
		this.volume = volume;
		this.power = power;
		this.year = year;
		this.tipKaroserijeDTO = tipKaroserijeDTO;
	}

	public AutomobilDTO(String madeAndModel, int volume, int power,
			String year, TipKaroserijeDTO tipKaroserijeDTO) {
		super();
		this.madeAndModel = madeAndModel;
		this.volume = volume;
		this.power = power;
		this.year = year;
		this.tipKaroserijeDTO = tipKaroserijeDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMadeAndModel() {
		return madeAndModel;
	}

	public void setMadeAndModel(String madeAndModel) {
		this.madeAndModel = madeAndModel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public TipKaroserijeDTO getTipKaroserijeDTO() {
		return tipKaroserijeDTO;
	}

	public void setTipKaroserijeDTO(TipKaroserijeDTO tipKaroserijeDTO) {
		this.tipKaroserijeDTO = tipKaroserijeDTO;
	}

	
	
}
