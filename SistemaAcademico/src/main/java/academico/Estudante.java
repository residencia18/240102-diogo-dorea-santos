package academico;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;

@Entity
public class Estudante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String email;
	private int matricula;
	@ManyToOne
	@JoinColumn(name = "codCurso")
	private Curso curso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public Estudante(String nome, String email, int matricula, Curso curso) {
		
		this.id = null;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	public Estudante() {
		
		
	}
	@Override
	public String toString() {
		return "Estudante [id=" + id + ", nome=" + nome + ", email=" + email + ", matricula=" + matricula + "]";
	}
	
	
	public static void main(String[] args) {
		/*
		Estudante e1 = new Estudante("Diogo", "diogo@cepedi.com", 123);
		Estudante e2 = new Estudante("Alan", "alan@cepedi.com", 456);
		Estudante e3 = new Estudante("Alexandre", "alexandre@cepedi.com", 789);
		*/
		
		/*
		 * Envia os dados para o BD
		 *
		//
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.getTransaction().commit();
		em.close();	
		emf.close();
		*/
		
		/*
		// Recupera os dados do BD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		Estudante r = em.find(Estudante.class, 5);
		System.out.println(r);
		em.close();
		emf.close();
		*/
		
		/*
		// Deleta os dados do BD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		Estudante r = em.find(Estudante.class, 5);
		em.getTransaction().begin();
		em.remove(r);
		em.getTransaction().commit();
		em.close();
		emf.close();
		*/
		
		
	}
	
	
	
	

}
