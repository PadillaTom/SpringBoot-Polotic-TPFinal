package com.padillatomas.tpfinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.tpfinal.model.Empleado;
import com.padillatomas.tpfinal.model.Huesped;
import com.padillatomas.tpfinal.model.Reserva;
import com.padillatomas.tpfinal.service.ConsultasService;

@CrossOrigin(origins = {"http://localhost:3000","https://tpfinal-polotic.netlify.app"}, allowedHeaders = "*")
@RestController
@RequestMapping("/api/consultaResPorDni")
public class ConsultaHuespedesYresEmp {
	
	private ConsultasService consServ;	
	public ConsultaHuespedesYresEmp(ConsultasService consServ) {
		super();
		this.consServ = consServ;
	}
	
	// ::: GET Reservas :::
	@PostMapping
	public List<Reserva> traerResPorEmp(@RequestBody Empleado emple){	
		return  consServ.traerResPorEmp(emple);			
	}
	
	@GetMapping
	public List<Huesped> traerHuespedes(){
		return consServ.traerAllHuesped();
	}

}
