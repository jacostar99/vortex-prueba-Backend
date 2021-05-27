package com.vortex.backend.app.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "factura_pelicula")
public class FacturaPelicula implements Serializable {

	@Id
	@Column(name = "fcpe_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fcpeId;

	@Column(name = "fecha_ticket", nullable = false)
	private Date fechaTicket;

	@Column(name = "cantidad_ticket", nullable = false)
	@Min(0)
	@NotNull
	@NotEmpty
	private Integer cantidadTicket;

	// valor total de los tickets de esa pelicula
	@Column(name = "fecha_compra", unique = true, nullable = false)
	@Min(1)
	@NotNull
	@NotEmpty
	private double totalPelicula;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "peli_id", nullable = false)
	private Pelicula pelicula;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fact_id", nullable = false)
	private Factura factura;

	public FacturaPelicula(Integer fcpeId, Pelicula pelicula, Factura factura, Date fechaTicket, Integer cantidadTicket,
			double totalPelicula) {
		super();
		this.fcpeId = fcpeId;
		this.pelicula = pelicula;
		this.factura = factura;
		this.fechaTicket = fechaTicket;
		this.cantidadTicket = cantidadTicket;
		this.totalPelicula = totalPelicula;
	}

	public FacturaPelicula() {
		super();
	}

	public Integer getFcpeId() {
		return fcpeId;
	}

	public void setFcpeId(Integer fcpeId) {
		this.fcpeId = fcpeId;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 6870232405100860027L;

}
