package com.residenciatic18.leilaoSecretoOnLine.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Concorrente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)private Long id;
	private String nome;
	private String cpf;
	@OneToMany(mappedBy = "concorrente")
	List<Lance> lances;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Concorrente(String nome, String cpf) {
		super();
		this.id = null;
		this.nome = nome;
		this.cpf = cpf;
	}
	public Concorrente() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Concorrente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	
	

}
