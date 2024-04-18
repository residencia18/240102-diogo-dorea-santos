package com.residenciatic18.PP003.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.residenciatic18.PP003.form.PacienteForm;
import com.residenciatic18.PP003.model.Paciente;
import com.residenciatic18.PP003.dto.PacienteDTO;
import com.residenciatic18.PP003.repository.PacienteRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/pacientes/")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Operation(description = "Lista todos os pacientes")
	@ApiResponse(responseCode = "200", description = "lista completa de pacientes")       
	@GetMapping
	public ArrayList<PacienteDTO> getPaciente() {

		ArrayList<PacienteDTO> pacientesdto = new ArrayList<PacienteDTO>();
		List<Paciente> pacientes = new ArrayList<Paciente>();
		pacientes = (ArrayList<Paciente>) pacienteRepository.findAll();
		for (Paciente p : pacientes) {
			pacientesdto.add(new PacienteDTO(p));	
		}
		return pacientesdto;	
	}

	@GetMapping("/{id}")
	public ResponseEntity<PacienteDTO> getPaciente(@PathVariable Long id, UriComponentsBuilder uriBuilder) {

		try {
			Paciente p = pacienteRepository.getReferenceById(id);
			PacienteDTO pcdto = new PacienteDTO(p);
			uriBuilder.path("/pacientes/{id}");
			URI uri = uriBuilder.buildAndExpand(p.getId()).toUri();
			return ResponseEntity.created(uri).body(pcdto);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<PacienteDTO> save(@RequestBody PacienteForm pf, UriComponentsBuilder uriBuilder) {
		
		try {
			Paciente p = pf.toModel();
			pacienteRepository.save(p);
			PacienteDTO pcdto = new PacienteDTO(p);
			URI uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(p.getId()).toUri();
			return ResponseEntity.created(uri).body(pcdto);
		}	catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizaPaciente(@PathVariable Long id, @RequestBody PacienteForm pf) {
		
		try {
			Paciente p = pacienteRepository.getReferenceById(id);
			p.setNome(pf.getNome());
			p.setTelefone(pf.getTelefone());
			p.setEndereco(pf.getEndereco());
			pacienteRepository.save(p);
			return ResponseEntity.ok(pf);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping
	public ResponseEntity<?> atualizar() {
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		
		try {
		Paciente p = pacienteRepository.getReferenceById(id);
			PacienteDTO pcto = new PacienteDTO(p);
			pacienteRepository.deleteById(id);
			return ResponseEntity.ok(pcto);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping
	public ResponseEntity<?> deletar() {
		return ResponseEntity.badRequest().build();
		
	}
}
