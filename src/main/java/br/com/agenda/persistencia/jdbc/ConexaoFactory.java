package br.com.agenda.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	public static Connection getConection(){
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5433/agenda", "postgres", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}