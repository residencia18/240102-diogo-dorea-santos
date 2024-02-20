package com.residenciatic18.gestorLinhasAereas.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.residenciatic18.gestorLinhasAereas.dao.AeroportoDAO;
import com.residenciatic18.gestorLinhasAereas.model.Aeroporto;

@RestController
public class AeroportoController {
	
	@RequestMapping("/aeroportos")
	public ArrayList<Aeroporto> getAeroporto() {
		
		return AeroportoDAO.readAll();	
	}
	
	

}
