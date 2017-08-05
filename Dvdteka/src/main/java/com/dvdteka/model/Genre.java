package com.dvdteka.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblGenre")
public class Genre {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "genre", cascade = CascadeType.REMOVE)
	private List<Dvd> dvds = new ArrayList<>();

	public Genre() {
		super();
	}

	public Genre(Long id, String name, List<Dvd> dvds) {
		super();
		this.id = id;
		this.name = name;
		this.dvds = dvds;
	}

	public Genre(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Genre(String name) {
		super();
		this.name = name;
	}

	public Genre(String name, List<Dvd> dvds) {
		super();
		this.name = name;
		this.dvds = dvds;
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

	public List<Dvd> getDvds() {
		return dvds;
	}

	public void setDvds(List<Dvd> dvds) {
		this.dvds = dvds;
	}

	public void addDvd(Dvd dvd) {
		this.dvds.add(dvd);

		if (dvd.getGenre() != this) {
			dvd.setGenre(this);
		}
	}
}
