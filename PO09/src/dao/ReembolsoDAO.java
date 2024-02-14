package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Models.Pagamento;
import Models.Reembolso;

public class ReembolsoDAO {
	public static void create(Reembolso r, Pagamento p) {
		
		try {
			Connection conn = DAO.conectar();
			String query1 = "SELECT id FROM pagamento WHERE idfatura = ?";
			PreparedStatement ps1 = conn.prepareStatement(query1);
			
			ps1.setString(1, p.getFatura().getImovel().getMatricula());
			ResultSet rs1 = ps1.executeQuery();
			String query2 = "INSERT INTO reembolso (idpagamento, valor, data) VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query2);
			ps.setString(1, p.getFatura().getImovel().getMatricula());
			ps.setDouble(2, p.getValor());
			java.sql.Date dataSql = new java.sql.Date(p.getData().getTime());
			ps.setString(3, dataSql.toString());
			ps.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static ArrayList<Reembolso> readAll(){
		
		ArrayList<Reembolso> reembolsos = new ArrayList<Reembolso>();
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT valor, data FROM reembolso";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reembolso r = new Reembolso();
				r.setValor(rs.getDouble("valor"));
				r.setData(rs.getDate("data"));
				reembolsos.add(r);
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return reembolsos;
	}

}
