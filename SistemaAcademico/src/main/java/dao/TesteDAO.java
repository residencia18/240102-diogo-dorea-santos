package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import academico.Curso;
import academico.Estudante;
import dto.EstudanteDTO;


public class TesteDAO {
	
	public static void preparaBD(EntityManager em) {
		
		Curso c1 = new Curso("Computacao", 8);
		Curso c2 = new Curso("Matematica", 7);
		Curso c3 = new Curso("Enfermagem", 8);
		Curso c4 = new Curso("Medicina", 10);
		Curso c5 = new Curso("Direito", 8);
		
		Estudante e1 = new Estudante("Joaquim", "joaquim@ig", 123, c1);
		Estudante e2 = new Estudante("Maria", "maria@bol", 456, c3);
		Estudante e3 = new Estudante("Pedro", "pedro@hotmail", 789, c1);
		Estudante e4 = new Estudante("Diogo", "diogo@gmail", 123, c4);
		Estudante e5 = new Estudante("Alan", "alan@live", 456, c5);
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(c5);
		
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.persist(e5);
		
		em.getTransaction().commit();
		
	}
	
	public static void listarTodosEstudantes(EntityManager em) {
		String jpql = "SELECT e FROM Estudante e";
		TypedQuery<Estudante> typedQuery =em.createQuery(jpql, Estudante.class);
		List<Estudante> lista = typedQuery.getResultList();
		for (Estudante e : lista) {
			System.out.println(e);
		}
	}
	
	public static void listarEstudantePorNome(EntityManager em) {
		String jpql = "SELECT e.nome FROM Estudante e";
		TypedQuery<String> typedQuery =em.createQuery(jpql, String.class);
		
		List<String> nomes = typedQuery.getResultList();
		System.out.println("Lista de estudantes\n");
		System.out.println(nomes);
	}
	
	public static void recuperaNomeEstudantes(EntityManager em) {
		String jpql = "SELECT e FROM Estudante e WHERE e.nome = 'Diogo'";
		TypedQuery<Estudante> typedQuery =em.createQuery(jpql, Estudante.class);
		
		Estudante e = typedQuery.getSingleResult();
		e.setEmail("diogodorea@gmail.com");
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("Recupera o Estudante Diogo do banco de dados e atualiza o email\n");
		System.out.println(e);	
	}
	
	public static void gerarEstudanteDTO(EntityManager em) {

		
		String jpql = "SELECT new dto.EstudanteDTO(e.nome, e.email, e.matricula, e.curso.nome) FROM Estudante e";
		
		TypedQuery<EstudanteDTO> typedQuery =em.createQuery(jpql, EstudanteDTO.class);
		List<EstudanteDTO> listaEstudanteDTO = typedQuery.getResultList();
		System.out.println("Estudantes DTO recupera e exibe apenas dados necessarios");
		for (EstudanteDTO e : listaEstudanteDTO) {
			System.out.println(e.toString());
		}
		
	}
	
	public static void mostrarEstudantesPorCurso(EntityManager em) {
		
		String jpql = "SELECT c FROM Curso c WHERE c.id = 1";
		TypedQuery<Curso> typedQuery = em.createQuery(jpql, Curso.class);
		Curso c = typedQuery.getSingleResult();
		String jpqlEstudante = "SELECT e FROM Estudante e WHERE e.curso = :c";
		TypedQuery<Estudante> typedQueryEstudante = em.createQuery(jpqlEstudante, Estudante.class);
		typedQueryEstudante.setParameter("c", c);
		List<Estudante> lista = typedQueryEstudante.getResultList();
		System.out.println("Estudantes do curso " + c.getNome());
		for (Estudante e : lista) {
			
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		TesteDAO.preparaBD(em);
		TesteDAO.listarTodosEstudantes(em);
		TesteDAO.listarEstudantePorNome(em);
		TesteDAO.recuperaNomeEstudantes(em);
		//Refatorar
		//TesteDAO.gerarEstudanteDTO(em);
		TesteDAO.mostrarEstudantesPorCurso(em);
		emf.close();
		em.close();

	}

}
