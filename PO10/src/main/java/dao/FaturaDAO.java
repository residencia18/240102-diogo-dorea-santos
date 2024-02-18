package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Models.Fatura;
import Models.Imovel;
import Services.ImovelService;



public class FaturaDAO {
	
	public static void create(Fatura f, EntityManager em) {
		
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		em.close();
	}

//todo: montar um Imovel a partir da matricula e adicionar a fatura.
	public static ArrayList<Fatura> readAll(EntityManager em){
		
		ArrayList<Fatura> faturas = new ArrayList<Fatura>();
		
		String jpql = "SELECT f FROM FATURA F";
		
		try {
			TypedQuery<Fatura> typedQuery = em.createQuery(jpql, Fatura.class);
			faturas = (ArrayList<Fatura>) typedQuery.getResultList();
			}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return faturas;	
	}

}
