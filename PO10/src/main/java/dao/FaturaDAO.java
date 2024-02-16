package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Models.Fatura;
import Models.Imovel;
import Services.ImovelService;



public class FaturaDAO {
	
	public static void create(Fatura f, Imovel i) {
		
		try {
			Connection conn = DAO.conectar();
			String query = "INSERT INTO fatura (matriculaimovel, dataemissao, valorconsumo, valorcalculado, leituraanterior, leituraatual, quitada) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, i.getMatricula());
			java.sql.Date dataSql = new java.sql.Date(f.getDataEmissao().getTime());
			ps.setString(2, dataSql.toString());
			ps.setDouble(3, f.getValorConsumo());
			ps.setDouble(4, f.getValorCalculado());
			ps.setDouble(5, f.getLeituraAnterior());
			ps.setDouble(6, f.getLeituraAtual());
			ps.setBoolean(7, f.isQuitada());
			ps.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}

//todo: montar um Imovel a partir da matricula e adicionar a fatura.
	public static ArrayList<Fatura> readAll(){
		
		ArrayList<Fatura> faturas = new ArrayList<Fatura>();
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT matriculaimovel, dataemissao, valorconsumo, valorcalculado, leituraanterior, leituraatual, quitada FROM fatura";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Fatura f = new Fatura();
				f.setDataEmissao(rs.getDate("dataemissao"));
				f.setValorConsumo(rs.getInt("valorconsumo"));
				f.setValorCalculado(rs.getInt("valorcalculado"));
				f.setLeituraAnterior(rs.getInt("leituraanterior"));
				f.setLeituraAtual(rs.getInt("leituraatual"));
				f.setQuitada(rs.getBoolean("quitada"));
				List<Imovel> imoveis = ImovelService.getImoveis();
				for(Imovel i : imoveis) {
					if(i.getMatricula().equals(rs.getString("matriculaimovel"))) {
					f.setImovel(i);
					}
				}
				faturas.add(f);
			}
			conn.close();
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return faturas;
	
	}
	
	

public static void main(String[] args) {
	
	/*
	//teste de create
	Fatura f = new Fatura();
	Imovel i = new Imovel();
	i.setMatricula("5678");
	i.setLeituraAnterior(20);
	f.setLeituraAtual(120);
	f.setDataEmissao(Date.valueOf("2022-01-01"));
	f.setQuitada(true);
	create(f, i);
	*/
	
	/*
	//teste de readAll
	ArrayList<Fatura> faturas = readAll();
	System.out.println(faturas.getFirst().getValorConsumo());
	*/
	
	
}
}
