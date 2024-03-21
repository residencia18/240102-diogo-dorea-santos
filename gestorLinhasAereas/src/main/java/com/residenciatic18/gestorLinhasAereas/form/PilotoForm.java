package com.residenciatic18.gestorLinhasAereas.form;

import com.residenciatic18.gestorLinhasAereas.model.Piloto;

public class PilotoForm {

	private String nome, numbreve;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumbreve() {
		return numbreve;
	}

	public void setNumbreve(String numbreve) {
		this.numbreve = numbreve;
	}

	public PilotoForm(String nome, String numbreve) {
		super();
		this.nome = nome;
		this.numbreve = numbreve;
	}

	public PilotoForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Piloto criaPiloto() {

		Piloto piloto = new Piloto();
		piloto.setNome(this.getNome());
		piloto.setNumBreve(this.getNumbreve());
		return piloto;
	}

}
