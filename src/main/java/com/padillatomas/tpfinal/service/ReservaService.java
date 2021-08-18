package com.padillatomas.tpfinal.service;

import java.util.List;

import com.padillatomas.tpfinal.model.Reserva;

public interface ReservaService {
	
	// Post :
	Reserva altaReserva(Reserva reserva);
	
	// Fetch All:
	List<Reserva> traerAllReservas();	

}
