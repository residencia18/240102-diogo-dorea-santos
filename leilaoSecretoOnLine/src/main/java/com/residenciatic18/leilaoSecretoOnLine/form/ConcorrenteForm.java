package com.residenciatic18.leilaoSecretoOnLine.form;

import com.residenciatic18.leilaoSecretoOnLine.model.Concorrente;

public class ConcorrenteForm {
	
	private String nome;
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public ConcorrenteForm(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	public ConcorrenteForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Concorrente criaConcorrente() {
		return new Concorrente(this.nome, this.cpf);
	}
	@Override
	public String toString() {
		return "Concorrente [nome=" + nome + ", cpf=" + cpf + "]";
	}
}
