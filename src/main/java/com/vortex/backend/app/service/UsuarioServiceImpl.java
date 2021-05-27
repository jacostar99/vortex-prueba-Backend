package com.vortex.backend.app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vortex.backend.app.domain.Usuario;
import com.vortex.backend.app.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	Validator validator;
    
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> consultarTodos() throws Exception {
		return usuarioRepository.findAll();
	}
	

	@Override
	@Transactional(readOnly = false)
	public Usuario guardar(Usuario entity) throws Exception {
		validar(entity);

		return usuarioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public Usuario actualizar(Usuario entity) throws Exception {
		validar(entity);
		
		if (usuarioRepository.existsById(entity.getUserId()) == false) {
			throw new Exception("El usuario con id: " + entity.getUserId() + " no existe");
		}

		return usuarioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void eliminar(Usuario entity) throws Exception {
		if (entity == null) {
			throw new Exception("El usuario es nulo");
		}

		/*if (entity.getEmail() == null || entity.getEmail().isBlank() == true) {
			throw new Exception("El email es obligatorio para eliminar al usuario");
		}

		if (usuarioRepository.existsById(entity.getEmail()) == false) {
			throw new Exception("NO existe un usuario con el email " + entity.getEmail());
		}*/


		usuarioRepository.deleteById(entity.getUserId());
		
	}

	@Override
	@Transactional(readOnly = false)
	public void eliminarPorId(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("El id es obligatorio para eliminar al usuario");
		}

		if (usuarioRepository.existsById(id)) {
			eliminar(usuarioRepository.findById(id).get());
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> consultarPorId(Integer id) throws Exception {
		return usuarioRepository.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> consultarPorEmail(String email) throws Exception {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return usuarioRepository.count();
	}

	@Override
	public void validar(Usuario entity) throws Exception {

		if (entity == null) {
			throw new Exception("El usuario no puede ser nulo");
		}
		
		//Valido, si hay errores me devuele una lista de constraint violation de usuario
		Set<ConstraintViolation<Usuario>> uV = validator.validate(entity);
		
		//Por lo menos hay 1 error , si no esta en blanco
		if(uV.isEmpty() == false) {
			throw new ConstraintViolationException(uV);
			
		}
		
	}

}
