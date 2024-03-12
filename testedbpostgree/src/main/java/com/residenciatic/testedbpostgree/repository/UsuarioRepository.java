package com.residenciatic.testedbpostgree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residenciatic.testedbpostgree.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
