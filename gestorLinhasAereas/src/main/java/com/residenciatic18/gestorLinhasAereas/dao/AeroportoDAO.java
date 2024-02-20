package com.residenciatic18.gestorLinhasAereas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.residenciatic18.gestorLinhasAereas.model.Aeroporto;

public class AeroportoDAO {

	public static ArrayList<Aeroporto> readAll() {

		ArrayList<Aeroporto> aeroportos = new ArrayList<>();
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT nome, icao FROM aeroporto";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aeroporto a = new Aeroporto();
				a.setNome(rs.getString("nome"));
				a.setIcao(rs.getString("icao"));
				aeroportos.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aeroportos;
		
	}
	
	

}
