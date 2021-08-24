package com.padillatomas.tpfinal.service;

import java.util.List;

import com.padillatomas.tpfinal.model.Usuario;



public interface UsuarioService {
	
	// Create USUARIO:
	Usuario saveUsuario(Usuario usuario);
	
	// Fetch by Id:
	Usuario fetchById(Long id);
	
	// Fetch ALL USUARIOS:
	List<Usuario> fetchUsuarios();
	
	//Borrar Usuario:
	void eliminarUsu(Usuario usu);
	
	// Edit Usuario:
	Usuario editUsuario(Usuario usu, Long id );
	

}