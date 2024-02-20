package com.residenciatic18.gestorLinhasAereas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.residenciatic18.gestorLinhasAereas.model.ModeloAeronave;
import com.residenciatic18.gestorLinhasAereas.repository.ModeloAeronaveRepository;

@RestController
@RequestMapping("/modeloaeronaves/")
public class ModeloAeronaveController {
	
	@Autowired private ModeloAeronaveRepository modeloaeronaverepository;
	
	@GetMapping
	public ArrayList<ModeloAeronave> getModeloAeronave(String nome) {
		
		ArrayList<ModeloAeronave> modeloaeronaves = new ArrayList<>();
		
		if (nome == null) {
			 modeloaeronaves = (ArrayList<ModeloAeronave>) modeloaeronaverepository.findAll();
		}
		else {
			modeloaeronaves = (ArrayList<ModeloAeronave>) modeloaeronaverepository.findByNome(nome);	
		}
		return modeloaeronaves;
		
		
	}
}
