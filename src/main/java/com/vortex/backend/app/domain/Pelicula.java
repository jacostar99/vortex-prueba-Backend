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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "peli_id", unique = true , nullable = false)
	private Integer peliId;

	@Column(name = "nombre", nullable = false)
	@Size(min = 1, max = 300)
	@NotNull
	@NotEmpty
	private String nombre;

	@Column(name = "precio_ticket", nullable = false)
	@Min(1)
	@NotNull	
	private Long precioTicket;

	@Column(name = "informacion", nullable = false)
	@Size(min = 1, max = 300)
	@NotNull
	@NotEmpty
	private String informacion;

	@Column(name = "fecha_estreno", nullable = false)
	private Date fechaEstreno;

	@Column(name = "habilitado", nullable = false)
	@Size(min = 1, max = 1)
	@NotNull
	@NotEmpty
	private String habilitado;

	@Column(name = "duracion", nullable = false)
	@NotNull
	private Integer duracion;

	@Column(name = "imagen")
	@Size(min = 1, max = 300)
	private String imagen;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pelicula")
	private List<FacturaPelicula> listFactPeli = new ArrayList<>();

	public Pelicula() {
		super();
	}

	public Pelicula(Integer peliId, String nombre, Long precioTicket, String informacion, Date fechaEstreno,
			String habilitado, Integer duracion, String imagen, List<FacturaPelicula> listFactPeli) {
		super();
		this.peliId = peliId;
		this.nombre = nombre;
		this.precioTicket = precioTicket;
		this.informacion = informacion;
		this.fechaEstreno = fechaEstreno;
		this.habilitado = habilitado;
		this.duracion = duracion;
		this.imagen = imagen;
		this.listFactPeli = listFactPeli;
	}

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

	public List<FacturaPelicula> getListFactPeli() {
		return listFactPeli;
	}

	public void setListFactPeli(List<FacturaPelicula> listFactPeli) {
		this.listFactPeli = listFactPeli;
	}
	
	

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = -9211605348698487806L;

}
