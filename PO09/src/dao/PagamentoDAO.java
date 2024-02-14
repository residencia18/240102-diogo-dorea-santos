package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Models.Fatura;
import Models.Imovel;
import Models.Pagamento;

public class PagamentoDAO {
	
	public static void create(Pagamento p, Fatura f) {
		
		try {
			Connection conn = DAO.conectar();
			String query1 = "SELECT id FROM fatura WHERE matriculaimovel = ?";
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, f.getImovel().getMatricula());
			ResultSet rs1 = ps1.executeQuery();
			
			String query2 = "INSERT INTO pagamento (idfatura, valor, data) VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query2);
			
			ps.setString(1, rs1.getString("id"));
			ps.setDouble(2, p.getValor());
			java.sql.Date dataSql = new java.sql.Date(p.getData().getTime());
			ps.setString(3, dataSql.toString());
			ps.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static ArrayList<Pagamento> readAll(){
		
		ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
		try {
			Connection conn = DAO.conectar();
			String query = "SELECT valor, data FROM pagamento";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Pagamento p = new Pagamento();
				p.setValor(rs.getDouble("valor"));
				p.setData(rs.getDate("data"));
				pagamentos.add(p);
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return pagamentos;
	}
	
	


}
