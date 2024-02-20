package com.residenciatic18.gestorLinhasAereas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "modeloaeronave")
public class ModeloAeronave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fabricante;
	private String nome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ModeloAeronave(Integer id, String fabricante, String nome) {
		super();
		this.id = id;
		this.fabricante = fabricante;
		this.nome = nome;
	}
	public ModeloAeronave() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ModeloAeronave [id=" + id + ", fabricante=" + fabricante + ", nome=" + nome + "]";
	}
	
	

}
