package exercicio1e2;

public class Estudante {
	private String nome,cpf;
	private float cra;
	private int anoAdmissao;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public float getCra() {
		return cra;
	}
	public void setCra(float cra) {
		this.cra = cra;
	}
	public int getAnoAdmissao() {
		return anoAdmissao;
	}
	public void setAnoAdmissao(int anoAdmissao) {
		this.anoAdmissao = anoAdmissao;
	}
	public Estudante(String nome, String cpf, float cra, int anoAdmissao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cra = cra;
		this.anoAdmissao = anoAdmissao;
	}
	public Estudante() {
		super();
		// TODO Auto-generated constructor stub
	}

}
