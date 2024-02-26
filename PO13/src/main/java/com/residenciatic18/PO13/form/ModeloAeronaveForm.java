package com.residenciatic18.PO13.form;

import com.residenciatic18.PO13.model.ModeloAeronave;

public class ModeloAeronaveForm {
	
	private String fabricante, nome;

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

	public ModeloAeronaveForm(String fabricante, String nome) {
		super();
		this.fabricante = fabricante;
		this.nome = nome;
	}

	public ModeloAeronaveForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ModeloAeronave criaModeloAeronave() {

		ModeloAeronave modeloAeronave = new ModeloAeronave();
		modeloAeronave.setFabricante(this.getFabricante());
		modeloAeronave.setNome(this.getNome());
		return modeloAeronave;
	}

}
