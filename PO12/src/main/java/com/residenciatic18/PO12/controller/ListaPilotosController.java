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
	public Map<String, Integer> listarVitoriasPorPais() {
		ArrayList<Piloto> pilotos = ListaPilotosController.getPilotos();
        Map<String, Integer> vitoriasPorPais = new HashMap<>();
        
        for (Piloto piloto : pilotos) {
            String pais = piloto.getPais();
            int vitorias = piloto.getVitorias();
            vitoriasPorPais.put(pais, vitoriasPorPais.getOrDefault(pais, 0) + vitorias);
        }
        
        Map<String, Integer> vitoriasPorPaisOrdenado = new LinkedHashMap<>();
        vitoriasPorPais.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .forEachOrdered(entry -> vitoriasPorPaisOrdenado.put(entry.getKey(), entry.getValue()));

        return vitoriasPorPaisOrdenado;
    }
	
	@RequestMapping("/mediaporpais")
	public Map<String, Double> listarMediaVitoriasPorPais() {
		ArrayList<Piloto> pilotos = ListaPilotosController.getPilotos();
        Map<String, Integer> totalVitoriasPorPais = new HashMap<>();
        Map<String, Integer> totalVencedoresPorPais = new HashMap<>();

        for (Piloto piloto : pilotos) {
            String pais = piloto.getPais();
            int vitorias = piloto.getVitorias();
            totalVitoriasPorPais.put(pais, totalVitoriasPorPais.getOrDefault(pais, 0) + vitorias);
            totalVencedoresPorPais.put(pais, totalVencedoresPorPais.getOrDefault(pais, 0) + 1);
        }

        Map<String, Double> mediaVitoriasPorPais = new HashMap<>();
        for (Map.Entry<String, Integer> entry : totalVitoriasPorPais.entrySet()) {
            String pais = entry.getKey();
            int totalVitorias = entry.getValue();
            int totalVencedores = totalVencedoresPorPais.get(pais);
            double média = (double) totalVitorias / totalVencedores;
            mediaVitoriasPorPais.put(pais, média);
        }

        Map<String, Double> mediaVitoriasPorPaisOrdenada = new LinkedHashMap<>();
        mediaVitoriasPorPais.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> mediaVitoriasPorPaisOrdenada.put(entry.getKey(), entry.getValue()));

        return mediaVitoriasPorPaisOrdenada;
    }
}
