package com.residenciatic18.PP003.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Paciente {
	private String nome, telefone, endereco;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "paciente")
	private List<Resultado> resultados;
	

	public Paciente() {
		super();
	}

	public Paciente(String nome, String telefone, String endereco, Long id) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
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

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Paciente [nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + "]";
	}
}
