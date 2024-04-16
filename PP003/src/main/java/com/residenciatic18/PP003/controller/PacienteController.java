package com.residenciatic18.PP003.controller;

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

import com.residenciatic18.PP003.form.PacienteForm;
import com.residenciatic18.PP003.model.Paciente;
import com.residenciatic18.PP003.repository.PacienteRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/pacientes/")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Operation(description = "Lista todos os pacientes")
	@ApiResponse(responseCode = "200", description = "lista completa de pacientes")       
	@GetMapping
	public List<Paciente> getPacientes() {
		return pacienteRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody PacienteForm pf, UriComponentsBuilder uriBuilder) {
		
		try {
			Paciente p = pf.toModel();
			pacienteRepository.save(p);
			uriBuilder.path("/pacientes/{id}");
			URI uri = uriBuilder.buildAndExpand(p.getId()).toUri();
			return ResponseEntity.created(uri).body(p);
		}	catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		
	}
}
