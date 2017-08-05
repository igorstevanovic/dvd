package com.dvdteka.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dvdteka.dto.GenreDTO;
import com.dvdteka.model.Dvd;
import com.dvdteka.model.Genre;
import com.dvdteka.service.DvdService;

@Component
public class GenreDTOToGenre implements Converter<GenreDTO, Genre> {

	//TODO implementirati preuzimanje knjiga iz baze pri kreiranju autora
	
	@Autowired
	DvdService dvdService;
		
	@Override
	public Genre convert(GenreDTO arg0) {
		List<Dvd> dvds = new ArrayList<>();
		dvds = dvdService.findByGenreId(arg0.getId());
		return new Genre(arg0.getId(), arg0.getName(), dvds);
	}

}
