package com.resideciatic18.redesocial.controller.dto;

import com.resideciatic18.redesocial.model.Usuario;

public class UsuarioDTO {
	
	private long id;
	private String name, email;
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public UsuarioDTO (Usuario usuario) {
		
		this.id = usuario.getId();
		this.name = usuario.getName();
		this.email = usuario.getEmail();
		
	}
}
