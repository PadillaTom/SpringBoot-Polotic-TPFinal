package com.padillatomas.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.padillatomas.tpfinal.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	@Query("select * from reservas ORDER BY reservaId DESC LIMIT 1")
	Reserva lastItem();
}
