package com.residenciatic18.redesocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.residenciatic18.redesocial.dto.UsuarioDTO;
import com.residenciatic18.redesocial.model.Usuario;
import com.residenciatic18.redesocial.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios/")
public class UsuarioController {
	
	@Autowired 
	private UsuarioRepository usuariorepository;
	
	@GetMapping
	public ArrayList<UsuarioDTO> getUsuario(String nome) {
		//System.out.println("Nome: " + nome);
		ArrayList<UsuarioDTO> usuariosdto = new ArrayList<UsuarioDTO>();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		if (nome == null) {
			 usuarios = (ArrayList<Usuario>) usuariorepository.findAll();
		}
		else {
			usuarios = (ArrayList<Usuario>) usuariorepository.findByNome(nome);	
		}
		for (Usuario u : usuarios) {
			
			usuariosdto.add(new UsuarioDTO(u));	
		}
		return usuariosdto;	
	}
	/*
	@RequestMapping("/listausuariospornome/")
	public ArrayList<UsuarioDTO> getUsuarioPorNome(String _nome) {

		List<Usuario> usuarios = (ArrayList<Usuario>) usuariorepository.findByNome(_nome);
		ArrayList<UsuarioDTO> usuariosdto = new ArrayList<UsuarioDTO>();
		for (Usuario u : usuarios) {
			
			usuariosdto.add(new UsuarioDTO(u));	
		}
		return usuariosdto;	
	}
	*/
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