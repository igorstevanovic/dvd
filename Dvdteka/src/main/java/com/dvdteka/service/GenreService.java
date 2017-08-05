package com.dvdteka.service;

import java.util.List;

import com.dvdteka.model.Genre;

public interface GenreService {

		List<Genre> findAll();
		Genre findOne(Long id);
		Genre save(Genre genre);
		void delete(Long id);
}
