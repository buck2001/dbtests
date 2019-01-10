package com.example.demo.services.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.City;
import com.example.demo.dao.DatabaseAccessPG;
import com.example.demo.repository.CityRepository;
import com.example.demo.services.ICityService;

@Service
public class CityService implements ICityService {
	@Autowired
	private CityRepository repository;

	@Override
	public List<City> findAll() {
		List<City> cities = (List<City>) repository.findAll();
		getSummit();

		return cities;
	}

	@Override
	public Optional<City> findOne(Long id) {
		Optional<City> cities = (Optional<City>) repository.findById(id);

		return cities;
	}

	private String getSummit() {
		DatabaseAccessPG databaseAccessPG = new DatabaseAccessPG();
		Connection connection = databaseAccessPG.getConnection();
		String SQL = "SELECT * FROM actor where last_name ILIKE 'Wahlberg'";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println("\tFOUND -> " + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				connection.close();
				System.out.println("\nCONNECTION CLOSED!!!!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return "";
	}
}
