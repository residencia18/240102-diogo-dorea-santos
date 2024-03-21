package com.residenciatic18.gestorLinhasAereas.controller;

import java.util.ArrayList;

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

import com.residenciatic18.gestorLinhasAereas.dto.AeroportoDTO;
import com.residenciatic18.gestorLinhasAereas.form.AeroportoForm;
import com.residenciatic18.gestorLinhasAereas.model.Aeroporto;
import com.residenciatic18.gestorLinhasAereas.repository.AeroportoRepository;


@RestController
@RequestMapping("/aeroportos/")
public class AeroportoController {
	
	@Autowired private AeroportoRepository aeroportorepository;
	
	@GetMapping
	public ArrayList<Aeroporto> getAeroporto(String nome) {
		
		ArrayList<Aeroporto> aeroportos = new ArrayList<>();
		if (nome == null) {
			 aeroportos = (ArrayList<Aeroporto>) aeroportorepository.findAll();
		}
		else {
			aeroportos = (ArrayList<Aeroporto>) aeroportorepository.findByNome(nome);	
		}
		return aeroportos;
	}
	
	@PostMapping
	public Aeroporto inserir(@RequestBody AeroportoForm af) {

		Aeroporto a = af.criaAeroporto();
		aeroportorepository.save(a);
		return a;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody AeroportoForm af) {
		
		try {
			Aeroporto a = aeroportorepository.getReferenceById(id);
			a.setNome(af.getNome());
			aeroportorepository.save(a);
			AeroportoDTO adto = new AeroportoDTO(a);
			return ResponseEntity.ok(adto);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		
		try {
			Aeroporto a = aeroportorepository.getReferenceById(id);
			AeroportoDTO adto = new AeroportoDTO(a);
			aeroportorepository.deleteById(id);
			return ResponseEntity.ok(adto);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}
