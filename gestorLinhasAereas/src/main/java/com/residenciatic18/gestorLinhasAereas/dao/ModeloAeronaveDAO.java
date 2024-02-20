package com.residenciatic18.gestorLinhasAereas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.residenciatic18.gestorLinhasAereas.model.ModeloAeronave;

public class ModeloAeronaveDAO {
	
	public static ArrayList<ModeloAeronave> readAll() {

		ArrayList<ModeloAeronave> modeloaeronaves = new ArrayList<>();
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT nome, fabricante FROM modeloaeronave";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ModeloAeronave m = new ModeloAeronave();
				m.setNome(rs.getString("nome"));
				m.setFabricante(rs.getString("fabricante"));
				modeloaeronaves.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modeloaeronaves;	
	}

}
