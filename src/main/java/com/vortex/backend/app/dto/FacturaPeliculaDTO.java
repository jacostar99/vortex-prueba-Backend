package com.vortex.backend.app.dto;

import java.util.Date;

public class FacturaPeliculaDTO {

	private Integer fcpeId;

	private Date fechaTicket;

	private Integer cantidadTicket;

	// valor total de los tickets de esa pelicula
	private double totalPelicula;

	private Integer peliId;

	private Integer factId;

	public Integer getFcpeId() {
		return fcpeId;
	}

	public void setFcpeId(Integer fcpeId) {
		this.fcpeId = fcpeId;
	}

	public Date getFechaTicket() {
		return fechaTicket;
	}

	public void setFechaTicket(Date fechaTicket) {
		this.fechaTicket = fechaTicket;
	}

	public Integer getCantidadTicket() {
		return cantidadTicket;
	}

	public void setCantidadTicket(Integer cantidadTicket) {
		this.cantidadTicket = cantidadTicket;
	}

	public double getTotalPelicula() {
		return totalPelicula;
	}

	public void setTotalPelicula(double totalPelicula) {
		this.totalPelicula = totalPelicula;
	}

	public Integer getPeliId() {
		return peliId;
	}

	public void setPeliId(Integer peliId) {
		this.peliId = peliId;
	}

	public Integer getFactId() {
		return factId;
	}

	public void setFactId(Integer factId) {
		this.factId = factId;
	}
	
	

}
