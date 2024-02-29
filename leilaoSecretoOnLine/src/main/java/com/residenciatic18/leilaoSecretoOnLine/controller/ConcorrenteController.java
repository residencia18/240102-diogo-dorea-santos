package com.residenciatic18.leilaoSecretoOnLine.controller;

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

import com.residenciatic18.leilaoSecretoOnLine.dto.ConcorrenteDTO;
import com.residenciatic18.leilaoSecretoOnLine.form.ConcorrenteForm;
import com.residenciatic18.leilaoSecretoOnLine.model.Concorrente;
import com.residenciatic18.leilaoSecretoOnLine.repository.ConcorrenteRepository;

@RestController
@RequestMapping("/concorrente/")
public class ConcorrenteController {
	
	@Autowired
	private ConcorrenteRepository concorrenterepository;
	
	@GetMapping
	public ArrayList<ConcorrenteDTO> getConcorrente() {

		ArrayList<ConcorrenteDTO> concorrentesdto = new ArrayList<ConcorrenteDTO>();
		List<Concorrente> concorrentes = new ArrayList<Concorrente>();
		concorrentes = (ArrayList<Concorrente>) concorrenterepository.findAll();
		for (Concorrente c : concorrentes) {
			
			concorrentesdto.add(new ConcorrenteDTO(c));	
		}
		return concorrentesdto;	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConcorrenteDTO> getConcorrente(@PathVariable Long id, UriComponentsBuilder uriBuilder) {

		try {
			Concorrente c = concorrenterepository.getReferenceById(id);
			ConcorrenteDTO cdto = new ConcorrenteDTO(c);
			uriBuilder.path("/concorrente/{id}");
			URI uri = uriBuilder.buildAndExpand(c.getId()).toUri();
			return ResponseEntity.created(uri).body(cdto);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<ConcorrenteDTO> inserir(@RequestBody ConcorrenteForm cf, UriComponentsBuilder uriBuilder) {

		try {
		Concorrente c = cf.criaConcorrente();
		concorrenterepository.save(c);
		ConcorrenteDTO cdto = new ConcorrenteDTO(c);
		URI uri = uriBuilder.path("/concorrente/{id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(uri).body(cdto);
		} catch (Exception e) {
		return ResponseEntity.badRequest().build();
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody ConcorrenteForm cf) {
		
		try {
			Concorrente c = concorrenterepository.getReferenceById(id);
			c.setNome(cf.getNome());
			c.setCpf(cf.getCpf());
			
			concorrenterepository.save(c);
			
			return ResponseEntity.ok(cf);
			
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
			Concorrente c = concorrenterepository.getReferenceById(id);
			ConcorrenteDTO cdto = new ConcorrenteDTO(c);
			concorrenterepository.deleteById(id);
			return ResponseEntity.ok(cdto);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deletar() {
		return ResponseEntity.badRequest().build();
		
	}

}
