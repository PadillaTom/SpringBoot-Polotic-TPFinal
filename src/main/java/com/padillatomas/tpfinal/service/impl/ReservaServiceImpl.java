package com.padillatomas.tpfinal.service.impl;

import java.util.Calendar;
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
		
//	::: POST :::
	
	@Override
	public String verifReserva(Reserva reserva) {
		// Calendars
		Calendar calIn = Calendar.getInstance();
		Calendar calOut = Calendar.getInstance();
		Calendar calDbIn = Calendar.getInstance();
		Calendar calDbOut = Calendar.getInstance();	
		
		// Traer Res por Tipo Habitacion:
		String myTipo = reserva.getResHabitacion().getTipoHabitacion();
		List<Reserva> myList = reservaRepository.findByResHabitacionTipoHabitacion(myTipo);
		
		// Traer Fechas in y out:
		Date resIn = reserva.getFechaDe();
		Date resOut = reserva.getFechaHasta();
		
		// Transform DATE:
		calIn.setTime(resIn);
		calIn.set(Calendar.HOUR_OF_DAY, 0);
		calIn.set(Calendar.MINUTE, 0);
		calIn.set(Calendar.SECOND, 0);
		calIn.set(Calendar.MILLISECOND, 0);
		
		calOut.setTime(resOut);
		calOut.set(Calendar.HOUR_OF_DAY, 0);
		calOut.set(Calendar.MINUTE, 0);
		calOut.set(Calendar.SECOND, 0);
		calOut.set(Calendar.MILLISECOND, 0);
				
		if(myList.size() > 0) {
			for(Reserva res: myList) {
				Date fechaDesde = res.getFechaDe();
				Date fechaHasta = res.getFechaHasta();	
				
				if( ((calIn.before(fechaDesde) && calOut.before(fechaHasta)) == true) || ((calIn.after(fechaHasta) && calOut.after(fechaHasta)) == true) ) {
					return "yes";
				} else {
					return "no";
				}
			}
		} else {
			return "yes";
		}		
		return "return";
	}
	
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
        } else {
        	Huesped myNewH = reserva.getResHuesped();
        	huespedRepository.save(myNewH);
        	reserva.setResHuesped(myNewH);
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

//	::: FETCH :::
	
	@Override
	public List<Reserva> traerAllReservas() {		
		return reservaRepository.findAll();
	}

	// ::: LAST RESERVA :::
	@Override
	public Reserva traerLastReserva() {		
		return reservaRepository.lastItem();
	}


}
