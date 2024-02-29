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

import com.residenciatic18.leilaoSecretoOnLine.dto.LeilaoDTO;
import com.residenciatic18.leilaoSecretoOnLine.form.LeilaoForm;
import com.residenciatic18.leilaoSecretoOnLine.model.Leilao;
import com.residenciatic18.leilaoSecretoOnLine.repository.LeilaoRepository;

@RestController
@RequestMapping("/leilao/")
public class LeilaoController {
	
	@Autowired
	private LeilaoRepository leilaorepository;
	
	@GetMapping
	public ArrayList<LeilaoDTO> getUsuario() {

		ArrayList<LeilaoDTO> leiloesdto = new ArrayList<LeilaoDTO>();
		List<Leilao> leiloes = new ArrayList<Leilao>();
		leiloes = (ArrayList<Leilao>) leilaorepository.findAll();
		for (Leilao l : leiloes) {
			
			leiloesdto.add(new LeilaoDTO(l));	
		}
		return leiloesdto;	
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<LeilaoDTO> getLeilao(@PathVariable Long id, UriComponentsBuilder uriBuilder) {

		try {
			Leilao u = leilaorepository.getReferenceById(id);
			LeilaoDTO udto = new LeilaoDTO(u);
			uriBuilder.path("/usuarios/{id}");
			URI uri = uriBuilder.buildAndExpand(u.getId()).toUri();
			return ResponseEntity.created(uri).body(udto);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<LeilaoDTO> inserir(@RequestBody LeilaoForm lf, UriComponentsBuilder uriBuilder) {

		try {
		Leilao l = lf.criaLeilao();
		leilaorepository.save(l);
		LeilaoDTO ldto = new LeilaoDTO(l);
		URI uri = uriBuilder.path("/leilao/{id}").buildAndExpand(l.getId()).toUri();
		return ResponseEntity.created(uri).body(ldto);
		} catch (Exception e) {
		return ResponseEntity.badRequest().build();
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody LeilaoForm lf) {
		
		try {
			Leilao l = leilaorepository.getReferenceById(id);
			l.setDescricao(lf.getDescricao());
			l.setValorminimo(lf.getValorminimo());
			l.setStatus(lf.isStatus());
			leilaorepository.save(l);
			
			return ResponseEntity.ok(lf);
			
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
			Leilao l = leilaorepository.getReferenceById(id);
			LeilaoDTO ldto = new LeilaoDTO(l);
			leilaorepository.deleteById(id);
			return ResponseEntity.ok(ldto);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deletar() {
		return ResponseEntity.badRequest().build();
		
	}
}
