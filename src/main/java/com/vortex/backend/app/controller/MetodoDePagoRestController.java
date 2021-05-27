	package com.vortex.backend.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vortex.backend.app.domain.MetodoDePago;
import com.vortex.backend.app.dto.MetodoDePagoDTO;
import com.vortex.backend.app.mapper.MetodoDePagoMapper;
import com.vortex.backend.app.service.MetodoDePagoService;

@RestController
@RequestMapping("/api/metodoDePago")
@CrossOrigin("*")
public class MetodoDePagoRestController {

	@Autowired
	MetodoDePagoService metodoDePagoService;

	@Autowired
	MetodoDePagoMapper metodoDePagoMapper;
    
	
	//CONSULTAR TODOS LOS METODOS DE PAGO
	@GetMapping("/consultarTodosMetodosDePago")
	public ResponseEntity<?> consultarTodos() throws Exception {
		List<MetodoDePago> metodosDePago = metodoDePagoService.consultarTodos();
		List<MetodoDePagoDTO> metodosDePagoDTO = metodoDePagoMapper.toMetodoDePagosDTO(metodosDePago);

		return ResponseEntity.ok().body(metodosDePagoDTO);
	}
    
	
	//CONSULTAR METODO DE PAGO POR ID
	@GetMapping("/consultarMetodoDePagoPorId/{pagoId}")
	public ResponseEntity<?> consultarMetodoDePagoPorId(@PathVariable("pagoId") Integer pagoId) throws Exception {
		Optional<MetodoDePago> metodoDePagoOptional = metodoDePagoService.consultarPorId(pagoId);
		if (metodoDePagoOptional.isPresent() == false) {
			return ResponseEntity.ok().body(null);
		}

		MetodoDePago metodoDePago = metodoDePagoOptional.get();
		MetodoDePagoDTO metodoDePagoDTO = metodoDePagoMapper.toMetodoDePagoDTO(metodoDePago);

		return ResponseEntity.ok().body(metodoDePagoDTO);
	}
    
	
	//GUARDAR METODO DE PAGO
	@PostMapping("/guardarMetodoDePago")
	public ResponseEntity<?> guardarMetodoDePago(@RequestBody MetodoDePagoDTO metodoDePagoDTO) throws Exception {

		MetodoDePago metodoDePago = metodoDePagoMapper.toMetodoDePago(metodoDePagoDTO);
		metodoDePago = metodoDePagoService.guardar(metodoDePago);
		metodoDePagoDTO = metodoDePagoMapper.toMetodoDePagoDTO(metodoDePago);

		return ResponseEntity.ok().body(metodoDePagoDTO);
	}
    
	
	//ACTUALIZAR METODO DE PAGO
	@PutMapping("/actualizarMetodoDePago")
	public ResponseEntity<?> actualizarMetodoDePago(@RequestBody MetodoDePagoDTO metodoDePagoDTO) throws Exception {

		MetodoDePago metodoDePago = metodoDePagoMapper.toMetodoDePago(metodoDePagoDTO);
		metodoDePago = metodoDePagoService.actualizar(metodoDePago);
		metodoDePagoDTO = metodoDePagoMapper.toMetodoDePagoDTO(metodoDePago);

		return ResponseEntity.ok().body(metodoDePagoDTO);
	}
    
	
	//ELIMINAR METODO DE PAGO
	@DeleteMapping("/eliminarMetodoDePago/{pagoId}")
	public ResponseEntity<?> eliminarMetodoDePago(@PathVariable("pagoId") Integer pagoId) throws Exception {
		metodoDePagoService.eliminarPorId(pagoId);

		return ResponseEntity.ok().build();
	}

}
