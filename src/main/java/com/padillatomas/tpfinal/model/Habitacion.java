package com.padillatomas.tpfinal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="habitaciones")
public class Habitacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long habitacionId;
	
	@Column(name="piso_habitacion")
	private int pisoHabitacion;
	@Column(name="nombre_habitacion")
	private String nombreHabitacion;
	@Column(name="tipo_habitacion")
	private String tipoHabitacion;
	@Column(name="precio_noche_habitacion")
	private double precioNocheHabitacion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="reserva_id", referencedColumnName ="reservaId")
	private List<Reserva> habReserva;
	

	public Habitacion() {
		
	}	
	
	public Habitacion(int pisoHabitacion, String nombreHabitacion, String tipoHabitacion,
			double precioNocheHabitacion) {
		super();
		this.pisoHabitacion = pisoHabitacion;
		this.nombreHabitacion = nombreHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.precioNocheHabitacion = precioNocheHabitacion;
	}
	
	
	public Long getHabitacionId() {
		return habitacionId;
	}
	public void setHabitacionId(Long habitacionId) {
		this.habitacionId = habitacionId;
	}
	public int getPisoHabitacion() {
		return pisoHabitacion;
	}
	public void setPisoHabitacion(int pisoHabitacion) {
		this.pisoHabitacion = pisoHabitacion;
	}
	public String getNombreHabitacion() {
		return nombreHabitacion;
	}
	public void setNombreHabitacion(String nombreHabitacion) {
		this.nombreHabitacion = nombreHabitacion;
	}
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	public double getPrecioNocheHabitacion() {
		return precioNocheHabitacion;
	}
	public void setPrecioNocheHabitacion(double precioNocheHabitacion) {
		this.precioNocheHabitacion = precioNocheHabitacion;
	}
	public List<Reserva> getHabReserva() {
		return habReserva;
	}
	public void setHabReserva(List<Reserva> habReserva) {
		this.habReserva = habReserva;
	}
	
	
	

}
