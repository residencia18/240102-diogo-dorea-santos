package transporteViario;

public class Motorista extends Pessoa{
	
	private String cnh, ctps;

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	

	@Override
	public String toString() {
		return "Motorista [cnh=" + cnh + ", ctps=" + ctps + ", Nome= " + getNome() + ", CPF= " + getCpf() + "]";
	}

	public Motorista(String nome, String cpf, String cnh, String ctps) {
		super(nome, cpf);
		this.cnh = cnh;
		this.ctps = ctps;
	}
	
	public Motorista() {
		super();
	}
	
	
	
	
	
	
	

}
