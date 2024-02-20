package com.residenciatic18.gestorLinhasAereas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Piloto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@Column(name = "numbreve")
	private String numBreve;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumBreve() {
		return numBreve;
	}
	public void setNumBreve(String numBreve) {
		this.numBreve = numBreve;
	}
	public Piloto(Integer id, String nome, String numBreve) {
		super();
		this.id = id;
		this.nome = nome;
		this.numBreve = numBreve;
	}
	public Piloto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Piloto [id=" + id + ", nome=" + nome + ", numBreve=" + numBreve + "]";
	}
	
	

}
