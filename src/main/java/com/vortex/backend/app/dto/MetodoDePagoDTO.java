package com.vortex.backend.app.dto;

public class MetodoDePagoDTO {

	private Integer pagoId;

	private String nombre;
	
	private String habilitado;

	public Integer getPagoId() {
		return pagoId;
	}

	public void setPagoId(Integer pagoId) {
		this.pagoId = pagoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}

}
