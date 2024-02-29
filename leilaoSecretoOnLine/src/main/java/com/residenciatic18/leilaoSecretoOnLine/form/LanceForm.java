package com.residenciatic18.leilaoSecretoOnLine.form;

import com.residenciatic18.leilaoSecretoOnLine.model.Concorrente;
import com.residenciatic18.leilaoSecretoOnLine.model.Lance;
import com.residenciatic18.leilaoSecretoOnLine.model.Leilao;

public class LanceForm {
	
	private Leilao leilao;
	private Concorrente concorrente;
	private double valor;
	
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
	public LanceForm(Leilao leilao, Concorrente concorrente, double valor) {
		super();
		this.leilao = leilao;
		this.concorrente = concorrente;
		this.valor = valor;
	}
	public LanceForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Lance criaLance() {
		return new Lance(leilao, concorrente, valor);
	}
	@Override
	public String toString() {
		return "LanceForm [leilao=" + leilao + ", concorrente=" + concorrente + ", valor=" + valor + "]";
	}
	

}
