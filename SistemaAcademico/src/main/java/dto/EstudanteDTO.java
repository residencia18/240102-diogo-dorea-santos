package dto;

public class EstudanteDTO {
	private String nome, email;
	private int matricula;
	
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
	public EstudanteDTO(String nome, String email, int matricula) {
		super();
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
	}
	@Override
	public String toString() {
		return "EstudanteDTO [nome=" + nome + ", email=" + email + ", matricula=" + matricula + "]";
	}
	
	
	

}
