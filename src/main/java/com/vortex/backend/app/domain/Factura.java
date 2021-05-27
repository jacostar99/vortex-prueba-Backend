	package com.vortex.backend.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {

	@Id
	@Column(name = "fact_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer factId;

	@Column(name = "total", unique = true, nullable = false)
	@Min(1)
	@NotNull
	@NotEmpty
	private double total;

	@Column(name = "cant_total_pelis", unique = true, nullable = false)
	@Min(0)
	@NotNull
	@NotEmpty
	private Integer cantTotalpelis;

	@Column(name = "fecha_compra", unique = true, nullable = false)
	private Date fechaCompra;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pago_id")
	private MetodoDePago metodoDePago;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "factura")
	private List<FacturaPelicula> listFactPeli = new ArrayList<>();

	public Factura(Integer factId, double total, Integer cantTotalpelis, Date fechaCompra, Usuario usuario,
			MetodoDePago metodoDePago, List<FacturaPelicula> listFactPeli) {
		super();
		this.factId = factId;
		this.total = total;
		this.cantTotalpelis = cantTotalpelis;
		this.fechaCompra = fechaCompra;
		this.usuario = usuario;
		this.metodoDePago = metodoDePago;
		this.listFactPeli = listFactPeli;
	}

	public List<FacturaPelicula> getListFactPeli() {
		return listFactPeli;
	}

	public void setListFactPeli(List<FacturaPelicula> listFactPeli) {
		this.listFactPeli = listFactPeli;
	}

	public Integer getFactId() {
		return factId;
	}

	public void setFactId(Integer factId) {
		this.factId = factId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getCantTotalpelis() {
		return cantTotalpelis;
	}

	public void setCantTotalpelis(Integer cantTotalpelis) {
		this.cantTotalpelis = cantTotalpelis;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public MetodoDePago getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(MetodoDePago metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	public Factura() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8812768953312198807L;

}
