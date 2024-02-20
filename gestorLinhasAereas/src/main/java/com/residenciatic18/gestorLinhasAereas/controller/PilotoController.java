package com.residenciatic18.gestorLinhasAereas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.residenciatic18.gestorLinhasAereas.model.Piloto;
import com.residenciatic18.gestorLinhasAereas.repository.PilotoRepository;

@RestController
@RequestMapping("/pilotos/")
public class PilotoController {
	
	@Autowired private PilotoRepository pilotorepository;
	
	@GetMapping
	public ArrayList<Piloto> getPiloto(String nome) {
		
		ArrayList<Piloto> pilotos = new ArrayList<>();
		
		if (nome == null) {
			pilotos = (ArrayList<Piloto>) pilotorepository.findAll();
		}
		else {
			pilotos = (ArrayList<Piloto>) pilotorepository.findByNome(nome);
		}
		return pilotos;
		
	}

}
