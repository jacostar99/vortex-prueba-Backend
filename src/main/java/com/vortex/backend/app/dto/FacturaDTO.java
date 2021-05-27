package com.vortex.backend.app.dto;

import java.util.Date;

public class FacturaDTO {

	private Integer factId;

	private double total;

	private Integer cantTotalpelis;

	private Date fechaCompra;

	private String email;

	private Integer pagoId;
    
	//TODO constructor
	
	
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPagoId() {
		return pagoId;
	}

	public void setPagoId(Integer pagoId) {
		this.pagoId = pagoId;
	}
	
	


}
