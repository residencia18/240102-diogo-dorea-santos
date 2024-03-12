package com.residenciatic.testedbpostgree.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.residenciatic.testedbpostgree.form.UsuarioForm;
import com.residenciatic.testedbpostgree.model.Usuario;
import com.residenciatic.testedbpostgree.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {
	

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody UsuarioForm uf, UriComponentsBuilder uriBuilder) {
		
		Usuario u = uf.toModel();
		usuarioRepository.save(u);
		uriBuilder.path("/usuario/{id}");
		URI uri = uriBuilder.buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(uri).body(u);
		
	}

}
