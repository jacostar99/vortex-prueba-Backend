package com.vortex.backend.app.service;

import java.util.List;

import com.vortex.backend.app.domain.FacturaPelicula;

public interface FacturaPeliculaService extends GenericService<FacturaPelicula , Integer> {
	
	public Long totalFacturaPeliculatByFactura(Integer factId);
	
	public Integer totalItems(Integer factId);
	
	public FacturaPelicula getFcPeByFactPeli(Integer factId , Integer peliId);
	
	public List<Integer> getFapeIdByFactId(Integer factId);
	
	public List<FacturaPelicula> findFapeByFactId(Integer factdId);

}
