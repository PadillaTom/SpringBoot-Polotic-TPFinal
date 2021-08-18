package com.padillatomas.tpfinal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padillatomas.tpfinal.model.Reserva;
import com.padillatomas.tpfinal.repository.ReservaRepository;
import com.padillatomas.tpfinal.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	// Repository:
	private ReservaRepository reservaRepository;
	// Constructor:
	public ReservaServiceImpl(ReservaRepository reservaRepository) {
		super();
		this.reservaRepository = reservaRepository;
	}
	
	// **********************************
	// Methods
	// **********************************
		
	// --- CREATE ---
	@Override
	public Reserva altaReserva(Reserva reserva) {
		// Recivo reserva de Controller:
		
		
		
		return reservaRepository.save(reserva);
	}

	@Override
	public List<Reserva> traerAllReservas() {		
		return reservaRepository.findAll();
	}

}
