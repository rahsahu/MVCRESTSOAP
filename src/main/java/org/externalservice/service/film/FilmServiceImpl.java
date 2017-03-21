package org.externalservice.service.film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.externalservice.bean.Film;
import org.springframework.stereotype.Service;

@Service("filmService")
public class FilmServiceImpl implements FilmService {

	static HashMap<Integer, Film> filmIdMap = null;

	static {
		if (filmIdMap == null) {
			filmIdMap = new HashMap<Integer, Film>();
			Film film1 = new Film(1, "Bladerunner", "10am");
			Film film2 = new Film(2, "Gran Torino", "12pm");
			filmIdMap.put(film1.getId(), film1);
			filmIdMap.put(film2.getId(), film2);
		}
	}

	@Override
	public List<Film> getFilms() {

		List<Film> film = new ArrayList<Film>(filmIdMap.values());

		return film;

	}

	@Override
	public Film getFilm(int id) {
		Film film = filmIdMap.get(id);
		return film;
	}

	public Film addFilm(Film Film) {
		Film.setId(getMaxId() + 1);
		filmIdMap.put(Film.getId(), Film);
		return Film;
	}

	public Film updateFilm(Film Film) {
		if (Film.getId() <= 0)
			return null;
		filmIdMap.put(Film.getId(), Film);
		return Film;

	}

	public void deleteFilm(int id) {
		filmIdMap.remove(id);
	}

	public HashMap<Integer, Film> getFilmIdMap() {
		return filmIdMap;
	}

	public int getMaxId() {
		int max = 0;
		for (int id : filmIdMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return max;
	}
}
