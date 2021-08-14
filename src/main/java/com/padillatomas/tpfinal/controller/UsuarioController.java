package com.padillatomas.tpfinal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.tpfinal.model.Usuario;
import com.padillatomas.tpfinal.service.UsuarioService;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	private UsuarioService usuarioService;

	
	// *** Constructor ***
	
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	// *** CREATE USUARIO REST API ***
	@PostMapping
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(usuarioService.saveUsuario(usuario), HttpStatus.CREATED);
	}
}