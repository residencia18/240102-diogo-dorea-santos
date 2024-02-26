package com.residenciatic18.PO13.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residenciatic18.PO13.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findByNome(String nome);
}
