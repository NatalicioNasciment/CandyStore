package br.com.candystore.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoFactory {

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5433/candystore", "postgres", "root");
//			return DriverManager.getConnection("jdbc:postgresql://localhost:5433/fabricaweb", "postgres", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
