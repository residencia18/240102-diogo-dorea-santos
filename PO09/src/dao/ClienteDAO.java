package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			ps.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
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


public static void main(String[] args) {
	
	/*
	//teste de create
	Cliente c = new Cliente();
	c.setNome("Joaquim");
	c.setCpf("123456789");
	
	create(c);
	*/
	
	/*
	//teste de readAll
	ArrayList<Cliente> clientes = readAll();
	System.out.println(clientes);
	*/
	
	/*
	//teste de read
	
	Cliente c = new ClienteDAO().read("123456700");
	System.out.println(c);
	*/
	
	/*
	//teste de update
	Cliente c = new Cliente();
	c.setNome("Joaquim");
	c.setCpf("123456700");
	
	update(c);
	*/
	
	/*
	//teste de delete
	Cliente c = new Cliente();
	c.setNome("Joaquim");
	c.setCpf("123456789");
	
	delete(c);
	*/
}


}
