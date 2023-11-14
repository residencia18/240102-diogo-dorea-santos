package Cliente;

import java.util.Scanner;

public class cliente {	
	private String nome;
	private int idade;
	private String cpf;
	
	//Gerando gets e sets
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	//metodo construtor
	public cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nome: ");
		
		System.out.println("cpf: ");
		cliente Cliente1 = new cliente("Alan", "07305047511");
	}
	
	
}
