package academico;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer numSemestres;
	@OneToMany (mappedBy = "curso")
	List<Estudante> listaEstudantes;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getNumSemestres() {
		return numSemestres;
	}
	public void setNumSemestres(Integer numSemestres) {
		this.numSemestres = numSemestres;
	}
	public Curso(String nome, Integer numSemestres) {
		super();
		this.id = null;
		this.nome = nome;
		this.numSemestres = numSemestres;
	}
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
