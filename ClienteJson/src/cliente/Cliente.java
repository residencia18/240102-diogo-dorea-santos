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
				
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente1 = new Cliente("nome do cliente","cpf do cliente", "cnh do cliente");
		Cliente cliente2 = new Cliente("nome do cliente2","cpf do cliente2", "cnh do cliente2");
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		ClienteJson.salvaCliente("cliente.json", clientes);
		
		
		
	}
	
	
}
