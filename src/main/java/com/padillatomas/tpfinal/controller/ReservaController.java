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

import com.padillatomas.tpfinal.model.Reserva;
import com.padillatomas.tpfinal.service.ReservaService;

@CrossOrigin(origins = {"http://localhost:3000","https://tpfinal-polotic.netlify.app"}, allowedHeaders = "*")
@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
	
	// Service
	private ReservaService reservaService;	
	// Constructor:
	public ReservaController(ReservaService reservaService) {
		super();
		this.reservaService = reservaService;
	}
	
	// ::: POST Reservas :::
	@PostMapping
	public ResponseEntity<Reserva> altaRes(@RequestBody Reserva reserva){
		String myResultado = reservaService.verifReserva(reserva);
		if(myResultado.equals("no")) {
			return null;
		} else if (myResultado.equals("yes")) {			
			return new ResponseEntity<Reserva> (reservaService.altaReserva(reserva), HttpStatus.CREATED);
		}
		else return null;
	}
		
	
	/// ::: GET Reservas :::
	@GetMapping
	public List<Reserva> fetchAllReservas(){
		return reservaService.traerAllReservas();
	}
	

}
