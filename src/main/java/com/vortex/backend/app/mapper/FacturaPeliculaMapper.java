package com.vortex.backend.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vortex.backend.app.domain.FacturaPelicula;
import com.vortex.backend.app.dto.FacturaPeliculaDTO;

@Mapper
public interface FacturaPeliculaMapper {
	
	
	@Mapping(source = "pelicula.peliId", target = "peliId")
	@Mapping(source = "factura.factId", target = "factId")  
	public FacturaPeliculaDTO toFacturaPeliculaDTO(FacturaPelicula facturaPelicula);
    
	@Mapping(source = "peliId", target = "pelicula.peliId")
	@Mapping(source = "factId", target = "factura.factId")  
	public FacturaPelicula toFacturaPelicula(FacturaPeliculaDTO facturaPeliculaDTO);

	public List<FacturaPeliculaDTO> toFacturasPeliculaDTO(List<FacturaPelicula> facturasPelicula);

	public List<FacturaPelicula> toFacturasPelicula(List<FacturaPeliculaDTO> facturaPeliculaDTO);

}
