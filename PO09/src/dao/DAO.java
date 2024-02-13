package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	
	private static final String URL = "jdbc:mysql://u7drwc3kydzpcy2e:RQkU0DjTtiQG4WklQLQr@bpu4ygjpkscnrm9ptsb2-mysql.services.clever-cloud.com:3306/bpu4ygjpkscnrm9ptsb2";
	private static final String USUARIO = "u7drwc3kydzpcy2e";
	private static final String SENHA = "RQkU0DjTtiQG4WklQLQr";

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
