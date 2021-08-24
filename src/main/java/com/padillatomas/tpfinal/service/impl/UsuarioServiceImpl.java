package com.padillatomas.tpfinal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padillatomas.tpfinal.exception.ResourceNotFoundException;
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

	// --- FETCH BY ID ---
	@Override
	public Usuario fetchById(Long id) {		
		return usuarioRepository.getById(id);
	}

	// --- DELETE BY ID ---
	@Override
	public void eliminarUsu(Usuario usu) {
		Long idToDelete = usu.getUsuarioId();
		
		// Exists?
		usuarioRepository.findById(idToDelete).orElseThrow(()->new ResourceNotFoundException("Usuario", "usuarioId",idToDelete));
		
		// Delete
		usuarioRepository.deleteById(idToDelete);
	}

	// --- EDIT BY ID ---
	@Override
	public Usuario editUsuario(Usuario usu, Long id) {
		Long idToEdit = usu.getUsuarioId();
		// Exists?
		Usuario existingUsu = usuarioRepository.findById(idToEdit).orElseThrow(()-> new ResourceNotFoundException("Usuario","id",idToEdit));
		
		// Settear:		
		existingUsu.setUsername(usu.getUsername());
		existingUsu.setPassword(usu.getPassword());
		existingUsu.getUsuEmpleado().setDniEmpleado(usu.getUsuEmpleado().getDniEmpleado());
		existingUsu.getUsuEmpleado().setNombreEmpleado(usu.getUsuEmpleado().getNombreEmpleado());
		existingUsu.getUsuEmpleado().setApellidoEmpleado(usu.getUsuEmpleado().getApellidoEmpleado());
		existingUsu.getUsuEmpleado().setFechaNacEmpleado(usu.getUsuEmpleado().getFechaNacEmpleado());
		existingUsu.getUsuEmpleado().setDireccionEmpleado(usu.getUsuEmpleado().getDireccionEmpleado());
		existingUsu.getUsuEmpleado().setCargoEmpleado(usu.getUsuEmpleado().getCargoEmpleado());
		
		usuarioRepository.save(existingUsu);		
		return existingUsu;
	}

}