package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Models.Cliente;
import Models.Imovel;



public class ImovelDAO {
	
	public static void create(Imovel i, Cliente c) {
		
		try {
			Connection conn = DAO.conectar();
			String query = "INSERT INTO imovel (cpfcliente, matricula, endereco, leituraanterior, leituraatual) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			//u.toString();
			ps.setString(1, c.getCpf());
			ps.setString(2, i.getMatricula());
			ps.setString(3, i.getEndereco());
			ps.setDouble(4, i.getLeituraAnterior());
			ps.setDouble(5, i.getLeituraAtual());
						
			//System.out.println(query);
			//System.out.println(ps.toString());
			ps.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static ArrayList<Imovel> readAll(){
		ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT matricula, endereco, leituraanterior, leituraatual FROM imovel";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Imovel i = new Imovel();
				i.setMatricula(rs.getString("matricula"));
				i.setEndereco(rs.getString("endereco"));
				i.setLeituraAnterior(rs.getInt("leituraanterior"));
				i.setLeituraAtual(rs.getInt("leituraatual"));
				imoveis.add(i);
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return imoveis;
		
	}
	
	public static Imovel read(String matricula){
		
		Imovel i = null;
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT matricula, endereco, leituraanterior, leituraatual FROM imovel WHERE matricula = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, matricula);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i = new Imovel();
				i.setMatricula(rs.getString("matricula"));
				i.setEndereco(rs.getString("endereco"));
				i.setLeituraAnterior(rs.getInt("leituraanterior"));
				i.setLeituraAtual(rs.getInt("leituraatual"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	public static void update(Imovel i){
		
		try {
			Connection conn = DAO.conectar();
			String query = "UPDATE imovel SET matricula = ?, endereco = ?, leituraanterior = ?, leituraatual = ? WHERE matricula = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, i.getMatricula());
			ps.setString(2, i.getEndereco());
			ps.setInt(3, i.getLeituraAnterior());
			ps.setInt(4, i.getLeituraAtual());
			ps.setString(5, i.getMatricula());
			ps.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(Imovel i){
		
		try {
			Connection conn = DAO.conectar();
			String query = "DELETE FROM imovel WHERE matricula = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, i.getMatricula());
			ps.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	public static void main(String[] args) {
		
		/*
		//teste de create
		Imovel i = new Imovel();
		i.setMatricula("1234");
		i.setEndereco("rua");
		i.setLeituraAnterior(10);
		i.setLeituraAtual(20);
		Cliente c = new Cliente();
		c.setNome("Joaquim");
		c.setCpf("123456789");
		
		create(i, c);
		*/
		
		/*
		//teste readAll
		ArrayList<Imovel> imoveis = readAll();
		for(Imovel i : imoveis) {
			
			System.out.println(i.toString());
			
		}
		*/
		
		/*
		//teste de read
		Imovel i = read("1234");
		System.out.println(i.toString());
		*/
		
		//teste de update
		Imovel i = read("1234");
		System.out.println(i.toString());

		i.setEndereco("nova rua");
		i.setLeituraAtual(30);

		update(i);
	}
	
}
