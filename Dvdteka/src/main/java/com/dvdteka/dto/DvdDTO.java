package com.dvdteka.dto;

public class DvdDTO {

	Long id;
	private String title;
	private int rating;
	private int price;

	GenreDTO genreDTO;

	public DvdDTO() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public GenreDTO getGenreDTO() {
		return genreDTO;
	}

	public void setGenreDTO(GenreDTO genreDTO) {
		this.genreDTO = genreDTO;
	}

	public DvdDTO(String title, int rating, int price) {
		super();
		this.title = title;
		this.rating = rating;
		this.price = price;
	}

	public DvdDTO(Long id, String title, int rating, int price) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.price = price;
	}

	public DvdDTO(String title, int rating, int price, GenreDTO genreDTO) {
		super();
		this.title = title;
		this.rating = rating;
		this.price = price;
		this.genreDTO = genreDTO;
	}

	public DvdDTO(Long id, String title, int rating, int price,
			GenreDTO genreDTO) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.price = price;
		this.genreDTO = genreDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
