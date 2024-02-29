package com.residenciatic18.leilaoSecretoOnLine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residenciatic18.leilaoSecretoOnLine.model.Concorrente;

public interface ConcorrenteRepository extends JpaRepository<Concorrente, Long> {
	
	List<Concorrente> findByNome(String nome);

}
