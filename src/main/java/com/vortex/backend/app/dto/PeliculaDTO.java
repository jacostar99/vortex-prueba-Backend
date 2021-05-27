package com.vortex.backend.app.dto;

import java.util.Date;

public class PeliculaDTO {

	private Integer peliId;

	private String nombre;

	private Long precioTicket;

	private String informacion;

	private Date fechaEstreno;

	private String habilitado;

	private Integer duracion;
	
	private String imagen;

	public Integer getPeliId() {
		return peliId;
	}

	public void setPeliId(Integer peliId) {
		this.peliId = peliId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getPrecioTicket() {
		return precioTicket;
	}

	public void setPrecioTicket(Long precioTicket) {
		this.precioTicket = precioTicket;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	

}
