package com.residenciatic18.gestorLinhasAereas.form;

import com.residenciatic18.gestorLinhasAereas.model.Aeroporto;

public class AeroportoForm {
	private String nome, icao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	public AeroportoForm(String nome, String icao) {
		super();
		this.nome = nome;
		this.icao = icao;
	}

	public AeroportoForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Aeroporto criaAeroporto() {

		Aeroporto aeroporto = new Aeroporto();
		aeroporto.setNome(this.getNome());
		aeroporto.setIcao(this.getIcao());
		return aeroporto;
	}
	
}
