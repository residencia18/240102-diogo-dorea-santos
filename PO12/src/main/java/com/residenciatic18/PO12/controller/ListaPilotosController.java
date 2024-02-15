package com.residenciatic18.PO12.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import model.Piloto;

@RestController
public class ListaPilotosController {
	
	//private static ArrayList<Piloto> pilotos = ListaPilotosController.getPilotos();
	
	@RequestMapping("/todos")
	public static ArrayList<Piloto> getPilotos() {
		
		try {
			String nomeArquivo = "pilotos.csv";
			FileReader fr = new FileReader(nomeArquivo);
			BufferedReader br = new BufferedReader(fr);	
			
			ArrayList<Piloto> pilotos = new ArrayList<>();
			String linha = br.readLine();
			while(linha != null) {
				
				String[] dados = linha.split(";");
				Piloto p = new Piloto(dados[0], dados[1], Integer.parseInt(dados[2]));
				pilotos.add(p);
				linha = br.readLine();
			}
			br.close();
			fr.close();
			return pilotos;
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(pilotos.toString());
		return null;
		
	}
	
	@RequestMapping("/")
	public String Hello() {
		String h = "Hello";
		return h;
	}
	
	@RequestMapping("/brasileiros")
	public ArrayList<Piloto> getPilotosBrasileiros() {
		
		
				
			
			ArrayList<Piloto> pilotos = ListaPilotosController.getPilotos();
			ArrayList<Piloto> brasileiros = new ArrayList<>();
			for (Piloto p : pilotos) {
				
				if (p.getPais().equals("Brasil")) {
					brasileiros.add(p);
				}
				
			}
				
			return brasileiros;
			
			
		}
		
	
	
	@RequestMapping("/top5")
	public ArrayList<Piloto> getPilotosTop5() {
		
		try {
			String nomeArquivo = "pilotos.csv";
			FileReader fr = new FileReader(nomeArquivo);
			BufferedReader br = new BufferedReader(fr);	
			
			ArrayList<Piloto> pilotos = new ArrayList<>();
			String linha = br.readLine();
			while(linha != null) {
				
				String[] dados = linha.split(";");
				Piloto p = new Piloto(dados[0], dados[1], Integer.parseInt(dados[2]));
				if (p.getVitorias() >= 5) {
					pilotos.add(p);
				}
				linha = br.readLine();
			}
			br.close();
			fr.close();
			return pilotos;
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(pilotos.toString());
		return null;
	}
		
	

}
