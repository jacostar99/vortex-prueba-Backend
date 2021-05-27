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

import com.vortex.backend.app.dto.FacturaPeliculaDTO;

@RestController
@RequestMapping("/api/facturaPelicula")
@CrossOrigin("*")
public class FacturaPeliculaRestController {
	
	@GetMapping("/consultarTodasFacturaPelicula")
	public ResponseEntity<?> consultarTodos() throws Exception{
		return null;
	}
	
	@GetMapping("/consultaFacturaPeliculaPorId/{fcpeId}")
	public ResponseEntity<?> consultarFacturaPeliculaPorId(@PathVariable ("fcpeId") Integer fcpeId) throws Exception{
		return null;
	}
	
	@PostMapping("/guardarFacturaPelicula")
	public ResponseEntity<?> guardarFacturaPelicula(@RequestBody FacturaPeliculaDTO facturaPeliculaDTO) throws Exception{
		return null;
	}
	
	@PutMapping("/actualizarFacturaPelicula")
	public ResponseEntity<?> actualizarFacturaPelicula(@RequestBody FacturaPeliculaDTO facturaPeliculaDTO) throws Exception{
		return null;
	}
	
	@DeleteMapping("/eliminarFacturaPelicula/{factId}")
	public ResponseEntity<?> eliminarFacturaPelicula(@PathVariable ("fcpeId") Integer fcpeId) throws Exception{
		return null;
	}

}
