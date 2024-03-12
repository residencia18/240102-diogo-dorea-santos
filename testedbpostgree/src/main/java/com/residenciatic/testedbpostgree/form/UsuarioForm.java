package com.residenciatic.testedbpostgree.form;

import com.residenciatic.testedbpostgree.model.Usuario;

public class UsuarioForm {
	private String login, email, senha;
	
	public UsuarioForm() {
		
	}
	
	public UsuarioForm(String login, String email, String senha) {
		
		this.login = login;
		this.email = email;
		this.senha = senha;
		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public Usuario toModel() {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		u.setLogin(login);
		u.setEmail(email);
		u.setSenha(senha);
		return u;
	}

}