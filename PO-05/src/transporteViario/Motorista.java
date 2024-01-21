package transporteViario;

public class Motorista extends Pessoa{
	
	private int cnh, ctps;

	public int getCnh() {
		return cnh;
	}

	public void setCnh(int cnh) {
		this.cnh = cnh;
	}

	public int getCtps() {
		return ctps;
	}

	public void setCtps(int ctps) {
		this.ctps = ctps;
	}

	public Motorista(String nome, int cpf, int cnh, int ctps) {
		super(nome, cpf);
		this.cnh = cnh;
		this.ctps = ctps;
	}
	
	
	
	
	
	
	

}
