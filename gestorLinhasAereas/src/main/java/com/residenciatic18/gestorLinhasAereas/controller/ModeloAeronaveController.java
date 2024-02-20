package com.residenciatic18.gestorLinhasAereas.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.residenciatic18.gestorLinhasAereas.dao.ModeloAeronaveDAO;
import com.residenciatic18.gestorLinhasAereas.model.ModeloAeronave;

@RestController
public class ModeloAeronaveController {
	
	@RequestMapping("/modeloaeronaves")
	public ArrayList<ModeloAeronave> getModeloAeronave() {
		
		return ModeloAeronaveDAO.readAll();	
	}
}
