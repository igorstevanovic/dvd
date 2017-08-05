package com.dvdteka.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvdteka.model.Genre;
import com.dvdteka.repository.GenreRepository;
import com.dvdteka.service.GenreService;

@Service
@Transactional
public class JpaGenreService implements GenreService {

	@Autowired
	GenreRepository genreRepository;
	
	@Override
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	@Override
	public Genre findOne(Long id) {
		return genreRepository.findOne(id);
	}

	@Override
	public Genre save(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	public void delete(Long id) {
		genreRepository.delete(id);
	}

}
