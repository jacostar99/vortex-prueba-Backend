package com.vortex.backend.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vortex.backend.app.domain.Factura;
import com.vortex.backend.app.domain.Pelicula;

public interface FacturaRepository extends JpaRepository<Factura , Integer> {
	
	@Query("SELECT fact FROM Factura fact WHERE fact.usuario.email=:email")
	public List<Factura> findFactByEmail(String email);
	@Query("SELECT peli FROM Factura fact JOIN FacturaPelicula factpeli ON fact.factId=:factId JOIN Pelicula peli ON peli.peliId=factpeli.pelicula.peliId")
	public List<Pelicula> findPeliculaByFactId(Integer factId);

}
