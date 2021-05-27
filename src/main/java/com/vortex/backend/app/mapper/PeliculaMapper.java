package com.vortex.backend.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.vortex.backend.app.domain.Pelicula;
import com.vortex.backend.app.dto.PeliculaDTO;

@Mapper
public interface PeliculaMapper {
	
	public PeliculaDTO toPeliculaDTO(Pelicula pelicula);

	public Pelicula toPelicula(PeliculaDTO peliculaDTO);

	public List<PeliculaDTO> toPeliculasDTO(List<Pelicula> pelicula);

	public List<Pelicula> toPeliculas(List<PeliculaDTO> peliculasDTO);

}
