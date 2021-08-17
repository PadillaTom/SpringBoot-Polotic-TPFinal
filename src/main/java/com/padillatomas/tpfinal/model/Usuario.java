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
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long usuarioId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			name= "empleado_id",
			referencedColumnName = "empleadoId"
			)
	private Empleado usuEmpleado;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="reserva_id", referencedColumnName ="reservaId")
	private List<Reserva> usuReserva;
	
	public Usuario() {};	
	
	public Usuario(String username, String password, Empleado usuEmpleado) {
		this.username = username;
		this.password = password;
		this.usuEmpleado = usuEmpleado;
	}

	public long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Empleado getUsuEmpleado() {
		return usuEmpleado;
	}

	public void setUsuEmpleado(Empleado usuEmpleado) {
		this.usuEmpleado = usuEmpleado;
	}
	
	public List<Reserva> getUsuReserva() {
		return usuReserva;
	}

	public void setUsuReserva(List<Reserva> usuReserva) {
		this.usuReserva = usuReserva;
	}
	
	
	
}