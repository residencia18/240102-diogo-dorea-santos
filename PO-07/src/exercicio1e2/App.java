package exercicio1e2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONObject;

public class App {
	
	private final static String nomeArquivo = "estudantes.json";
	
	public static void menuPrincipal() {
	    Scanner sc = new Scanner(System.in);
	    int opcao;

	    do {
	        System.out.println("Menu Principal");
	        System.out.println("1. Cadastrar Estudante");
	        System.out.println("2. Ler Arquivos Json Estudantes Cadastrados");
	        System.out.println("3. Limpar Arquivos Json Estudantes Cadastrados");
	        System.out.println("0. Sair");
	        System.out.println("Escolha uma opção:");

	        opcao = sc.nextInt();
	        sc.nextLine(); // Limpar o buffer do teclado

	        switch (opcao) {
	            case 1:
	                cadastrarEstudante();
	                break;
	            case 2: lerEstudantes();
	                break;
	            case 3: limparEstudantes();
	                break;
	            case 0:
	                System.out.println("Saindo do programa...");
	                break;
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	        }
	    } while (opcao != 0);
	}


	private static void lerEstudantes() {
		// TODO Auto-generated method stub
		
		try {
			FileReader fr = new FileReader(nomeArquivo);
			BufferedReader br = new BufferedReader(fr);
			
			String json_str;
			while ((json_str = br.readLine()) != null) {
				JSONObject my_obj = new JSONObject(json_str);
				System.out.println(my_obj);
			}
				
				br.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


	private static void cadastrarEstudante() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Cadastrar Estudante");
		
		System.out.println("Informe o nome:");
		String nome = sc.nextLine();
		System.out.println("Informe o cpf:");
		String cpf = sc.nextLine();
		System.out.println("Informe o CRA:");
		float cra = sc.nextFloat();
		System.out.println("Ano de Admissão:");
		int anoAdmissao = sc.nextInt();
		sc.nextLine();
		Estudante e = new Estudante(nome, cpf, cra, anoAdmissao);
		//String nomeArquivo = "estudantes.json";
		try {
			FileWriter fw = new FileWriter(nomeArquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String json_string = "{\"nome\":\"" + nome + "\",\"cpf\":\"" + cpf + "\",\"cra\":\"" + cra + "\",\"anoAdmissao\":\"" + anoAdmissao + "\"}";
			JSONObject my_obj = new JSONObject(json_string);
			bw.write(my_obj.toString());
			bw.newLine();
			bw.close();
			System.out.println("Estudante Cadastrado");
			return;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App.menuPrincipal();

	}
	
	public static void limparEstudantes() {
		
		try {
			FileWriter fw = new FileWriter(nomeArquivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.close();
			System.out.println("Arquivo limpo");
			return;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
