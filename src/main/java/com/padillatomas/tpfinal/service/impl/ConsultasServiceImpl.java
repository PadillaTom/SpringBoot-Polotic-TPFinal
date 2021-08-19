package com.padillatomas.tpfinal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padillatomas.tpfinal.model.Empleado;
import com.padillatomas.tpfinal.model.Huesped;
import com.padillatomas.tpfinal.model.Reserva;
import com.padillatomas.tpfinal.repository.ReservaRepository;
import com.padillatomas.tpfinal.service.ConsultasService;

@Service
public class ConsultasServiceImpl implements ConsultasService {
	
	private ReservaRepository resRepo;
	public ConsultasServiceImpl(ReservaRepository resRepo) {
		super();
		this.resRepo = resRepo;
	}

	@Override
	public List<Reserva> traerResPorEmp(Empleado emple) {	
		String dniBuscado = emple.getDniEmpleado();
		return resRepo.findByResUsuarioUsuEmpleadoDniEmpleado(dniBuscado);			
	}

	@Override
	public List<Reserva> traerResPorHues(Huesped hues) {
		String dniBuscado = hues.getDniHuesped();
		return resRepo.findByResHuespedDniHuesped(dniBuscado);
	}

}
