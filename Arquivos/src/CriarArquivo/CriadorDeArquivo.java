package CriarArquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class CriadorDeArquivo {

	public static void main(String[] args) throws IOException {
		String Arquivo, Texto;
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o nome do arquivo");
		Arquivo = sc.nextLine();
		File doc = new File(Arquivo);
		FileWriter fw = new FileWriter(doc);
		BufferedWriter bw = new BufferedWriter(fw);
		System.out.println("Informe o texto do arquivo");
		Texto = sc .nextLine();
		bw.write(Texto);
		bw.newLine();
		bw.close();
		fw.close();
		sc.close();
	}

}
