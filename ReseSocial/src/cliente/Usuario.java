package cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String nome, email, nacionalidade;
	private ArrayList<String> postagens;
	private String postagem;
	private int quantidadeDePostagens;
	
	public Usuario() {
		postagens = new ArrayList<String>();
		this.setQuantidadeDePostagens(0);
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


	public String getNacionalidade() {
		return nacionalidade;
	}


	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
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

	public void setQuantidadeDePostagens(int quantidadeDePostagens) {
		this.quantidadeDePostagens = quantidadeDePostagens;
	}

	public void adicionaPostagens(String post) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o nome do usuario: ");
		usuario.setNome(sc.nextLine());
		System.out.println("Digite o email do usuario: ");
		usuario.setEmail(sc.nextLine());
		System.out.println("Digite o nacionalidade do usuario: ");
		usuario.setNacionalidade(sc.nextLine());
		System.out.println("Digite a sua postagem: ");
		usuario.setPostagem(sc.nextLine());
		usuario.adicionaPostagens(usuario.getPostagem());
		
		
		
	}

}
