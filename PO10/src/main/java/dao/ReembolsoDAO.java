package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Models.Pagamento;
import Models.Reembolso;
import Utils.EntityManagerUtil;

public class ReembolsoDAO {
	public static void create(Reembolso p, EntityManager em) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static ArrayList<Reembolso> readAll(){
		
		ArrayList<Reembolso> reembolsos = new ArrayList<Reembolso>();
		String jpql = "SELECT r FROM Reembolso r";
		try {		
			TypedQuery<Reembolso> typedQuery = EntityManagerUtil.getEntityManager().createQuery(jpql, Reembolso.class);
			reembolsos = (ArrayList<Reembolso>) typedQuery.getResultList();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return reembolsos;
	}
}
