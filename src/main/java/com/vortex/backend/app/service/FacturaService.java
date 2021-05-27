package com.vortex.backend.app.service;

import java.util.List;

import com.vortex.backend.app.domain.Factura;
import com.vortex.backend.app.domain.Pelicula;

public interface FacturaService extends GenericService <Factura , Integer> {
	
	public List<Factura> findFactByEmail(String email);

	public List<Pelicula> findPeliculaByFactId(Integer factId);
	
	//public List<Factura> findFactByPayIdNull(String email);
	
	

}
