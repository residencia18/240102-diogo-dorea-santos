package Veiculos;

public class Veiculo {
	private String modelo,cor;
	private int ano;
	
	public Veiculo() {
		
	}
	
	public Veiculo(String modelo, String cor, int ano) {
		this.modelo=modelo;
		this.cor=cor;
		this.ano=ano;
	}
	
	public void exibir() {
		System.out.println(this);
	}
}
