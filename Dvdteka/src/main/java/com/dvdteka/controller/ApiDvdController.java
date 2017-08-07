package com.dvdteka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dvdteka.dto.DvdDTO;
import com.dvdteka.model.Dvd;
import com.dvdteka.service.DvdService;
import com.dvdteka.support.DvdDTOToDvd;
import com.dvdteka.support.DvdToDvdDTO;

@RestController
@RequestMapping(value = "/api/dvds")
public class ApiDvdController {

	@Autowired
	DvdToDvdDTO d2dDTO;

	@Autowired
	DvdDTOToDvd dDTO2d;

	@Autowired
	DvdService dvdService;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<DvdDTO>> getDvds(
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "priceFrom", defaultValue = "0") int priceFrom,
			@RequestParam(value = "priceTo", defaultValue = Integer.MAX_VALUE
					+ "") int priceTo,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "vpp", defaultValue="10") int size) {

		
		Page<Dvd> dvds;
		dvds = dvdService.findAll(page, size);
		if (title != null) {
			dvds = dvdService
					.findTitle(title, priceFrom, priceTo, page, size);
			
		} else {
			dvds = dvdService.findPrice(priceFrom, priceTo, page, size);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", dvds.getTotalPages()+"");
		/*
		 * nekretninas = dvdService.findByPrice(priceFrom, priceTo,
		 * page);
		 */
		
		
		
		return new ResponseEntity<>(d2dDTO.convert(dvds.getContent()), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<DvdDTO> getDvd(@PathVariable Long id) {
		Dvd dvd = dvdService.findOne(id);
		if (dvd == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(d2dDTO.convert(dvd), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<DvdDTO> add(
			@RequestBody DvdDTO newDvd) {

		Dvd savedDvd = dvdService.save(dDTO2d
				.convert(newDvd));

		return new ResponseEntity<>(d2dDTO.convert(savedDvd),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<Dvd> delete(@PathVariable Long id) {
		dvdService.delete(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<DvdDTO> edit(
			@RequestBody DvdDTO dvd, @PathVariable Long id) {

		if (id != dvd.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Dvd persisted = dvdService.save(dDTO2d
				.convert(dvd));

		return new ResponseEntity<>(d2dDTO.convert(persisted), HttpStatus.OK);
	}

}
