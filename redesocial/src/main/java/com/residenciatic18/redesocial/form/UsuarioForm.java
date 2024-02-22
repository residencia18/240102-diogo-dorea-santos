package com.residenciatic18.redesocial.form;

import com.residenciatic18.redesocial.model.Usuario;

public class UsuarioForm {
	
	private String nome, email, senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioForm(String nome, String email, String senha) {
		
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario criaUsuario() {

		return new Usuario(this.nome, this.email, this.senha);
	}

}
