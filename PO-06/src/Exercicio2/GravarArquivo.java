package Exercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GravarArquivo {

	public static void main(String[] args) {
		
		String nomeArquivo = "saida.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite as linhas de texto (digite 'fim' para encerrar):");

            String linha;
            while (!(linha = scanner.nextLine()).equalsIgnoreCase("fim")) {
                bw.write(linha);
                bw.newLine();
            }

            System.out.println("As linhas foram gravadas no arquivo '" + nomeArquivo + "'.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }			
		
	}

}
