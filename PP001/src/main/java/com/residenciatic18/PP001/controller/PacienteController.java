package com.residenciatic18.PP001.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.residenciatic18.PP001.form.PacienteForm;
import com.residenciatic18.PP001.model.Paciente;
import com.residenciatic18.PP001.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes/")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping
	public List<Paciente> getPacientes() {
		return pacienteRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody PacienteForm pf, UriComponentsBuilder uriBuilder) {
		
		Paciente p = pf.toModel();
		pacienteRepository.save(p);
		uriBuilder.path("/pacientes/{id}");
		URI uri = uriBuilder.buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).body(p);
		
	}
}
