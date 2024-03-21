package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import usuario.Usuario;

public class UsuarioDAO {
	
	public static void create(Usuario u) {
		
		try {
			Connection conn = DAO.conectar();
			String query = "INSERT INTO usuario (login, email, senha) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			//u.toString();
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getSenha());
			
			//System.out.println(query);
			//System.out.println(ps.toString());
			ps.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static ArrayList<Usuario> readAll(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT login, email, senha FROM usuario";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setLogin(rs.getString("login"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				usuarios.add(u);
				conn.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
		
	}
	
	public static Usuario read(String login){
		
		Usuario u = null;
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT login, email, senha FROM usuario WHERE login = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new Usuario();
				u.setLogin(rs.getString("login"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
	public static void update(Usuario u){
		
		try {
			Connection conn = DAO.conectar();
			String query = "UPDATE usuario SET email = ?, senha = ? WHERE login = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getSenha());
			ps.setString(3, u.getLogin());
			ps.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(Usuario u){
		
		try {
			Connection conn = DAO.conectar();
			String query = "DELETE FROM usuario WHERE login = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getLogin());
			ps.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		/*teste de create*/
		Usuario u = new Usuario();
		u.setLogin("Tamires");
		u.setEmail("tamires@gmail.com");
		u.setSenha("Tamires");
		System.out.println(u.toString());
		UsuarioDAO.create(u);
		
		
		/*teste de realAll
		ArrayList<Usuario> usuarios = UsuarioDAO.readAll();
		//System.out.println(usuarios);
		*/
		
		/* Teste de read
		Usuario usuario = UsuarioDAO.read("Diogo");
		System.out.println(usuario);
		*/
		
		/* Teste de update 	
		Usuario u = new Usuario();
		u.setLogin("Diogo");
		u.setEmail("diogodorea@gmail.com");
		u.setSenha("diogodoreasantoss");
		UsuarioDAO.update(u);
		*/
		
		/* Teste de delete
		 * 
		 */
		
		UsuarioDAO.delete(u);
	}
}
