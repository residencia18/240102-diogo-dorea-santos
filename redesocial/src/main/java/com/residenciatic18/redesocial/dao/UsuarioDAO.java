package com.residenciatic18.redesocial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.residenciatic18.redesocial.model.Usuario;

public class UsuarioDAO {
	
	public static ArrayList<Usuario> readAll() {

		ArrayList<Usuario> usuarios = new ArrayList<>();
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT nome, email, senha FROM usuario";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				usuarios.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

}
