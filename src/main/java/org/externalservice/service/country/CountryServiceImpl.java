package org.externalservice.service.country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.externalservice.service.invoice.DataGenerator;
import org.springframework.stereotype.Service;

import io.spring.guides.gs_producing_web_service.Country;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
@Service("countryServiceImpl")
public class CountryServiceImpl implements CountryService {

	static HashMap<Integer, Country> countryIdMap = getCountryIdMap();

	static {
		Country c = new Country();
		DataGenerator d = new DataGenerator();

		if (countryIdMap == null) {
			countryIdMap=new HashMap<>();
					
			for (int i = 1; i <= 30; i++) {

				c = d.nextCountry();
				countryIdMap.put(c.getId(), c);
			}
		}
	}

	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>(countryIdMap.values());
		return countries;
	}

	public Country getCountry(int id) {
		Country country = countryIdMap.get(id);
		return country;
	}

	public Country getCountryByName(String name) {

		for (Country country : countryIdMap.values()) {
			//if (country.getName().equalsIgnoreCase(name)) 
			{
				return country;
			}
		}
		return null;
	}

	public Country addCountry(Country country) {
		country.setId(getMaxId() + 1);
		countryIdMap.put(country.getId(), country);
		return country;
	}

	public Country updateCountry(Country country) {
		if (country.getId() <= 0)
			return null;
		countryIdMap.put(country.getId(), country);
		return country;

	}

	public void deleteCountry(int id) {
		countryIdMap.remove(id);
	}

	public static HashMap<Integer, Country> getCountryIdMap() {
		return countryIdMap;
	}

	// Utility method to get max id
	public static int getMaxId() {
		int max = 0;
		for (int id : countryIdMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return max;
	}
}
