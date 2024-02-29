package com.residenciatic18.leilaoSecretoOnLine.dto;

import com.residenciatic18.leilaoSecretoOnLine.model.Concorrente;

public class ConcorrenteDTO {

	private Long id;
	private String nome;
	private String cpf;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public ConcorrenteDTO(Concorrente concorrente) {
		super();
		this.id = concorrente.getId();
		this.nome = concorrente.getNome();
		this.cpf = concorrente.getCpf();
		
	}
	public ConcorrenteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Concorrente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}

}
