package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.City;
import com.example.demo.repository.CityRepository;
import com.example.demo.services.ICityService;

@Service
public class CityService implements ICityService {
	@Autowired
	private CityRepository repository;

	@Override
	public List<City> findAll() {
		List<City> cities = (List<City>) repository.findAll();

		return cities;
	}

	@Override
	public Optional<City> findOne(Long id) {
		Optional<City> cities = (Optional<City>) repository.findById(id);

		return cities;
	}
}
