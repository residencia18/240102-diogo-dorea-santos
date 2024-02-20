package com.residenciatic18.gestorLinhasAereas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.residenciatic18.gestorLinhasAereas.model.Aeroporto;
import com.residenciatic18.gestorLinhasAereas.repository.AeroportoRepository;

@RestController
@RequestMapping("/aeroportos/")
public class AeroportoController {
	
	@Autowired private AeroportoRepository aeroportorepository;
	
	@GetMapping
	public ArrayList<Aeroporto> getAeroporto(String nome) {
		
		ArrayList<Aeroporto> aeroportos = new ArrayList<>();
		if (nome == null) {
			 aeroportos = (ArrayList<Aeroporto>) aeroportorepository.findAll();
		}
		else {
			aeroportos = (ArrayList<Aeroporto>) aeroportorepository.findByNome(nome);	
		}
		return aeroportos;
	}
	
	

}
