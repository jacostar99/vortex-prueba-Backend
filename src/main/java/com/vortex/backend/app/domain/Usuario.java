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
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true , nullable = false)
	private Integer userId;

	@Column(name = "email", nullable = false, unique = true)
	@Size(min = 5, max = 300)
	@NotNull
	@NotEmpty
	private String email;

	@Column(name = "nombre", nullable = false)
	@Size(min = 1, max = 300)
	@NotNull
	@NotEmpty
	private String nombre;

	@Column(name = "primer_apellido", nullable = false)
	@Size(min = 1, max = 300)
	@NotNull
	@NotEmpty
	private String primerApellido;

	@Column(name = "segundo_apellido")
	@Size(min = 1, max = 300)
	private String segundoApellido;

	@Column(name = "direccion", nullable = false)
	@Size(min = 1, max = 300)
	@NotNull
	@NotEmpty
	private String direccion;

	@Column(name = "telefono", nullable = false)
	@Size(min = 1, max = 300)
	@NotNull
	@NotEmpty
	private String telefono;

	@Column(name = "contrasena", nullable = false)
	@Size(min = 1, max = 300)
	@NotNull
	@NotEmpty
	private String contrasena;

	@Column(name = "rol", nullable = false)
	@Size(min = 1, max = 1)
	@NotNull
	@NotEmpty
	private String rol;

	@Column(name = "habilitado", nullable = false)
	@Size(min = 1, max = 1)
	@NotNull
	@NotEmpty
	private String habilitado;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Factura> listFacts = new ArrayList<>();

	public Usuario() {
		super();
	}

	public Usuario(Integer userId,String email, String nombre, String primerApellido, String segundoApellido, String direccion,
			String telefono, String contrasena, String rol, String habilitado ,  List<Factura> listFacts) {
		super();
		this.userId = userId;
		this.email = email;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.rol = rol;
		this.habilitado = habilitado;
		this.listFacts = listFacts;
	}
	
	
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Factura> getListFacts() {
		return listFacts;
	}

	public void setListFacts(List<Factura> listFacts) {
		this.listFacts = listFacts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
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
	private static final long serialVersionUID = 114278166923323886L;

}
