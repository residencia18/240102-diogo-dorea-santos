package com.residenciatic18.PP003.form;

import com.residenciatic18.PP003.model.Paciente;

public class PacienteForm {
private String nome, telefone, endereco;

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
	
	public PacienteForm(String nome, String telefone, String endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public PacienteForm() {
		super();
	}

	public Paciente toModel() {
		return new	Paciente(this.nome, this.telefone, this.endereco);
	}
}
