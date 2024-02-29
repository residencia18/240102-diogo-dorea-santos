package com.residenciatic18.leilaoSecretoOnLine.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residenciatic18.leilaoSecretoOnLine.model.Lance;
import com.residenciatic18.leilaoSecretoOnLine.model.Leilao;

public interface LanceRepository extends JpaRepository<Lance, Long> {
	
	List<Lance> findByLeilaoId(Long id);
	List<Lance> findByConcorrenteId(Long id);
	Optional<Lance> findTopByLeilaoOrderByValorDesc(Leilao leilao);
	
	

}
