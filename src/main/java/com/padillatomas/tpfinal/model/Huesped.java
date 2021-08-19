package com.padillatomas.tpfinal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "huespedes")
public class Huesped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long huespedId;
	
	@Column(name="dni_huesped")
	private String dniHuesped;
	
	@Column(name="nombre_huesped")
	private String nombreHuesped;
	
	@Column(name="apellido_huesped")
	private String apellidoHuesped;
	
	@Column(name="fecha_nac_huesped")
	@Temporal(TemporalType.DATE)
	private Date fechaNacHuesped;
	
	@Column(name="direccion_huesped")
	private String direccionHuesped;
	
	@Column(name="profesion_huesped")
	private String profesionHuesped;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Reserva> huesReserva = new ArrayList<>();
	
	public Huesped() {}
	
	public Huesped(String dniHuesped, String nombreHuesped, String apellidoHuesped, Date fechaNacHuesped,
			String direccionHuesped, String profesionHuesped) {
		super();
		this.dniHuesped = dniHuesped;
		this.nombreHuesped = nombreHuesped;
		this.apellidoHuesped = apellidoHuesped;
		this.fechaNacHuesped = fechaNacHuesped;
		this.direccionHuesped = direccionHuesped;
		this.profesionHuesped = profesionHuesped;
	}

	public Long getHuespedId() {
		return huespedId;
	}
	public void setHuespedId(Long huespedId) {
		this.huespedId = huespedId;
	}
	public String getDniHuesped() {
		return dniHuesped;
	}
	public void setDniHuesped(String dniHuesped) {
		this.dniHuesped = dniHuesped;
	}
	public String getNombreHuesped() {
		return nombreHuesped;
	}
	public void setNombreHuesped(String nombreHuesped) {
		this.nombreHuesped = nombreHuesped;
	}
	public String getApellidoHuesped() {
		return apellidoHuesped;
	}
	public void setApellidoHuesped(String apellidoHuesped) {
		this.apellidoHuesped = apellidoHuesped;
	}
	public Date getFechaNacHuesped() {
		return fechaNacHuesped;
	}
	public void setFechaNacHuesped(Date fechaNacHuesped) {
		this.fechaNacHuesped = fechaNacHuesped;
	}
	public String getDireccionHuesped() {
		return direccionHuesped;
	}
	public void setDireccionHuesped(String direccionHuesped) {
		this.direccionHuesped = direccionHuesped;
	}
	public String getProfesionHuesped() {
		return profesionHuesped;
	}
	public void setProfesionHuesped(String profesionHuesped) {
		this.profesionHuesped = profesionHuesped;
	}
	public List<Reserva> getHuesReserva() {
		return huesReserva;
	}
	public void setHuesReserva(List<Reserva> huesReserva) {
		this.huesReserva = huesReserva;
	}
	
	
	
}
