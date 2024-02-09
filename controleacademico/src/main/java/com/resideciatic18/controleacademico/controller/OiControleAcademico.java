package com.resideciatic18.controleacademico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OiControleAcademico {
	
	@RequestMapping("/diogo")
	@ResponseBody
	public String mensagem1() {
		
		return "Netuno";
		
		
	}
	
	@RequestMapping("/mensagem2")
	@ResponseBody
	public String mensagem2() {
		
		return "mensagem2";
		
		
	}
	
	

}
