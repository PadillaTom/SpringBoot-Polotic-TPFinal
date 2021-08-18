package com.padillatomas.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padillatomas.tpfinal.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	Reserva findTopByOrderByReservaIdDesc();
}
