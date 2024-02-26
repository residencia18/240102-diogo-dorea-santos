package com.residenciatic18.PO13.dto;

import com.residenciatic18.PO13.model.Usuario;

public class UsuarioDTO {
	
	private Long id;
	private String nome, email;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return nome;
	}
	
	public void setName(String name) {
		this.nome = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	

	public UsuarioDTO (Usuario usuario) {
		
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		
	}

}
