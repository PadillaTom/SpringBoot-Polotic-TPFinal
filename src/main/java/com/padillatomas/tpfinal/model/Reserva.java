package com.padillatomas.tpfinal.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservaId;
	
	@Column(name ="fecha_de")
	private Date fechaDe;
	@Column(name ="fecha_hasta")
	private Date fechaHasta;
	@Column(name ="fecha_de_carga")
	private Date fechaDeCarga;
	@Column(name ="cantidad_personas")
	private int cantidadPersonas;
	@Column(name ="cantidad_noches")
	private int cantidadNoches;	
	@Column(name ="precio_total")
	private double precioTotal;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			name= "huesped_id",
			referencedColumnName = "huespedId"
			)	
	Huesped resHuesped;
	
	@OneToOne
	@JoinColumn(
			name= "usuario_id",
			referencedColumnName = "usuarioId"
			)
	Usuario resUsuario;
	
	@OneToOne
	@JoinColumn(
			name= "habitacion_id",
			referencedColumnName = "habitacionId"
			)
	Habitacion resHabitacion;
	
	
	public Reserva() {}

	public Reserva(Date fechaDe, Date fechaHasta, Date fechaDeCarga, int cantidadPersonas, int cantidadNoches, double precioTotal,
			Huesped resHuesped, Usuario resUsuario, Habitacion resHabitacion) {
		super();
		this.fechaDe = fechaDe;
		this.fechaHasta = fechaHasta;
		this.fechaDeCarga = fechaDeCarga;
		this.cantidadPersonas = cantidadPersonas;
		this.cantidadNoches = cantidadNoches;
		this.precioTotal = precioTotal;
		this.resHuesped = resHuesped;
		this.resUsuario = resUsuario;
		this.resHabitacion = resHabitacion;
	}

	public Long getReservaId() {
		return reservaId;
	}

	public void setReservaId(Long reservaId) {
		this.reservaId = reservaId;
	}

	public Date getFechaDe() {
		return fechaDe;
	}

	public void setFechaDe(Date fechaDe) {
		this.fechaDe = fechaDe;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Date getFechaDeCarga() {
		return fechaDeCarga;
	}

	public void setFechaDeCarga(Date fechaDeCarga) {
		this.fechaDeCarga = fechaDeCarga;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public int getCantidadNoches() {
		return cantidadNoches;
	}

	public void setCantidadNoches(int cantidadNoches) {
		this.cantidadNoches = cantidadNoches;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Huesped getResHuesped() {
		return resHuesped;
	}

	public void setResHuesped(Huesped resHuesped) {
		this.resHuesped = resHuesped;
	}

	public Usuario getResUsuario() {
		return resUsuario;
	}

	public void setResUsuario(Usuario resUsuario) {
		this.resUsuario = resUsuario;
	}

	public Habitacion getResHabitacion() {
		return resHabitacion;
	}

	public void setResHabitacion(Habitacion resHabitacion) {
		this.resHabitacion = resHabitacion;
	}
	
	
	
}
