package com.example.demo.service;

import java.io.Serializable;

public class UsuarioTo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1343556L;

	private String nombre;

	private String password;

	private String semilla;

	private Integer tiempo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSemilla() {
		return semilla;
	}

	public void setSemilla(String semilla) {
		this.semilla = semilla;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	
	
}
