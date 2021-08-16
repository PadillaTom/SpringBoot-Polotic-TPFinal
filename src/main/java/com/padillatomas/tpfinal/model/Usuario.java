package com.padillatomas.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToOne
	@JoinColumn(
			name= "empleado_id",
			referencedColumnName = "empleadoId"
			)
	private Empleado usuEmpleado;

	
	public Usuario() {};	
	
	public Usuario(String username, String password, Empleado usuEmpleado) {
		this.username = username;
		this.password = password;
		this.usuEmpleado = usuEmpleado;
	}

	public long getId() {
		return usuarioId;
	}

	public void setId(long id) {
		this.usuarioId = id;
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
	
	
	
}