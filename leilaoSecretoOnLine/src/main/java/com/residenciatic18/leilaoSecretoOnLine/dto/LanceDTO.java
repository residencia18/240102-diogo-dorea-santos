package com.residenciatic18.leilaoSecretoOnLine.dto;

import com.residenciatic18.leilaoSecretoOnLine.model.Concorrente;
import com.residenciatic18.leilaoSecretoOnLine.model.Lance;
import com.residenciatic18.leilaoSecretoOnLine.model.Leilao;

public class LanceDTO {
	
	private Long id;
	private Leilao leilao;
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
	public LanceDTO(Lance lance) {
		super();
		this.id = lance.getId();
		this.leilao = lance.getLeilao();
		this.concorrente = lance.getConcorrente();
		this.valor = lance.getValor();
		
	}
	public LanceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Lance [id=" + id + ", leilao=" + leilao + ", valor=" + valor + "]";
	}

}
