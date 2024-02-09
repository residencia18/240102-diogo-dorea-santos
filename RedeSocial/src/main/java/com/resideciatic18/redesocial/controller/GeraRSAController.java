package com.resideciatic18.redesocial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resideciatic18.redesocial.lib.Key;
import com.resideciatic18.redesocial.lib.RSAGenerator;

@RestController
public class GeraRSAController {
	
	@RequestMapping("/gerachaversa")
	public String getChaveRSA() {
		
		RSAGenerator rsa = new RSAGenerator(32);
		Key keyPrivate = rsa.getPrivatekey();
		Key keyPublic = rsa.getPublickey();
		
		String retorno = rsa.toString();
		return retorno;
		
		
	}

}
