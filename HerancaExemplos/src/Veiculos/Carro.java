package Veiculos;

public class Carro extends Veiculo{
	private int numPortas;
	private boolean tag=false;
	
	public Carro(String modelo, String cor, int ano, int _numPortas) {
		super(modelo, cor, ano);
		this.numPortas = _numPortas;
	}
	
	public Carro(String modelo, String cor, int ano, boolean tag) {
		super(modelo, cor, ano);
		if (tag) {
			System.out.println(this.numPortas);
		}
		
	}
	
	public void exibir() {
		super.exibir();
		System.out.println(this.numPortas);
		
	}
	
}
