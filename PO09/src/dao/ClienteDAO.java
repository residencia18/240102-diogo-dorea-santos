package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Models.Cliente;


public class ClienteDAO {
	
public static void create(Cliente c) {
		
		try {
			Connection conn = DAO.conectar();
			String query = "INSERT INTO cliente (nome, cpf) VALUES (?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			//u.toString();
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCpf());
						
			//System.out.println(query);
			//System.out.println(ps.toString());
			ps.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}


public static void main(String[] args) {
	
	Cliente c = new Cliente();
	c.setNome("Joaquim");
	c.setCpf("123456789");
	
	create(c);
}


}
