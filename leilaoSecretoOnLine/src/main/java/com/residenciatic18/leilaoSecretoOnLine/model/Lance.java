package com.residenciatic18.leilaoSecretoOnLine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "leilao_id")
	private Leilao leilao;
	@ManyToOne
	@JoinColumn(name = "concorrente_id")
	private Concorrente concorrente;
	private double valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Leilao getLeilao() {
		return leilao;
	}
	public void setLeilao(Leilao leilao) {
		this.leilao = leilao;
	}
	public Concorrente getConcorrente() {
		return concorrente;
	}
	public void setConcorrente(Concorrente concorrente) {
		this.concorrente = concorrente;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Lance(Leilao leilao, Concorrente concorrente, double valor) {
		super();
		this.id = null;
		this.leilao = leilao;
		this.concorrente = concorrente;
		this.valor = valor;
	}
	public Lance() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Lance [id=" + id + ", leilao=" + leilao + ", valor=" + valor + "]";
	}
	
	
	

}
