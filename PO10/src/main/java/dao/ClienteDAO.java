package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Models.Cliente;
import Models.Imovel;

public class ClienteDAO {
	
public static void create(Cliente c, EntityManager em) {
	
	em.getTransaction().begin();
	em.persist(c);
	em.getTransaction().commit();	
	}

	public static ArrayList<Cliente> readAll(){
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	try {
		Connection conn = DAO.conectar();
		String query = "SELECT nome, cpf FROM cliente";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Cliente c = new Cliente();
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			clientes.add(c);
			
		}
		conn.close();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return clientes;
	
	}
	
public static Cliente read(String cpf){
		
		Cliente i = null;
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT nome, cpf FROM cliente WHERE cpf = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i = new Cliente();
				i.setNome(rs.getString("nome"));
				i.setCpf(rs.getString("cpf"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}

	public static void update(Cliente c){
		
		try {
			Connection conn = DAO.conectar();
			String query = "UPDATE cliente SET nome = ?, cpf = ? WHERE nome = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCpf());
			ps.setString(3, c.getNome());
			ps.execute();
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}

public static void delete(Cliente c){
	
	try {
		Connection conn = DAO.conectar();
		String query = "DELETE FROM cliente WHERE nome = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, c.getNome());
		ps.execute();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}

}
