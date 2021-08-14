package com.padillatomas.tpfinal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padillatomas.tpfinal.model.Usuario;
import com.padillatomas.tpfinal.repository.UsuarioRepository;
import com.padillatomas.tpfinal.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository usuarioRepository;

	
	// *** Constructor ***
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}


	// **********************************
	// Methods
	// **********************************
	
	// --- CREATE ---
	@Override
	public Usuario saveUsuario(Usuario usuario) {		
		return usuarioRepository.save(usuario);
	}

	// --- FETCH ALL ---
	@Override
	public List<Usuario> fetchUsuarios() {
		return usuarioRepository.findAll();
	}

}