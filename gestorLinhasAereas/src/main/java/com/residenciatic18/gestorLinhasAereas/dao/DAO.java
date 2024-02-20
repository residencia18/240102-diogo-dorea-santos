package com.residenciatic18.gestorLinhasAereas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	
	private static final String URL = "jdbc:h2:mem:gestorLinhasAereas";
	private static final String USUARIO = "sa";
	private static final String SENHA = "sa";

	public static Connection conectar(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conectado com sucesso!");
		}
		catch (SQLException e) {
			System.out.println("Erro de conexão: " + e.getMessage());
		}
		return conn;
	}
	
	/*
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.conectar();
	}
	*/

}
