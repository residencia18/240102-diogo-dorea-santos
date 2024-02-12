package cliente;

import java.util.ArrayList;
import java.util.Scanner;

import persistencia.ClienteJson;

public class Cliente {	
	private String nome, cnh, cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	//metodo construtor
	public Cliente(String nome, String cpf, String cnh) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cnh = cnh;
	}
	
	public static void main(String[] args) {
		
		String nomeArquivo = "cliente.json";
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente1 = new Cliente("Diogo","1234", "4567");
		Cliente cliente2 = new Cliente("Tamires","7894", "4561");
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		ClienteJson.salvaCliente(nomeArquivo, clientes);
		ClienteJson.recuperaCliente(nomeArquivo);
		
		
		
	}
	
	
}
