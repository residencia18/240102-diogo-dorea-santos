package transporteViario;

public class Veiculo {
	
	private String placa, chassi, fabricante, renavam;
	private int ano;
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Veiculo(String placa, String chassi, String fabricante, String renavam, int ano) {
		
		this.placa = placa;
		this.chassi = chassi;
		this.fabricante = fabricante;
		this.renavam = renavam;
		this.ano = ano;
	}
	
	
	

}
