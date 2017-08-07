package com.dvdteka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dvdteka.dto.DvdDTO;
import com.dvdteka.dto.GenreDTO;
import com.dvdteka.model.Dvd;
import com.dvdteka.model.Genre;
import com.dvdteka.service.DvdService;
import com.dvdteka.service.GenreService;
import com.dvdteka.support.DvdToDvdDTO;
import com.dvdteka.support.GenreDTOToGenre;
import com.dvdteka.support.GenreToGenreDTO;

@RestController
@RequestMapping(value = "/api/genres")
public class ApiGenreController {

	@Autowired
	private GenreService genreService;
	
	@Autowired
	private DvdService dvdService;
	
	@Autowired
	private GenreToGenreDTO g2gDTO;
	
	@Autowired
	GenreDTOToGenre gDTO2gDTO;
	
	@Autowired
	private DvdToDvdDTO d2dDTO;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<GenreDTO>> getGenre() {
		List<Genre> genres;

		genres = genreService.findAll();
		
		return new ResponseEntity<>(g2gDTO.convert(genres), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/dvds", method = RequestMethod.GET)
	ResponseEntity<List<DvdDTO>> getGenres(@PathVariable Long id) {
		Genre genre = genreService.findOne(id);
		if (genre == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<Dvd> foundDvds = dvdService.findByGenreId(id);

		return new ResponseEntity<>(d2dDTO.convert(foundDvds), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<Genre> delete(@PathVariable Long id) {
		dvdService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<GenreDTO> add(@RequestBody GenreDTO newGenre) {

		Genre savedGenre = genreService.save(gDTO2gDTO.convert(newGenre));

		return new ResponseEntity<>(g2gDTO.convert(savedGenre), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<GenreDTO> edit(@RequestBody GenreDTO dvd, @PathVariable Long id) {

		if (id != dvd.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Genre persisted = genreService.save(gDTO2gDTO.convert(dvd));

		return new ResponseEntity<>(g2gDTO.convert(persisted), HttpStatus.OK);
	}

}
