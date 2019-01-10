package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.AppConstants;
import com.example.demo.dao.City;
import com.example.demo.services.ICityService;

@CrossOrigin
@RestController
@RequestMapping("cities")
public class CityController {
	@Autowired
	ICityService cityService;

	@RequestMapping(value = "/showCities", method = RequestMethod.GET)
	public List<City> findCities() {
		List<City> cities = (List<City>) cityService.findAll();

		return cities;
	}

	@RequestMapping(value = "/findCity/{id}", method = RequestMethod.GET)
	public Optional<City> findCity(@PathVariable(AppConstants.PERSON_ID) String id) {
		Long theId = Long.valueOf(id);
		Optional<City> cities = (Optional<City>) cityService.findOne(theId);

		return cities;
	}
}
