package com.dvdteka.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dvdteka.dto.DvdDTO;
import com.dvdteka.model.Dvd;

@Component
public class DvdDTOToDvd implements
		Converter<DvdDTO, Dvd> {

	@Autowired
	GenreDTOToGenre gDTO2g;

	@Override
	public Dvd convert(DvdDTO arg0) {
		return new Dvd(arg0.getId(), arg0.getTitle(), arg0.getRating(),
				arg0.getPrice(), gDTO2g.convert(arg0.getGenreDTO()));
	}

}
