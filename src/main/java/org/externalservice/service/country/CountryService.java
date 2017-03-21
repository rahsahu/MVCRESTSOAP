package org.externalservice.service.country;

import java.util.List;

import io.spring.guides.gs_producing_web_service.Country;

public interface CountryService {

	public List<Country> getAllCountries();

	public Country getCountry(int id);

	public Country addCountry(Country country);

	public Country updateCountry(Country country);

	public void deleteCountry(int id);

}
