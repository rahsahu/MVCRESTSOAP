package org.externalservice.service.film;

import java.util.HashMap;
import java.util.List;

import org.externalservice.bean.Film;

public interface FilmService {
	public List<Film> getFilms();

	public Film getFilm(int id);

	public Film addFilm(Film Film);

	public Film updateFilm(Film Film);

	public void deleteFilm(int id);

	public HashMap<Integer, Film> getFilmIdMap();

	public int getMaxId();
}
