package com.vortex.backend.app.service;

import java.util.Optional;

import com.vortex.backend.app.domain.Usuario;

public interface UsuarioService extends GenericService <Usuario , Integer> {
	
	public Optional<Usuario> consultarPorEmail(String email) throws Exception;

}
