package Exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
	
	private String modelo;
	private String cor;
	private int ano;

	// Construtor
	public Veiculo(String modelo, String cor, int ano) {
	    this.modelo = modelo;
	    this.cor = cor;
	    this.ano = ano;
	}
	// Getters e Setters

	public String getModelo() {
	    return modelo;
	}

	public void setModelo(String modelo) {
	    this.modelo = modelo;
	}

	public String getCor() {
	    return cor;
	}

	public void setCor(String cor) {
	    this.cor = cor;
	}

	public int getAno() {
	    return ano;
	}

	public void setAno(int ano) {
	    this.ano = ano;
	}

	// Métodos comuns
	public void acelerar() {
	    System.out.println("Veículo acelerando");
	}

	public void ligar() {
	    System.out.println("Veículo ligado");
	}

	public void parar() {
	    System.out.println("Veículo parado");
	}

	public static void main(String[] args) {
	    
	    Carro meuCarro = new Carro("Fiat", "Preto", 2023);
	    Moto minhaMoto = new Moto("Honda", "Vermelho", 2022);

	    // Polimorfismo
	    Veiculo veiculo1 = meuCarro;
	    Veiculo veiculo2 = minhaMoto;

	    veiculo1.ligar();
	    veiculo1.acelerar();
	    //Carro não sobrescreve metodo parar, logo, o acesso é para o metodo da superclasse. 
	    veiculo1.parar();

	    System.out.println("-----------------");

	    veiculo2.ligar();
	    veiculo2.acelerar();
	    veiculo2.parar();

	    // Acesso a métodos específicos
	    ((Carro) veiculo1).abrirPortas();
	    ((Moto) veiculo2).descerMacaco();
	}
}


class Carro extends Veiculo {
public Carro(String modelo, String cor, int ano) {
    super(modelo, cor, ano);
}

@Override
public void ligar() {
    System.out.println("Carro ligado");
}

@Override
public void acelerar() {
    System.out.println("Carro acelerando");
}

// Método específico
public void abrirPortas() {
    System.out.println("Portas do carro abertas");
}
}

class Moto extends Veiculo {
public Moto(String modelo, String cor, int ano) {
    super(modelo, cor, ano);
}

@Override
public void ligar() {
    System.out.println("Moto ligada");
}

@Override
public void acelerar() {
    System.out.println("Moto acelerando");
}

// Método específico
public void descerMacaco() {
    System.out.println("Moto apoiada no macaco");
}
}

class Garagem {
	
    private List<Veiculo> veiculos;
    private boolean tomadaEletrica;

    public Garagem(boolean _tomadaEletrica) {
        this.veiculos = new ArrayList<>();
        this.tomadaEletrica = _tomadaEletrica;
    }

    public void estacionar(Veiculo veiculo) {
        veiculos.add(veiculo);
        System.out.println(veiculo.getModelo() + " estacionado na garagem.");
    }

    public void remover(Veiculo veiculo) {
        if (veiculos.remove(veiculo)) {
            System.out.println(veiculo.getModelo() + " removido da garagem.");
        } else {
            System.out.println(veiculo.getModelo() + " não encontrado na garagem.");
        }
    }

    public boolean temTomadaEletrica() {
        return tomadaEletrica;
    }

    public void setTomadaEletrica(boolean temTomadaEletrica) {
        this.tomadaEletrica = temTomadaEletrica;
    }
}


