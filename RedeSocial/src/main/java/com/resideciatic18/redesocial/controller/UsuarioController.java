package com.resideciatic18.redesocial.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.resideciatic18.redesocial.controller.dto.UsuarioDTO;
import com.resideciatic18.redesocial.model.Usuario;

@RestController
public class UsuarioController {
	
	@RequestMapping("/listausuarios")
	//@ResponseBody
	public ArrayList<UsuarioDTO> listUsuario() {
		
		ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		
		usuarios.add(new UsuarioDTO(new Usuario(1,"Diogo Dorea","diogodorea@diogo","123")));
		
		usuarios.add(new UsuarioDTO(new Usuario(2,"Alan","alan@alan","456")));
		
		usuarios.add(new UsuarioDTO(new Usuario(3,"Joao","joao@joao","789")));
		usuarios.add(new UsuarioDTO(new Usuario(4,"Tamires","tamires@tamires.com","101")));
		usuarios.add(new UsuarioDTO(new Usuario(5,"Pedro","pedro@pedro.com","1313")));
		usuarios.add(new UsuarioDTO(new Usuario(6,"leticia","leticia@leticia@gmail.com","191")));
		
		return usuarios;
		
		
	}
	

}
