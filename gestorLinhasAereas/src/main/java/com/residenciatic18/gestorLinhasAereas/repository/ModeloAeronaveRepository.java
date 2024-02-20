package com.residenciatic18.gestorLinhasAereas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.residenciatic18.gestorLinhasAereas.model.ModeloAeronave;

public interface ModeloAeronaveRepository extends JpaRepository<ModeloAeronave, Integer>{
	List<ModeloAeronave> findByNome(String nome);

}
