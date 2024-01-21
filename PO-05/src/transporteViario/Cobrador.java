package transporteViario;

public class Cobrador extends Pessoa{
	
	private int ctps;

	public int getCtps() {
		return ctps;
	}

	public void setCtps(int ctps) {
		this.ctps = ctps;
	}

	public Cobrador(String nome, int cpf, int ctps) {
		super(nome, cpf);
		this.ctps = ctps;
	}
	
	

}
