package org.externalservice.controller;

import java.util.List;

import org.externalservice.bean.Film;
import org.externalservice.service.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {
	@Autowired
	FilmService filmService;

	@RequestMapping(value = "/films", method = RequestMethod.GET)
	public List<Film> getFilms() {
		return filmService.getFilms();
	}

	@RequestMapping(value = "/film/{id}", method = RequestMethod.GET)
	public Film getFilmById(@PathVariable String id) {
		return filmService.getFilm(Integer.parseInt(id));
	}

}