package CriarArquivo;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class LeitorDeArquivo {

	public static void main(String[] args) throws IOException {
		String Arquivo, Texto;
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o nome do arquivo");
		Arquivo = sc.nextLine();
		FileReader fr = new FileReader(Arquivo);
		BufferedReader br = new BufferedReader(fr);
		
		while (br.ready()) {
			Texto = br.readLine();
			System.out.println(Texto);
		}
		
		br.close();
		fr.close();
		sc.close();
	}

}
