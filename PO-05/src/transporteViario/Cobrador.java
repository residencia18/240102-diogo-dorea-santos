package transporteViario;

public class Cobrador extends Pessoa{
	
	private String ctps;

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	
	
	
	@Override
	public String toString() {
		return "Cobrador [ctps= " + ctps + ", Nome= " + getNome() + ", CPF= " + getCpf() + "]";
	}

	public Cobrador(String nome, String cpf, String ctps) {
		super(nome, cpf);
		this.ctps = ctps;
	}
	
	

}
