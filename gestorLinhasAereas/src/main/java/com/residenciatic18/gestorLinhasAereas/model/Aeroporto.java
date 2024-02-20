package com.residenciatic18.gestorLinhasAereas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aeroporto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String icao; //The International Civil Aviation Organization (ICAO) code for the airport
	private String nome;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIcao() {
		return icao;
	}
	public void setIcao(String icao) {
		this.icao = icao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Aeroporto(Integer id, String icao, String nome) {
		super();
		this.id = id;
		this.icao = icao;
		this.nome = nome;
	}
	public Aeroporto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Aeroporto [id=" + id + ", icao=" + icao + ", nome=" + nome + "]";
	}
	
	

}
