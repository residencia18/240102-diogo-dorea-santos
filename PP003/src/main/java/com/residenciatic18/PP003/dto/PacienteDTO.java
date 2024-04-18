package com.residenciatic18.PP003.dto;

import com.residenciatic18.PP003.model.Paciente;

public class PacienteDTO {
    
    private Long id;
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

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public PacienteDTO(Paciente paciente) {
		
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.telefone = paciente.getTelefone();
		this.endereco = paciente.getEndereco();
	}

	public PacienteDTO() {
		super();
	}

}
