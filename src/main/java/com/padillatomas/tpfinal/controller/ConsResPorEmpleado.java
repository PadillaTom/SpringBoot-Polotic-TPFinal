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
public class ConsResPorEmpleado {
	
	private ConsultasService consServ;
	public ConsResPorEmpleado(ConsultasService consServ) {
		super();
		this.consServ = consServ;
	}
	
	// ::: GET Reservas :::
	@GetMapping
	public List<Reserva> traerResPorEmp(@RequestBody Empleado emple){	
		return  consServ.traerResPorEmp(emple);			
	}
	
	@PostMapping
	public List<Reserva> traerResPorHues(@RequestBody Huesped hues){
		return consServ.traerResPorHues(hues);
	}

}
