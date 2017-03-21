package org.externalservice.controller;

import java.util.List;

import org.externalservice.service.country.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.guides.gs_producing_web_service.Country;

@RestController
public class CountryController {

	@Autowired
	CountryServiceImpl countryServiceImpl;

	@RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getCountries() {
		List<Country> listOfCountries = countryServiceImpl.getAllCountries();
		return listOfCountries;
	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			MediaType.APPLICATION_XML_VALUE })

	public Country getCountryById(@PathVariable int id) {
		return countryServiceImpl.getCountry(id);
	}

	@RequestMapping(value = "/country", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Country addCountry(@RequestBody Country country) {
		return countryServiceImpl.addCountry(country);
	}

	@RequestMapping(value = "/country", method = RequestMethod.PUT, headers = "Accept=application/json", produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Country updateCountry(@RequestBody Country country) {
		return countryServiceImpl.updateCountry(country);

	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json", produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void deleteCountry(@PathVariable("id") int id) {
		countryServiceImpl.deleteCountry(id);

	}
}
