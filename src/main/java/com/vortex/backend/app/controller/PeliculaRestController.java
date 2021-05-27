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

import com.vortex.backend.app.domain.Pelicula;
import com.vortex.backend.app.dto.PeliculaDTO;
import com.vortex.backend.app.mapper.PeliculaMapper;
import com.vortex.backend.app.service.PeliculaService;

@RestController
@RequestMapping("/api/pelicula")
@CrossOrigin("*")
public class PeliculaRestController {

	@Autowired
	PeliculaService peliculaService;

	@Autowired
	PeliculaMapper peliculaMapper;
	
	
   //CONSULTAR TODAS PELICULAS
	@GetMapping("/consultarTodasPeliculas")
	public ResponseEntity<?> consultarTodos() throws Exception {
		// Lista de Peliculas
		List<Pelicula> peliculas = peliculaService.consultarTodos();
		// Lista de PelicuasDTO
		List<PeliculaDTO> peliculasDTO = peliculaMapper.toPeliculasDTO(peliculas);
		return ResponseEntity.ok().body(peliculasDTO);
	}
    
	
	//CONSULTAR PELICULA POR ID
	@GetMapping("/consultarPeliculaPorId/{peliId}")
	public ResponseEntity<?> consultarPeliculaPorId(@PathVariable("peliId") Integer peliId) throws Exception {
		Optional<Pelicula> peliculaOptional = peliculaService.consultarPorId(peliId);
		if (peliculaOptional.isPresent() == false) {
			return ResponseEntity.ok().body(null);
		}
		Pelicula pelicula = peliculaOptional.get();
		PeliculaDTO peliculaDTO = peliculaMapper.toPeliculaDTO(pelicula);
		return ResponseEntity.ok().body(peliculaDTO);
	}
    
	
	//GUARDAR PELICULA
	@PostMapping("/guardarPelicula")
	public ResponseEntity<?> guardarPelicula(@RequestBody PeliculaDTO peliculaDTO) throws Exception {
		Pelicula pelicula = peliculaMapper.toPelicula(peliculaDTO);
		pelicula = peliculaService.guardar(pelicula);
		peliculaDTO = peliculaMapper.toPeliculaDTO(pelicula);

		return ResponseEntity.ok().body(peliculaDTO);
	}
    
	//ACTUALIZAR PELICULA
	@PutMapping("/actualizarPelicula")
	public ResponseEntity<?> actualizarPelicula(@RequestBody PeliculaDTO peliculaDTO) throws Exception {
		Pelicula pelicula = peliculaMapper.toPelicula(peliculaDTO);
		pelicula = peliculaService.actualizar(pelicula);
		peliculaDTO = peliculaMapper.toPeliculaDTO(pelicula);
		
		return ResponseEntity.ok().body(peliculaDTO);

	}
    
	//ELIMINAR PELICULA
	@DeleteMapping("/eliminarPelicula/{peliId}")
	public ResponseEntity<?> eliminarPelicula(@PathVariable("peliId") Integer peliId) throws Exception {
		peliculaService.eliminarPorId(peliId);
		
		return ResponseEntity.ok().build();
	}

}
