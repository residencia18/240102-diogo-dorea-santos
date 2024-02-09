package com.resideciatic18.controleacademico.lerarquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
	
	public String ler() {
		
		
	        String nomeArquivo = "arquivotexto.txt";

	        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
	            String linha;

	            while ((linha = br.readLine()) != null) {
	                System.out.println(linha);
	                return linha;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    
	}

}
