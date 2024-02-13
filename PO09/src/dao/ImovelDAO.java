package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	
	public static void main(String[] args) {
		
		Imovel i = new Imovel();
		i.setMatricula("1234");
		i.setEndereco("rua");
		i.setLeituraAnterior(10);
		i.setLeituraAtual(20);
		Cliente c = new Cliente();
		c.setNome("Joaquim");
		c.setCpf("123456789");
		
		create(i, c);
	}

}
