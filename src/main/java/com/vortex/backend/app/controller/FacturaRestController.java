package com.vortex.backend.app.controller;

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

import com.vortex.backend.app.dto.FacturaDTO;

@RestController
@RequestMapping("/api/factura")
@CrossOrigin("*")
public class FacturaRestController {
	
	@GetMapping("/consultarTodasFactura")
	public ResponseEntity<?> consultarTodos() throws Exception{
		return null;
	}
	
	@GetMapping("/consultaFacturaPorId/{factId}")
	public ResponseEntity<?> consultarFacturaPorId(@PathVariable ("factId") Integer factId) throws Exception{
		return null;
	}
	
	@PostMapping("/guardarFactura")
	public ResponseEntity<?> guardarFactura(@RequestBody FacturaDTO facturaDTO) throws Exception{
		return null;
	}
	
	@PutMapping("/actualizarFactura")
	public ResponseEntity<?> actualizarFactura(@RequestBody FacturaDTO facturaDTO) throws Exception{
		return null;
	}
	
	@DeleteMapping("/eliminarFactura/{factId}")
	public ResponseEntity<?> eliminarFactura(@PathVariable ("factId") Integer pagoId) throws Exception{
		return null;
	}
	
	

}
