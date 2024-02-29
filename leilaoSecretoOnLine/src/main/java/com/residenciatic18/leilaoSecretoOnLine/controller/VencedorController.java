package com.residenciatic18.leilaoSecretoOnLine.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residenciatic18.leilaoSecretoOnLine.model.Leilao;
import com.residenciatic18.leilaoSecretoOnLine.dto.ConcorrenteDTO;
import com.residenciatic18.leilaoSecretoOnLine.model.Concorrente;
import com.residenciatic18.leilaoSecretoOnLine.model.Lance;

import com.residenciatic18.leilaoSecretoOnLine.repository.LanceRepository;
import com.residenciatic18.leilaoSecretoOnLine.repository.LeilaoRepository;

@RestController
@RequestMapping("/vencedor_leilao/")
public class VencedorController {
	
	@Autowired
	private LeilaoRepository leilaorepository;
	private LanceRepository lancerepository;
	
	@GetMapping("/leilao/{id}")
	public ResponseEntity<?> obterVencedorDoLeilao(@PathVariable Long id) {
	    try {
	        if (id == null || id <= 0) {
	            return ResponseEntity.badRequest().build();
	        }

	        // Verifica se o leilão associado ao ID existe
	        Optional<Leilao> leilaoOptional = leilaorepository.findById(id);
	        if (leilaoOptional.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        Leilao leilao = leilaoOptional.get();

	        // Verifica se o leilão associado ao ID está aberto
	        if (!leilao.getStatus()) {
	            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O leilão está fechado.");
	        }

	        // Obtém o maior lance para o leilão
	        Optional<Lance> maiorLanceOptional = lancerepository.findTopByLeilaoOrderByValorDesc(leilao);
	        if (maiorLanceOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum lance encontrado para este leilão.");
	        }
	        Lance maiorLance = maiorLanceOptional.get();

	        // Obtém o concorrente associado ao maior lance
	        Concorrente concorrente = maiorLance.getConcorrente();

	        // Constrói e retorna o JSON com os dados do leilão, o valor do maior lance e o DTO do concorrente
	        Map<String, Object> response = new HashMap<>();
	        response.put("leilao", leilao);
	        response.put("maiorLance", maiorLance.getValor());
	        response.put("concorrente", new ConcorrenteDTO(concorrente));
	        return ResponseEntity.ok(response);

	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}


}
