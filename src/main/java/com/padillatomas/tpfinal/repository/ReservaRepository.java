package com.padillatomas.tpfinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.padillatomas.tpfinal.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	// Last Reserva:
	@Query(value ="select * from reservas ORDER BY reserva_id DESC LIMIT 1", nativeQuery = true)
	Reserva lastItem();
	
	// PorDni:
	List<Reserva> findByResUsuarioUsuEmpleadoDniEmpleado(String dni);
	List<Reserva> findByResHuespedDniHuesped(String dni);	
	
}
