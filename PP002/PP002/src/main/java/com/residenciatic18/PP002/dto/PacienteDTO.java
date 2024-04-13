package com.residenciatic18.PP002.dto;

import com.residenciatic18.PP002.model.Paciente;

public class PacienteDTO {
	private String nome, telefone, endereco;
	private Long id;

	public PacienteDTO() {
		super();
	}

	public PacienteDTO(Long id, String nome, String telefone, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
		
		Paciente p = new Paciente();
		p.setId(id);
		p.setNome(nome);
		p.setTelefone(telefone);
		p.setEndereco(endereco);
		return p;
	}

}
