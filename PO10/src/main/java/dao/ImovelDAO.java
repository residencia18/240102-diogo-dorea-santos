package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Models.Cliente;
import Models.Imovel;
import Utils.EntityManagerUtil;



public class ImovelDAO {
	
	public static void create(Imovel i,EntityManager em) {
		
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
		em.close();
	}
	
	public static ArrayList<Imovel> readAll(EntityManager em){
		String jpql = "SELECT i FROM Imovel i";
		ArrayList<Imovel> imoveis = new ArrayList<>();
		try {
			TypedQuery<Imovel> typedQuery =em.createQuery(jpql, Imovel.class);
			imoveis = (ArrayList<Imovel>) typedQuery.getResultList();
			}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return imoveis;
		
	}
	
	public static Imovel read(String matricula){
		
		String jpql = "SELECT i FROM Imovel i WHERE i.matricula = :matricula";
		Imovel i = null;
		try {
			
			TypedQuery<Imovel> typedQuery = EntityManagerUtil.getEntityManager().createQuery(jpql, Imovel.class);
			typedQuery.setParameter("matricula", matricula);
			i = typedQuery.getSingleResult();
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
}
