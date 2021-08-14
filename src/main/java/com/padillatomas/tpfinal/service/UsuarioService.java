package com.padillatomas.tpfinal.service;

import java.util.List;

import com.padillatomas.tpfinal.model.Usuario;



public interface UsuarioService {
	
	// Create USUARIO:
	Usuario saveUsuario(Usuario usuario);
	
	// Fetch ALL USUARIOS:
	List<Usuario> fetchUsuarios();
	

}