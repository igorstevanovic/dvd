package com.dvdteka.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dvdteka.model.Dvd;

public interface DvdService {

		List<Dvd> findAll();
		Dvd findOne(Long id);
		Dvd save(Dvd dvd);
		void delete(Long id);
		List<Dvd> findByGenreId(Long id);
		Page<Dvd> findAll(int page, int size);
		Page<Dvd> findTitle(String title, int priceFrom, int priceTo, int page, int size);
		Page<Dvd> findPrice(int priceFrom, int priceTo, int page, int size);
}
