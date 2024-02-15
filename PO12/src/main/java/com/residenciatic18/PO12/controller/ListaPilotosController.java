package com.residenciatic18.PO12.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
	public ArrayList<Piloto> getTop5Pilotos() {
		
		
				
			
			ArrayList<Piloto> pilotos = ListaPilotosController.getPilotos();
			ArrayList<Piloto> top5 = new ArrayList<>();
			pilotos.sort(Comparator.comparingInt(Piloto::getVitorias).reversed());
			for (int i = 0; i < 5; i++) {
				top5.add(pilotos.get(i));
			}
				
			return top5;
			
			
		}
	
	@RequestMapping("/top10")
	public ArrayList<Piloto> getTop10Pilotos() {
		
		
				
			
			ArrayList<Piloto> pilotos = ListaPilotosController.getPilotos();
			ArrayList<Piloto> top10 = new ArrayList<>();
			pilotos.sort(Comparator.comparingInt(Piloto::getVitorias).reversed());
			for (int i = 0; i < 10; i++) {
				top10.add(pilotos.get(i));
			}
				
			return top10;
			
			
		}
	
	/*
	@RequestMapping("/porpais")
	public ArrayList<String> vitoriasPorPais() {
		
		
				
			
			ArrayList<Piloto> pilotos = ListaPilotosController.getPilotos();
			ArrayList<String> vitoriasPorPais = new ArrayList<String>();
			pilotos.sort(Comparator.comparingInt(Piloto::getVitorias).reversed());
			for (Piloto p : pilotos) {
				
				if (!vitoriasPorPais.contains(p.getPais())) {
					vitoriasPorPais.add(p.getPais()
							+ ": " + p.getVitorias()
							+ " vitorias");
				}
				
			}
				
			return vitoriasPorPais;
			
			
		}
	*/
	
	@RequestMapping("/porpais")
	public Map<String, Integer> listarVitóriasPorPaís() {
		ArrayList<Piloto> pilotos = ListaPilotosController.getPilotos();
        Map<String, Integer> vitóriasPorPaís = new HashMap<>();
        
        for (Piloto piloto : pilotos) {
            String país = piloto.getPais();
            int vitórias = piloto.getVitorias();
            vitóriasPorPaís.put(país, vitóriasPorPaís.getOrDefault(país, 0) + vitórias);
        }
        
        Map<String, Integer> vitóriasPorPaísOrdenado = new LinkedHashMap<>();
        vitóriasPorPaís.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .forEachOrdered(entry -> vitóriasPorPaísOrdenado.put(entry.getKey(), entry.getValue()));

        return vitóriasPorPaísOrdenado;
    }
	
		
	

}
