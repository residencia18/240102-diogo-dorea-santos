package UsuarioArquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
	
	private ArrayList<Usuario> listaUsuario;
	
	public Usuarios() {
		listaUsuario = new ArrayList<>();
	}
		
	public void inserirUsuario() throws IOException {
	
	Scanner sc = new Scanner(System.in);
	String sn;
	do {
		System.out.println("Digite o nome do usuário: ");
		Usuario usuario = new Usuario(sc.nextLine());
		System.out.println("Digite o email do usuario: ");
		usuario.setEmail(sc.nextLine());
		System.out.println("Digite o senha do usuario: ");
		usuario.setSenha(sc.nextLine());
		System.out.println("Digite a sua postagem inicial: ");
		usuario.setPostagem(sc.nextLine());
		usuario.adicionaPostagens(usuario.getPostagem());
		listaUsuario.add(usuario);
		File doc = new File("ListaUsuarios.csv");
		FileWriter fw = new FileWriter(doc);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(usuario.getNome()+usuario.getEmail()+usuario.getSenha());
		bw.newLine();
		bw.close();
		fw.close();
		System.out.println("deseja inserir mais um usuario: s ou n");
		sn = sc.nextLine();
		System.out.println(sn);
		sc.close();
	} while (!sn.equals("n"));	
	sc.close();
	
	for (int i = 0; i < listaUsuario.size(); i++) {
		System.out.println(listaUsuario.get(i).getPostagem());
	}
}

public static void main(String[] args) throws IOException {
	
		Usuarios usuarios = new Usuarios();
		
		Scanner sc = new Scanner(System.in);
		int opcao;
		System.out.println("Escolha uma opção\n");
		System.out.println("1. InserirUsuario \n2. BuscarUsuario \n3. Listar Usuarios \n4. Excluir Usuarios");
		opcao = sc.nextInt();
		
		switch (opcao) {
		
		case 1: usuarios.inserirUsuario();
		}
		
		
	}
}
