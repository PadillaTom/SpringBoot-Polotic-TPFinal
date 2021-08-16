package com.padillatomas.tpfinal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padillatomas.tpfinal.model.Habitacion;
import com.padillatomas.tpfinal.repository.HabitacionRepository;
import com.padillatomas.tpfinal.service.HabitacionService;

@Service
public class HabitacionServiceImpl implements HabitacionService {
	
	private HabitacionRepository habitacionRepository;
	
	public HabitacionServiceImpl (HabitacionRepository habitacionRepository) {
		super();
		this.habitacionRepository = habitacionRepository;
	}
	
	
	
	// --- FETCH ALL ---
	@Override
	public List<Habitacion> fetchHabitaciones() {		
		return habitacionRepository.findAll();
	}

}
