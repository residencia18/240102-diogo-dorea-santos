package com.residenciatic18.PO13.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.residenciatic18.PO13.model.ModeloAeronave;

public interface ModeloAeronaveRepository extends JpaRepository<ModeloAeronave, Integer>{
	List<ModeloAeronave> findByNome(String nome);

}
