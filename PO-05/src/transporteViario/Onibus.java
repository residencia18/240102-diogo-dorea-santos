package transporteViario;

public class Onibus extends Veiculo{
	
	private String modelo;
	private int numero;
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Onibus(String placa, String chassi, String fabricante, int renavam, int ano, String modelo, int numero) {
		super(placa, chassi, fabricante, renavam, ano);
		this.modelo = modelo;
		this.numero = numero;
	}
	
	

}
