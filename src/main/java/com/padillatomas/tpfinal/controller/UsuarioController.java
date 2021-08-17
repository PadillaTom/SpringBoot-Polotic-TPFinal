package com.padillatomas.tpfinal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.tpfinal.model.Usuario;
import com.padillatomas.tpfinal.service.UsuarioService;

@CrossOrigin(origins = {"http://localhost:3000","https://tpfinal-polotic.netlify.app"}, allowedHeaders = "*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	private UsuarioService usuarioService;

	
	// *** Constructor ***	
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	// ::: POST Usuarios :::
	@PostMapping
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(usuarioService.saveUsuario(usuario), HttpStatus.CREATED);
	}
	
	// ::: GET Usuarios :::
	@GetMapping
	public List<Usuario> fetchAllUsuarios(){
		return usuarioService.fetchUsuarios();
	}
	
	
}