package Exercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiarArquivo {

	public static void main(String[] args) {
		
		String arquivoOrigem = "origem.txt";
        String arquivoDestino = "destino.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoOrigem));
             BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoDestino))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                bw.write(linha);
                bw.newLine();
            }

            System.out.println("Conteúdo do arquivo '" + arquivoOrigem + "' copiado para '" + arquivoDestino + "'.");
        } catch (IOException e) {
            System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
        }

	}

}
