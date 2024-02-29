package com.residenciatic18.leilaoSecretoOnLine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residenciatic18.leilaoSecretoOnLine.model.Leilao;

public interface LeilaoRepository extends JpaRepository<Leilao, Long>{
	
	
	List<Leilao> findByStatus(boolean status);
	

}
