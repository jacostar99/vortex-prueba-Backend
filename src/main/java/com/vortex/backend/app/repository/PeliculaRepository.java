package com.vortex.backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vortex.backend.app.domain.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula , Integer> {

}
