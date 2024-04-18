package com.residenciatic18.PP003.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.residenciatic18.PP003.dto.ResultadoDTO;
import com.residenciatic18.PP003.form.ResultadoForm;
import com.residenciatic18.PP003.model.Paciente;
import com.residenciatic18.PP003.model.Resultado;
import com.residenciatic18.PP003.repository.PacienteRepository;
import com.residenciatic18.PP003.repository.ResultadoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/resultados/")
public class ResultadoController {
	
	@Autowired
	private ResultadoRepository resultadoRepository;
	private PacienteRepository pacienteRepository;
	
	@Operation(description = "Lista todos os resultados")
	@ApiResponse(responseCode = "200", description = "lista completa de resultados")       
	@GetMapping
	public ArrayList<ResultadoDTO> getResultado() {

		ArrayList<ResultadoDTO> resutadosdto = new ArrayList<ResultadoDTO>();
		List<Resultado> resultados = new ArrayList<Resultado>();
		resultados = (ArrayList<Resultado>) resultadoRepository.findAll();
		for (Resultado r : resultados) {
			
			resutadosdto.add(new ResultadoDTO(r));	
		}
		return resutadosdto;	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResultadoDTO> getLance(@PathVariable Long id, UriComponentsBuilder uriBuilder) {

		try {
			Resultado r = resultadoRepository.getReferenceById(id);
			ResultadoDTO rdto = new ResultadoDTO(r);
			uriBuilder.path("/resultados/{id}");
			URI uri = uriBuilder.buildAndExpand(r.getId()).toUri();
			return ResponseEntity.created(uri).body(rdto);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/paciente={id}")
	public ResponseEntity<List<ResultadoDTO>> getResultadosByPacienteId(@PathVariable Long id) {
		try {
			List<Resultado> resultados = resultadoRepository.findByPacienteId(id);
			List<ResultadoDTO> resultadosDTO = new ArrayList<>();
			for (Resultado resultado : resultados) {
				resultadosDTO.add(new ResultadoDTO(resultado));
			}
			return ResponseEntity.ok(resultadosDTO);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody ResultadoForm rf, UriComponentsBuilder uriBuilder) {
	    
		try {
	        // Verifica se o paciente existe
	        Optional<Paciente> pacienteOptional = pacienteRepository.findById(rf.getIdPaciente());
	        if (pacienteOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Paciente não encontrado.");
	        }

	        // Cria e salva o resultado
	        Resultado r = rf.toModel();
			r.setPaciente(pacienteOptional.get());
	        resultadoRepository.save(r);
	        ResultadoDTO rdto = new ResultadoDTO(r);
	        URI uri = uriBuilder.path("/resultado/{id}").buildAndExpand(r.getId()).toUri();
	        return ResponseEntity.created(uri).body(rdto);
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().build();
	    }
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody ResultadoForm rf) {
	    try {
	        // Verifica se o ID é válido e foi passado
	        if (id == null || id <= 0) {
	            return ResponseEntity.notFound().build();
	        }

	        // Verifica se o paciente existe
	        Optional<Paciente> pacienteOptional = pacienteRepository.findById(rf.getIdPaciente());
	        if (pacienteOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Paciente não encontrado.");
	        }

	        // Atualiza o resultado
	        Resultado r = resultadoRepository.findById(id).orElse(null);
	        if (r == null) {
	            return ResponseEntity.notFound().build();
	        }
	        r.setNomeExame(rf.getNomeExame());
			r.setPaciente(rf.toModel().getPaciente());
	        resultadoRepository.save(r);
	        
	        return ResponseEntity.ok(rf);
	        
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
	        // Verifica se o ID é válido e foi passado
	        if (id == null || id <= 0) {
	            return ResponseEntity.notFound().build();
	        }

	        // Verifica se o resultado existe
	        Optional<Resultado> resultadoOptional = resultadoRepository.findById(id);
	        if (resultadoOptional.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        Resultado r = resultadoOptional.get();
			
			// Deleta o lance
	        ResultadoDTO rdto = new ResultadoDTO(r);
	        resultadoRepository.deleteById(id);
	        return ResponseEntity.ok(rdto);
	    } catch (Exception e) {
	        return ResponseEntity.notFound().build();
	    }
	}

	@DeleteMapping
	public ResponseEntity<?> deletar() {
		return ResponseEntity.badRequest().build();
		
	}

}
