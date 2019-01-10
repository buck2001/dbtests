package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.City;

public interface ICityService {
	public List<City> findAll();

	public Optional<City> findOne(Long id);
}