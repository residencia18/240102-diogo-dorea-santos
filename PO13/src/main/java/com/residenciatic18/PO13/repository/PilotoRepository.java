package com.residenciatic18.PO13.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.residenciatic18.PO13.model.Piloto;


public interface PilotoRepository extends JpaRepository<Piloto, Integer>{
	List<Piloto> findByNome(String nome);

}
