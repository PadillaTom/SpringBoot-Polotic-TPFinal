package com.padillatomas.tpfinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.tpfinal.model.Reserva;
import com.padillatomas.tpfinal.service.ConsultasService;

@CrossOrigin(origins = {"http://localhost:3000","https://tpfinal-polotic.netlify.app"}, allowedHeaders = "*")
@RestController
@RequestMapping("/api/consultaPorFecha")
public class ConsultaPorFecha {
	
	private ConsultasService consServ;	
	public ConsultaPorFecha(ConsultasService consServ) {
		super();
		this.consServ = consServ;
	}
	
	// ::: GET Reservas :::
	@PostMapping
	public List<Reserva> traerResPorFecha(@RequestBody Reserva res){	
		return  consServ.traerReservaPorFecha(res);			
	}
}
