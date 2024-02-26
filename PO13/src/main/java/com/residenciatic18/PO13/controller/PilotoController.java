package com.residenciatic18.PO13.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residenciatic18.PO13.form.PilotoForm;
import com.residenciatic18.PO13.model.Piloto;
import com.residenciatic18.PO13.repository.PilotoRepository;

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
	
	@PostMapping
	public Piloto inserir(@RequestBody PilotoForm pf) {

		Piloto p = pf.criaPiloto();
		pilotorepository.save(p);
		return p;
	}

}
