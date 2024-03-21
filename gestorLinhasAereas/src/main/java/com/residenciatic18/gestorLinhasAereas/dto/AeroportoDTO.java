package com.residenciatic18.gestorLinhasAereas.dto;

import com.residenciatic18.gestorLinhasAereas.model.Aeroporto;

public class AeroportoDTO {
	
	private Integer id;
	private String nome, icao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public AeroportoDTO(Aeroporto a) {
		super();
		this.id = a.getId();
		this.nome = a.getNome();
		this.icao = a.getIcao();
	}

}
