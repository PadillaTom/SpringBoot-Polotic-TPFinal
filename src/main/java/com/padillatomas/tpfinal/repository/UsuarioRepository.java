package com.padillatomas.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padillatomas.tpfinal.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}