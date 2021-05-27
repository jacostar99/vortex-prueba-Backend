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

import com.vortex.backend.app.domain.Pelicula;
import com.vortex.backend.app.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService {

	@Autowired
	PeliculaRepository peliculaRepository;

	@Autowired
	Validator validator;

	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> consultarTodos() throws Exception {
		return peliculaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Pelicula guardar(Pelicula entity) throws Exception {
		validar(entity);
		

		
		return peliculaRepository.save(entity);
	}
	
	

	@Override
	@Transactional(readOnly = false)
	public Pelicula actualizar(Pelicula entity) throws Exception {
		validar(entity);

		if (peliculaRepository.existsById(entity.getPeliId()) == false) {
			throw new Exception("La pelicula con id: " + entity.getPeliId() + " no existe");
		}

		return peliculaRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void eliminar(Pelicula entity) throws Exception {
		if (entity == null) {
			throw new Exception("La pelicula es nulo");
		}
		if (entity.getPeliId() == null) {
			throw new Exception("El id de la pelicula es obligatorio");
		}

		// Si no existe lanza error
		if (peliculaRepository.existsById(entity.getPeliId()) == false) {
			throw new Exception("La pelicula con id: " + entity.getPeliId()+ " no existe");
		}

		peliculaRepository.deleteById(entity.getPeliId());

	}

	@Override
	@Transactional(readOnly = false)
	public void eliminarPorId(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("El id es obligatorio");
		}

		if (peliculaRepository.existsById(id)) {
			eliminar(peliculaRepository.findById(id).get());
		}else {
			throw new Exception("La pelicula con id: " + id + " no existe");
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pelicula> consultarPorId(Integer id) throws Exception {
		return peliculaRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return peliculaRepository.count();
	}

	@Override
	public void validar(Pelicula entity) throws Exception {
		if (entity == null) {
			throw new Exception("La pelicula es nula");
		}
	
		Set<ConstraintViolation<Pelicula>> constraintViolation = validator.validate(entity);
		if (constraintViolation.isEmpty() == false) {
			throw new ConstraintViolationException(constraintViolation);
		}

	}

}
