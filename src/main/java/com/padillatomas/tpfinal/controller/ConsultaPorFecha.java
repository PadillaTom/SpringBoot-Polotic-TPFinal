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
	
	// ::: POST Reservas y GananciasDiarias :::
	@PostMapping
	public List<Reserva> traerResPorFecha(@RequestBody Reserva res){	
		return  consServ.traerReservaPorFecha(res);			
	}
	
	// ::: POST Reservas :::	
	@PostMapping("/porHyF")
	public List<Reserva> traerResPorHyF(@RequestBody Reserva res){	
		return consServ.traerResPorHyF(res);
	}
	
	// ::: POST Res Diarias Empleado :::	
	@PostMapping("/resDiariasEmpleado")
	public List<Reserva> traerResDiariasPorEmp(@RequestBody Reserva res){	
		return consServ.traerResDiariasPorEmpleado(res);
	}
		
	
	// ::: POST Ganancias Mensuales :::	
	@PostMapping("/ganMensuales")
	public List<Reserva> traerResMensuales(@RequestBody Reserva res){	
		return consServ.traerReservasMensuales(res);
	}
	
	
}
