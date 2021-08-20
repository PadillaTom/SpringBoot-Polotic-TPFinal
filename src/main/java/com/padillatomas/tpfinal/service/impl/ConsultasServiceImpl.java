package com.padillatomas.tpfinal.service.impl;

import java.util.ArrayList;
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

	@Override
	public List<Reserva> traerResPorHyF(Reserva reserva) {
		List<Reserva> finalList = new ArrayList<>();
		// Res by Huesped:
		String huesDni = reserva.getResHuesped().getDniHuesped();
		List<Reserva> myRes = resRepo.findByResHuespedDniHuesped(huesDni);
		// Comparar Fechas:
		Date resJsonIn = reserva.getFechaDe();
		Date resJsonOut = reserva.getFechaHasta();
		
		
		if( myRes != null) {
			for(Reserva res: myRes ) {
				Date resDbIn = res.getFechaDe();
				Date resDbOut = res.getFechaHasta();
				if(((resDbIn.after(resJsonIn) && resDbIn.before(resJsonOut)) || (resDbOut.after(resJsonIn) && resDbOut.before(resJsonOut))) || (resDbIn.before(resJsonOut)&&(resDbOut.after(resJsonIn)))){
					finalList.add(res);
				}
			}
		}		
		return finalList;
	}

}
