package com.vortex.backend.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "metodo_de_pago")
public class MetodoDePago implements Serializable {

	@Id
	@Column(name = "pago_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pagoId;

	@Column(name = "nombre", nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 300)
	private String nombre;

	@Column(name = "habilitado", nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 1)
	private String habilitado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "metodoDePago")
	private List<Factura> listFacts = new ArrayList<>();
    
	
	public MetodoDePago() {
		super();
	}

	public MetodoDePago(Integer pagoId, String nombre, String habilitado, List<Factura> listFacts) {
		super();
		this.pagoId = pagoId;
		this.nombre = nombre;
		this.habilitado = habilitado;
		this.listFacts = listFacts;
	}

	public List<Factura> getListFacts() {
		return listFacts;
	}

	public void setListFacts(List<Factura> listFacts) {
		this.listFacts = listFacts;
	}

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 5768995542019550579L;

}
