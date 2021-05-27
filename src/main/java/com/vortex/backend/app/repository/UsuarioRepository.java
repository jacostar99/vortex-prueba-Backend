package com.vortex.backend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vortex.backend.app.domain.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario , Integer> {
	
	public Optional<Usuario> findByEmail(String email);

}
