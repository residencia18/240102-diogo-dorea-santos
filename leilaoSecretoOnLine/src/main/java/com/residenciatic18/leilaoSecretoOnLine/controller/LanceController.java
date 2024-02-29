package com.residenciatic18.leilaoSecretoOnLine.controller;

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

import com.residenciatic18.leilaoSecretoOnLine.dto.LanceDTO;
import com.residenciatic18.leilaoSecretoOnLine.form.LanceForm;
import com.residenciatic18.leilaoSecretoOnLine.model.Concorrente;
import com.residenciatic18.leilaoSecretoOnLine.model.Lance;
import com.residenciatic18.leilaoSecretoOnLine.model.Leilao;
import com.residenciatic18.leilaoSecretoOnLine.repository.LanceRepository;
import com.residenciatic18.leilaoSecretoOnLine.repository.LeilaoRepository;
import com.residenciatic18.leilaoSecretoOnLine.repository.ConcorrenteRepository;

@RestController
@RequestMapping("/lance/")
public class LanceController {
	
	@Autowired
	private LanceRepository lancerepository;
	private ConcorrenteRepository concorrenterepository;
	private LeilaoRepository leilaorepository;

	@GetMapping
	public ArrayList<LanceDTO> getLance() {

		ArrayList<LanceDTO> lancesdto = new ArrayList<LanceDTO>();
		List<Lance> lances = new ArrayList<Lance>();
		lances = (ArrayList<Lance>) lancerepository.findAll();
		for (Lance l : lances) {
			
			lancesdto.add(new LanceDTO(l));	
		}
		return lancesdto;	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LanceDTO> getLance(@PathVariable Long id, UriComponentsBuilder uriBuilder) {

		try {
			Lance l = lancerepository.getReferenceById(id);
			LanceDTO ldto = new LanceDTO(l	);
			uriBuilder.path("/lance/{id}");
			URI uri = uriBuilder.buildAndExpand(l.getId()).toUri();
			return ResponseEntity.created(uri).body(ldto);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/leilao={id}")
	public ResponseEntity<List<LanceDTO>> getLancesByLeilaoId(@PathVariable Long id) {
		try {
			List<Lance> lances = lancerepository.findByLeilaoId(id);
			List<LanceDTO> lancesDTO = new ArrayList<>();
			for (Lance lance : lances) {
				lancesDTO.add(new LanceDTO(lance));
			}
			return ResponseEntity.ok(lancesDTO);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/concorrente={id}")
	public ResponseEntity<List<LanceDTO>> getLancesByConcorrenteId(@PathVariable Long id) {
		try {
			List<Lance> lances = lancerepository.findByConcorrenteId(id);
			List<LanceDTO> lancesDTO = new ArrayList<>();
			for (Lance lance : lances) {
				lancesDTO.add(new LanceDTO(lance));
			}
			return ResponseEntity.ok(lancesDTO);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody LanceForm lf, UriComponentsBuilder uriBuilder) {
	    
		try {
	        // Verifica se o concorrente existe
	        Optional<Concorrente> concorrenteOptional = concorrenterepository.findById(lf.getConcorrente().getId());
	        if (concorrenteOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Concorrente não encontrado.");
	        }

	        // Verifica se o leilão existe e está aberto
	        Optional<Leilao> leilaoOptional = leilaorepository.findById(lf.getLeilao().getId());
	        if (leilaoOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Leilão não encontrado.");
	        } else {
	            Leilao leilao = leilaoOptional.get();
	            if (!leilao.getStatus()) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Leilão está fechado.");
	            }
	        }

	        // Cria e salva o lance
	        Lance l = lf.criaLance();
	        lancerepository.save(l);
	        LanceDTO ldto = new LanceDTO(l);
	        URI uri = uriBuilder.path("/lance/{id}").buildAndExpand(l.getId()).toUri();
	        return ResponseEntity.created(uri).body(ldto);
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().build();
	    }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody LanceForm lf) {
	    try {
	        // Verifica se o ID é válido e foi passado
	        if (id == null || id <= 0) {
	            return ResponseEntity.notFound().build();
	        }

	        // Verifica se o concorrente existe
	        Optional<Concorrente> concorrenteOptional = concorrenterepository.findById(lf.getConcorrente().getId());
	        if (concorrenteOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Concorrente não encontrado.");
	        }

	        // Verifica se o leilão existe e está aberto
	        Optional<Leilao> leilaoOptional = leilaorepository.findById(lf.getLeilao().getId());
	        if (leilaoOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Leilão não encontrado.");
	        } else {
	            Leilao leilao = leilaoOptional.get();
	            if (!leilao.getStatus()) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Leilão está fechado.");
	            }
	        }

	        // Atualiza o lance
	        Lance l = lancerepository.findById(id).orElse(null);
	        if (l == null) {
	            return ResponseEntity.notFound().build();
	        }
	        l.setConcorrente(lf.getConcorrente());
	        l.setLeilao(lf.getLeilao());
	        l.setValor(lf.getValor());
	        lancerepository.save(l);
	        
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
	        // Verifica se o ID é válido e foi passado
	        if (id == null || id <= 0) {
	            return ResponseEntity.notFound().build();
	        }

	        // Verifica se o lance existe
	        Optional<Lance> lanceOptional = lancerepository.findById(id);
	        if (lanceOptional.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        Lance l = lanceOptional.get();

	        // Verifica se o leilão associado ao lance está fechado
	        if (l.getLeilao().getStatus()) {
	            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Não é possível deletar um lance de um leilão fechado.");
	        }

	        // Deleta o lance
	        LanceDTO ldto = new LanceDTO(l);
	        lancerepository.deleteById(id);
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
