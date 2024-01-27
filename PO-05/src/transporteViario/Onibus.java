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
	
	@Override
	public String toString() {
		return "Onibus [modelo=" + modelo + ", numero=" + numero + ", Placa=" + getPlaca() + ", Chassi="
				+ getChassi() + ", Fabricante=" + getFabricante() + ", Renavam=" + getRenavam()
				+ ", Ano=" + getAno() + "]";
	}
	public Onibus(String placa, String renavam, int ano, String chassi, String fabricante, int numero, String modelo) {
		super(placa, chassi, fabricante, renavam, ano);
		this.modelo = modelo;
		this.numero = numero;
	}
	
	

}
