package com.dvdteka.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dvdteka.model.Dvd;

@Repository
public interface DvdRepository extends JpaRepository<Dvd, Long> {

	public List<Dvd> findByGenreId(Long id);
	public Page<Dvd> findAll(Pageable pageable);
	public Page<Dvd> findByTitleLikeAndPriceBetween(String title,int
	priceFrom, int priceTo, Pageable pageable);

	public Page<Dvd> findByPriceBetween(int priceFrom, int priceTo,
	Pageable pageable);
}
