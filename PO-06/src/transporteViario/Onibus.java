package transporteViario;

public class Onibus extends Veiculo{
	
	private String modelo;
	private String numero;
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "Onibus [modelo=" + modelo + ", numero=" + numero + ", Placa=" + getPlaca() + ", Chassi="
				+ getChassi() + ", Fabricante=" + getFabricante() + ", Renavam=" + getRenavam()
				+ ", Ano=" + getAno() + "]";
	}
	public Onibus(String placa, String renavam, String ano, String chassi, String fabricante, String numero, String modelo) {
		super(placa, chassi, fabricante, renavam, ano);
		this.modelo = modelo;
		this.numero = numero;
	}
	
	

}
