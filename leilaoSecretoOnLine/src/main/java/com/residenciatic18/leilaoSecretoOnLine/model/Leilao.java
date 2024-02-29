package com.residenciatic18.leilaoSecretoOnLine.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Leilao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private double valorminimo;
	private boolean status;
	@OneToMany(mappedBy = "leilao")
	List<Lance> lances;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorminimo() {
		return valorminimo;
	}
	public void setValorminimo(double valorminimo) {
		this.valorminimo = valorminimo;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Leilao(String descricao, double valorminimo, boolean status) {
		super();
		this.id = null;
		this.descricao = descricao;
		this.valorminimo = valorminimo;
		this.status = status;
	}
	public Leilao() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Leilao [id=" + id + ", descricao=" + descricao + ", valorminimo=" + valorminimo + ", status=" + status
				+ "]";
	}
	
	

}
