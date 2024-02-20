package com.residenciatic18.gestorLinhasAereas.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.residenciatic18.gestorLinhasAereas.dao.PilotoDAO;
import com.residenciatic18.gestorLinhasAereas.model.Piloto;

@RestController
public class PilotoController {
	
	@RequestMapping("/pilotos")
	public ArrayList<Piloto> getPiloto() {
		
		return PilotoDAO.readAll();	
	}

}
