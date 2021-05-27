package com.vortex.backend.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vortex.backend.app.domain.FacturaPelicula;

public interface FacturaPeliculaRepository extends JpaRepository<FacturaPelicula , Integer>  {
	
	//SHOPPING CART -------------> FACTURA
	//SHOPPING PRODUCT ----------> FACTURAPELICULA
	
	@Query("SELECT SUM(fape.totalPelicula) FROM FacturaPelicula fape WHERE fape.factura.factId=:factId")
	public Long totalFacturaPeliculatByFactura(Integer factId);

	@Query("SELECT SUM(fape.cantidadTicket) FROM FacturaPelicula fape WHERE fape.factura.factId=:factId")
	public Integer totalItems(Integer factId);

	@Query("SELECT fape FROM FacturaPelicula fape WHERE fape.factura.factId=:factId AND fape.pelicula.peliId=:peliId")
	public FacturaPelicula getFcPeByFactPeli(Integer factId, Integer peliId);

	@Query("SELECT fape.fcpeId FROM FacturaPelicula fape WHERE fape.factura.factId=:factId")
	public List<Integer> getFapeIdByFactId(Integer factId);

	@Query("SELECT fape FROM FacturaPelicula fape WHERE fape.factura.factId=:factId")
	public List<FacturaPelicula> findFapeByFactId(Integer factId);

}
