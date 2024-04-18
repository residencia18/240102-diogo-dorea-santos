package com.residenciatic18.PP003.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residenciatic18.PP003.model.Resultado;

public interface ResultadoRepository extends JpaRepository<Resultado, Long>{

    List<Resultado> findByPacienteId(Long id);

}
