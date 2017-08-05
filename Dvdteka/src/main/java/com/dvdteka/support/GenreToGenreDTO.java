package com.dvdteka.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dvdteka.dto.GenreDTO;
import com.dvdteka.model.Genre;

@Component
public class GenreToGenreDTO implements Converter<Genre, GenreDTO>{

	@Override
	public GenreDTO convert(Genre arg0) {
		return new GenreDTO(arg0.getId(), arg0.getName());
	}

	
	public List<GenreDTO> convert(List<Genre> genres){
		List<GenreDTO> retVal = new ArrayList<>();
		for (Genre genre : genres) {
			retVal.add(convert(genre));
		}
		return retVal;
	}
}
