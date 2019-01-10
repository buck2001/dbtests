package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.demo.constants.AppConstants;

public class DatabaseAccessPG {

	public Connection getConnection() {
		return connect();
	}

	private Connection connect() {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(AppConstants.url, AppConstants.user, AppConstants.password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return connection;
	}
}
