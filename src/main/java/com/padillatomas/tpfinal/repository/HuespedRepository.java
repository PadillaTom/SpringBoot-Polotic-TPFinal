package com.padillatomas.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padillatomas.tpfinal.model.Huesped;

public interface HuespedRepository extends JpaRepository<Huesped, Long> {
	
	Huesped findByDniHuesped(String dniHuesped);
	
}
