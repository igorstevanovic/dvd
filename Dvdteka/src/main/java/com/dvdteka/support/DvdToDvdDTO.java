package com.dvdteka.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dvdteka.dto.DvdDTO;
import com.dvdteka.model.Dvd;

@Component
public class DvdToDvdDTO 
	implements Converter<Dvd, DvdDTO>{

	@Autowired
	GenreToGenreDTO g2gDTO;
	
	@Override
	public DvdDTO convert(Dvd arg0) {
		return new DvdDTO(arg0.getId(), arg0.getTitle(), 
				arg0.getRating(), arg0.getPrice(), g2gDTO.convert(arg0.getGenre()));
	}
	
	public List<DvdDTO> convert(List<Dvd> dvds){
		List<DvdDTO> retVal = new ArrayList<>();
		for (Dvd dvd : dvds) {
			retVal.add(convert(dvd));
		}
		return retVal;
	}

	
}
