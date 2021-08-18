package com.padillatomas.tpfinal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.tpfinal.model.Reserva;
import com.padillatomas.tpfinal.service.ReservaService;

@CrossOrigin(origins = {"http://localhost:3000","https://tpfinal-polotic.netlify.app"}, allowedHeaders = "*")
@RestController
@RequestMapping("/api/confirmacionReserva")
public class ConfirmacionReservaController {
	
	private ReservaService reservaService;
	
	public ConfirmacionReservaController(ReservaService reservaService) {
		super();
		this.reservaService = reservaService;
	}

	// ::: Get Last Reserva :::
	@GetMapping
	public Reserva fetchLastReserva(){
		return reservaService.traerLastReserva();
	}
}
