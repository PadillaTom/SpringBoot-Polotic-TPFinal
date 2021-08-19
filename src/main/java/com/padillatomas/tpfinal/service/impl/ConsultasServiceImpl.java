package com.padillatomas.tpfinal.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.padillatomas.tpfinal.model.Empleado;
import com.padillatomas.tpfinal.model.Huesped;
import com.padillatomas.tpfinal.model.Reserva;
import com.padillatomas.tpfinal.repository.HuespedRepository;
import com.padillatomas.tpfinal.repository.ReservaRepository;
import com.padillatomas.tpfinal.service.ConsultasService;

@Service
public class ConsultasServiceImpl implements ConsultasService {
	
	private ReservaRepository resRepo;
	private HuespedRepository huesRepo;
	public ConsultasServiceImpl(ReservaRepository resRepo, HuespedRepository huesRepo) {
		super();
		this.resRepo = resRepo;
		this.huesRepo = huesRepo;
	}

	@Override
	public List<Reserva> traerResPorEmp(Empleado emple) {	
		String dniBuscado = emple.getDniEmpleado();
		return resRepo.findByResUsuarioUsuEmpleadoDniEmpleado(dniBuscado);			
	}

	@Override
	public List<Huesped> traerAllHuesped( ) {
		return huesRepo.findAll();		
	}

	@Override
	public List<Reserva> traerReservaPorFecha(Reserva res) {		
		Date fecha = res.getFechaDeCarga();
		return resRepo.findByFechaDeCarga(fecha);
	}

}
