package com.padillatomas.tpfinal.service;

import java.util.List;

import com.padillatomas.tpfinal.model.Empleado;
import com.padillatomas.tpfinal.model.Huesped;
import com.padillatomas.tpfinal.model.Reserva;

public interface ConsultasService {
	
	List<Reserva> traerResPorEmp(Empleado dni);
	List<Reserva> traerResPorHues(Huesped dni);

}
