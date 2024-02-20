package com.residenciatic18.gestorLinhasAereas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.residenciatic18.gestorLinhasAereas.model.Piloto;

public class PilotoDAO {
	
	public static ArrayList<Piloto> readAll() {

		ArrayList<Piloto> pilotos = new ArrayList<>();
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT nome, numbreve FROM piloto";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Piloto p = new Piloto();
				p.setNome(rs.getString("nome"));
				p.setNumBreve(rs.getString("numbreve"));
				pilotos.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pilotos;
		
	}

}
