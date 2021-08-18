package com.padillatomas.tpfinal.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.padillatomas.tpfinal.model.Habitacion;
import com.padillatomas.tpfinal.model.Huesped;
import com.padillatomas.tpfinal.model.Reserva;
import com.padillatomas.tpfinal.model.Usuario;
import com.padillatomas.tpfinal.repository.HabitacionRepository;
import com.padillatomas.tpfinal.repository.HuespedRepository;
import com.padillatomas.tpfinal.repository.ReservaRepository;
import com.padillatomas.tpfinal.repository.UsuarioRepository;
import com.padillatomas.tpfinal.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	// Repository:
	private ReservaRepository reservaRepository;
	private HabitacionRepository habitacionRepository;
	private HuespedRepository huespedRepository;
	private UsuarioRepository usuarioRepository;
	// Constructor:
	public ReservaServiceImpl(
			ReservaRepository reservaRepository, 
			HabitacionRepository habitacionRepository, 
			HuespedRepository huespedRepository,
			UsuarioRepository usuarioRepository
			) {
		super();
		this.reservaRepository = reservaRepository;
		this.habitacionRepository = habitacionRepository;
		this.huespedRepository = huespedRepository;
		this.usuarioRepository = usuarioRepository;
		
	}
	
	// **********************************
	// Methods
	// **********************************
		
	// --- CREATE ---
	@Override
	public Reserva altaReserva(Reserva reserva) {	
		// JSON trae Huesped y Res. Repository creara Ambos
		
		// Cantidad Noches:
		Date resCheckin = reserva.getFechaDe();
		Date resCheckout = reserva.getFechaHasta();
		long nochesTime = resCheckout.getTime() - resCheckin.getTime();
        int cantidadNoches = (int) Math.floor(nochesTime / (1000*60*60*24));
        
        // Fecha Carga:
        Date dateCarga = new Date();
        
		// Find Habitacion:
        String myHabTipo = reserva.getResHabitacion().getTipoHabitacion();
        Habitacion myHab = habitacionRepository.findByTipoHabitacion(myHabTipo);
                
        // Precio Total:
        double myHabPrecio = myHab.getPrecioNocheHabitacion();
        double precioTotal = myHabPrecio * cantidadNoches;
        
        // Find Huesped:
        String myHuesDni = reserva.getResHuesped().getDniHuesped();
        Huesped existeHues = huespedRepository.findByDniHuesped(myHuesDni);
        if(existeHues != null) {
        	reserva.setResHuesped(existeHues);
        }
		
		// Find Usuario: 
        Usuario myUsu = usuarioRepository.findByUsername("AdminHotel");
        reserva.setResUsuario(myUsu);         
		
		// Setters:
        reserva.setFechaDeCarga(dateCarga);
        reserva.setCantidadNoches(cantidadNoches);
        reserva.setPrecioTotal(precioTotal);
        reserva.setResHabitacion(myHab);
		return reservaRepository.save(reserva);
	}

	@Override
	public List<Reserva> traerAllReservas() {		
		return reservaRepository.findAll();
	}

	// ::: LAST RESERVA :::
	@Override
	public Reserva traerLastReserva() {		
		return reservaRepository.findTopByOrderByReservaIdDesc();
	}

}
