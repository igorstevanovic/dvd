package com.dvdteka.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dvdteka.model.Dvd;
import com.dvdteka.repository.DvdRepository;
import com.dvdteka.service.DvdService;

@Service
@Transactional
public class JpaDvdService implements DvdService {

	@Autowired
	DvdRepository dvdRepository;
	
	@Override
	public List<Dvd> findAll() {
		
		return dvdRepository.findAll();
	}

	@Override
	public Dvd findOne(Long id) {
		
		return dvdRepository.findOne(id);
	}

	@Override
	public Dvd save(Dvd dvd) {
		
		return dvdRepository.save(dvd);
	}

	@Override
	public void delete(Long id) {
		dvdRepository.delete(id);

	}

	@Override
	public List<Dvd> findByGenreId(Long id) {
		
		return dvdRepository.findByGenreId(id);
	}

	@Override
	public Page<Dvd> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return dvdRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public Page<Dvd> findTitle(String title, int priceFrom, int priceTo, int page, int size) {
		
		return dvdRepository.findByTitleLikeAndPriceBetween("%"+title+"%", priceFrom, priceTo, new PageRequest(page, size));
	}

	@Override
	public Page<Dvd> findPrice(int priceFrom, int priceTo, int page, int size) {
		
		return dvdRepository.findByPriceBetween(priceFrom, priceTo, new PageRequest(page, size));
	}

}
