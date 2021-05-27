package com.vortex.backend.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.vortex.backend.app.domain.MetodoDePago;
import com.vortex.backend.app.dto.MetodoDePagoDTO;

@Mapper
public interface MetodoDePagoMapper {
	
	public MetodoDePagoDTO toMetodoDePagoDTO(MetodoDePago metodoDePago);

	public MetodoDePago toMetodoDePago(MetodoDePagoDTO metodoDePagoDTO);

	public List<MetodoDePagoDTO> toMetodoDePagosDTO(List<MetodoDePago> metodoDePago);

	public List<MetodoDePago> toMetodoDePagos(List<MetodoDePagoDTO> metodoDePagoDTO);


}
