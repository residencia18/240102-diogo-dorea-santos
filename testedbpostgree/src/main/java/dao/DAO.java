package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	
	private static final String URL = "jdbc:mysql://unhmgbwauq8yrtjy:xJ9KCm5w7PW7rLRTc8BM@bfkdx7k3xbii096zd12u-mysql.services.clever-cloud.com:3306/bfkdx7k3xbii096zd12u";
	private static final String USUARIO = "unhmgbwauq8yrtjy";
	private static final String SENHA = "xJ9KCm5w7PW7rLRTc8BM";

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
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.conectar();
	}

}
