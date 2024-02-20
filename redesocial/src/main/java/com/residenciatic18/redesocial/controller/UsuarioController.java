package com.residenciatic18.redesocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.residenciatic18.redesocial.dto.UsuarioDTO;
import com.residenciatic18.redesocial.model.Usuario;
import com.residenciatic18.redesocial.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired 
	private UsuarioRepository usuariorepository;
	
	@RequestMapping("/listausuarios")
	public ArrayList<UsuarioDTO> getUsuario() {
		
		List<Usuario> usuarios = (ArrayList<Usuario>) usuariorepository.findAll();
		ArrayList<UsuarioDTO> usuariosdto = new ArrayList<UsuarioDTO>();
		for (Usuario u : usuarios) {
			
			usuariosdto.add(new UsuarioDTO(u));
			
		}
		return usuariosdto;
		
		
		
	}

}

/*
ArrayList<UsuarioDTO> usuariosdto = new ArrayList<UsuarioDTO>();
ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
usuarios = UsuarioDAO.readAll();
for (int i = 0; i < usuarios.size(); i++) {
	
	usuariosdto.add(new UsuarioDTO(usuarios.get(i)));
}
return usuariosdto;
*/