package com.residenciatic18.leilaoSecretoOnLine.form;

import com.residenciatic18.leilaoSecretoOnLine.model.Leilao;

public class LeilaoForm {
	
	private String descricao;
	private double valorminimo;
	private boolean status;
	
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
	public LeilaoForm(String descricao, double valorminimo, boolean status) {
		super();
		this.descricao = descricao;
		this.valorminimo = valorminimo;
		this.status = status;
	}
	public LeilaoForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Leilao criaLeilao() {
		return new Leilao(this.descricao, this.valorminimo, this.status);
	}
	@Override
	public String toString() {
		return "LeilaoForm [descricao=" + descricao + ", valorminimo=" + valorminimo + ", status=" + status + "]";
	}
	
}
