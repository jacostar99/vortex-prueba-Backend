package com.vortex.backend.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vortex.backend.app.domain.Factura;
import com.vortex.backend.app.dto.FacturaDTO;

@Mapper
public interface FacturaMapper {
	
	@Mapping(source = "metodoDePago.pagoId", target = "pagoId")
	@Mapping(source = "usuario.email", target = "email")  
	public FacturaDTO toFacturaDTO(Factura factura);
    

	@Mapping(source = "pagoId", target = "metodoDePago.pagoId")
	@Mapping(source = "email", target = "usuario.email")
	public Factura toFactura(FacturaDTO facturaDTO);

	public List<FacturaDTO> toFacturasDTO(List<Factura> facturas);

	public List<Factura> toUsuarios(List<FacturaDTO> facturasDTO);


}
