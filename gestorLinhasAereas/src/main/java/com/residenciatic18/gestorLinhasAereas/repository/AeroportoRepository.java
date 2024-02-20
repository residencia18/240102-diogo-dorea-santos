package com.residenciatic18.gestorLinhasAereas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.residenciatic18.gestorLinhasAereas.model.Aeroporto;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer>{
	List<Aeroporto> findByNome(String nome);

}
