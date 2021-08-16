package com.padillatomas.tpfinal.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empleadoId;
	
	@Column(name = "dni_empleado")
	private String dniEmpleado;
	@Column(name = "nombre_empleado")
	private String nombreEmpleado;
	@Column(name = "apellido_empleado")
	private String apellidoEmpleado;
	@Column(name = "fecha_nac_empleado")
	private Date fechaNacEmpleado;
	@Column(name = "direccion_empleado")
	private String direccionEmpleado;
	@Column(name = "cargo_empleado")
	private String cargoEmpleado;
	
	
	public Empleado() {};
	
	public Empleado(String dniEmpleado, String apellidoEmpleado, Date fechaNacEmpleado, String direccionEmpleado,
			String cargoEmpleado) {
		super();
		this.dniEmpleado = dniEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.fechaNacEmpleado = fechaNacEmpleado;
		this.direccionEmpleado = direccionEmpleado;
		this.cargoEmpleado = cargoEmpleado;
	}
	
	
	public Long getEmpleadoId() {
		return empleadoId;
	}
	public void setEmpleadoId(Long empleadoId) {
		this.empleadoId = empleadoId;
	}
	public String getDniEmpleado() {
		return dniEmpleado;
	}
	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}
	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}
	public Date getFechaNacEmpleado() {
		return fechaNacEmpleado;
	}
	public void setFechaNacEmpleado(Date fechaNacEmpleado) {
		this.fechaNacEmpleado = fechaNacEmpleado;
	}
	public String getDireccionEmpleado() {
		return direccionEmpleado;
	}
	public void setDireccionEmpleado(String direccionEmpleado) {
		this.direccionEmpleado = direccionEmpleado;
	}
	public String getCargoEmpleado() {
		return cargoEmpleado;
	}
	public void setCargoEmpleado(String cargoEmpleado) {
		this.cargoEmpleado = cargoEmpleado;
	}
	

}
