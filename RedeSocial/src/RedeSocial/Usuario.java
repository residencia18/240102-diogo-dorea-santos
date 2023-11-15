package RedeSocial;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String nome, email, nacionalidade;
	private ArrayList<String> postagens;
	private String postagem;
	private int quantidadeDePostagens, pontuacao;
	
	//COntrutor para o passo 1 do exercicio
	/*
	public Usuario() {
		postagens = new ArrayList<String>();
		this.setQuantidadeDePostagens(0);
		this.setPontuacao(0);
	}
	*/
	
	public Usuario(String _nomeUsuario) {
		postagens = new ArrayList<String>();
		this.setQuantidadeDePostagens(0);
		this.setPontuacao(0);
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
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public void setQuantidadeDePostagens(int quantidadeDePostagens) {
		this.quantidadeDePostagens = quantidadeDePostagens;
	}

	public void adicionaPostagens(String post) {
		quantidadeDePostagens++;		
	}
	public void alteraPontuacao(int delta) {
		pontuacao += delta;
	}
	
		
	//Metodo main
	public static void main(String[] args) {
		
		//Passo 1 do exercicio
		/*
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
		*/
		
		//Passo 2 do exercicio
		
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		Scanner sc = new Scanner(System.in);
		
		String sn;
		do {
			System.out.println("Digite o nome do usuário: ");
			String nomeUsuario = sc.nextLine();
			Usuario usuario = new Usuario(nomeUsuario);
			System.out.println("Digite o email do usuario: ");
			usuario.setEmail(sc.nextLine());
			System.out.println("Digite o nacionalidade do usuario: ");
			usuario.setNacionalidade(sc.nextLine());
			System.out.println("Digite a sua postagem: ");
			usuario.setPostagem(sc.nextLine());
			usuario.adicionaPostagens(usuario.getPostagem());
			listaUsuario.add(usuario);
			System.out.println("deseja inserir mais um usuario: s ou n");
			sn = sc.nextLine();
			System.out.println(sn);
		} while (!sn.equals("n"));	
		sc.close();
		
		for (int i = 0; i < listaUsuario.size(); i++) {
			System.out.println(listaUsuario.get(i).getPostagem());
			
		}
		
	}

}
