package com.dvdteka;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvdteka.model.Dvd;
import com.dvdteka.model.Genre;
import com.dvdteka.service.DvdService;
import com.dvdteka.service.GenreService;

@Component
public class TestData {

	@Autowired
	private DvdService dvdService;

	@Autowired
	private GenreService genreService;

	@PostConstruct
	public void init() {

		Genre genre1 = new Genre("Horor");
		Genre genre2 = new Genre("Comedy");
		Genre genre3 = new Genre("Romantic");

		genreService.save(genre1);
		genreService.save(genre2);
		genreService.save(genre3);

		for (int i = 1; i <= 10; i++) {

			Dvd dvd = new Dvd();
			dvd.setTitle("Title_" + i);
			dvd.setRating((int) (Math.random() * 5 + 1));
			dvd.setPrice((int) (Math.random() * 10 + 1));
			dvd.setGenre(genre1);
			genre1.addDvd(dvd);
			dvdService.save(dvd);
		}

		for (int i = 11; i <= 20; i++) {
			Dvd dvd = new Dvd();
			dvd.setTitle("Title_" + i);
			dvd.setRating((int) (Math.random() * 5 + 1));
			dvd.setPrice((int) (Math.random() * 10 + 1));
			dvd.setGenre(genre2);
			genre2.addDvd(dvd);
			dvdService.save(dvd);
		}

		for (int i = 21; i <= 30; i++) {
			Dvd dvd = new Dvd();
			dvd.setTitle("Title_" + i);
			dvd.setRating((int) (Math.random() * 5 + 1));
			dvd.setPrice((int) (Math.random() * 10 + 1));
			dvd.setGenre(genre3);
			genre3.addDvd(dvd);
			dvdService.save(dvd);
		}
	}
}
