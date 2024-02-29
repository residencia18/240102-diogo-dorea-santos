package com.residenciatic18.leilaoSecretoOnLine.dto;

import com.residenciatic18.leilaoSecretoOnLine.model.Leilao;

public class LeilaoDTO {
	
	private Long id;
	private String descricao;
	private double valorminimo;
	private boolean status;
	
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public LeilaoDTO(Leilao leilao) {
		super();
		this.id = leilao.getId();
		this.descricao = leilao.getDescricao();
		this.valorminimo = leilao.getValorminimo();
		this.status = leilao.getStatus();
		
	}
	public LeilaoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Leilao [id=" + id + ", descricao=" + descricao + ", valorminimo=" + valorminimo + ", status=" + status
				+ "]";
	}

}
