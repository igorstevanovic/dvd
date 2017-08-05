package com.dvdteka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tblDvds")
public class Dvd {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="title")
	private String title;
	@Column(name="rating")
	private int rating;
	@Column(name="price")
	private int price;
	@ManyToOne(fetch=FetchType.LAZY)
	private Genre genre;

	public Dvd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dvd(Long id, String title, int rating, int price, Genre genre) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.price = price;
		this.genre = genre;
	}

	public Dvd(String title, int rating, int price, Genre genre) {
		super();
		this.title = title;
		this.rating = rating;
		this.price = price;
		this.genre = genre;
	}

	public Dvd(Long id, String title, int rating, int price) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.price = price;
	}

	public Dvd(String title, int rating, int price) {
		super();
		this.title = title;
		this.rating = rating;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
}
