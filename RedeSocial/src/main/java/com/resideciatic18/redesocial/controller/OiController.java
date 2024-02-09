package com.resideciatic18.redesocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OiController {
	
	@RequestMapping("/")
	@ResponseBody
	public String mensagem() {
		
		return "Estou no computador de Diogo";
		
		
	}

}
