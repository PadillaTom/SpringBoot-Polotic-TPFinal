package com.padillatomas.tpfinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.tpfinal.model.Habitacion;
import com.padillatomas.tpfinal.service.HabitacionService;

@CrossOrigin(origins = {"http://localhost:3000","https://tpfinal-polotic.netlify.app"}, allowedHeaders = "*")
@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

	private HabitacionService habitacionService;
	
	public HabitacionController(HabitacionService habitacionService) {
		super();
		this.habitacionService = habitacionService;
	}
	
	// --- GET ALL ---
	@GetMapping
	public List<Habitacion> fetchAllHabitaciones(){
		return habitacionService.fetchHabitaciones();
	}
	
}
