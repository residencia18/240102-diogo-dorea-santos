package com.residenciatic18.PP002.form;

import com.residenciatic18.PP002.model.Paciente;

public class PacienteForm {
private String nome, telefone, endereco;

	public PacienteForm() {
		super();
	}

	public PacienteForm(String nome, String telefone, String endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Paciente toModel() {
		// TODO Auto-generated method stub
		Paciente p = new Paciente();
		p.setNome(nome);
		p.setTelefone(telefone);
		p.setEndereco(endereco);
		return p;
	}
}
