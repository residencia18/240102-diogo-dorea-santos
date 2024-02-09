package com.resideciatic18.redesocial.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuController {
	
	private Integer valor = 99;
	private Integer sequencia =1;
	

	@RequestMapping("/valor")
	public String getValor() {
		return valor.toString();
	}
	
	@RequestMapping("/aleatorio")
	public String getAleatorio() {
		
		Random random = new Random();
		Integer retorno = random.nextInt();
		return retorno.toString();	
	}
	
	@RequestMapping("/sequencia")
	public String getSequencia() {
		return (sequencia++).toString();
			
	}
	
	
}
