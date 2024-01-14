package UsuarioArquivo;

import java.util.ArrayList;

public class Usuario {
	private String nome, email, senha, postagem;
	private ArrayList<String> postagens;
	private int quantidadeDePostagens;
	
	public Usuario(String _nomeUsuario) {
		postagens = new ArrayList<String>();
		this.setNome(_nomeUsuario);
	}	

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
	
	public String getPostagem() {
		return postagem;
	}

	public void setPostagem(String postagem) {
		this.postagem = postagem;
	}
	
	public int getQuantidadeDePostagens() {
		return quantidadeDePostagens;
	}
	
	public void adicionaPostagens(String post) {
		postagens.add(post);
		quantidadeDePostagens++;		
	}

	public void removePostagens(String post) {
		postagens.remove(post);
		quantidadeDePostagens--;
	}
	
}
