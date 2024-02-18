package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Models.Fatura;
import Models.Imovel;
import Models.Pagamento;

public class PagamentoDAO {
	
	public static void create(Pagamento p, EntityManager em){ 		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();	
	}
	
	public static ArrayList<Pagamento> readAll(EntityManager em){
		
		ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
		
		String jpql = "SELECT f FROM FATURA F";
		
		try {
			TypedQuery<Pagamento> typedQuery = em.createQuery(jpql, Pagamento.class);
			pagamentos = (ArrayList<Pagamento>) typedQuery.getResultList();
			}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return pagamentos;	
	}
	
	


}
