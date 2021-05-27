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

import com.vortex.backend.app.domain.FacturaPelicula;
import com.vortex.backend.app.repository.FacturaPeliculaRepository;

@Service
public class FacturaPeliculaServiceImpl implements FacturaPeliculaService {
	
	@Autowired
	private FacturaPeliculaRepository facturaPeliculaRepository;
	
	
	@Autowired
	private Validator validator;

	@Override
	@Transactional(readOnly = true)
	public List<FacturaPelicula> consultarTodos() throws Exception {
		return facturaPeliculaRepository.findAll();
		
	}

	@Override
	@Transactional(readOnly = false)
	public FacturaPelicula guardar(FacturaPelicula entity) throws Exception {
		if (entity == null) {
			throw new Exception("Es nulo");
		}

		validar(entity);

		if (facturaPeliculaRepository.existsById(entity.getFcpeId())) {
			throw new Exception("La factura pelicula con id:" + entity.getFcpeId() + " Ya existe");
		}

		return facturaPeliculaRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public FacturaPelicula actualizar(FacturaPelicula entity) throws Exception {


		if (entity == null) {
			throw new Exception("El objeto es nulo");
		}

		validar(entity);

		if (facturaPeliculaRepository.existsById(entity.getFcpeId()) == false) {
			throw new Exception("El  con id:" + entity.getFcpeId() + " No existe");
		}

		return facturaPeliculaRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void eliminar(FacturaPelicula entity) throws Exception {
		if (entity == null) {
			throw new Exception("Es nulo");
		}

		if (entity.getFcpeId() == null) {
			throw new Exception("El id es nulo");
		}

		if (facturaPeliculaRepository.existsById(entity.getFcpeId()) == false) {
			throw new Exception("La factura pelicula con id:" + entity.getFcpeId() + " No existe");
		}

		facturaPeliculaRepository.deleteById(entity.getFcpeId());

	}

	@Override
	@Transactional(readOnly = false)
	public void eliminarPorId(Integer id) throws Exception {
		
		if (id == null) {
			throw new Exception("El id es nulo");
		}

		if (facturaPeliculaRepository.existsById(id)) {
			eliminar(facturaPeliculaRepository.findById(id).get());
		}

	}

	@Override
	@Transactional(readOnly = false)
	public Optional<FacturaPelicula> consultarPorId(Integer id) throws Exception {
		return facturaPeliculaRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return facturaPeliculaRepository.count();
	}

	@Override
	public void validar(FacturaPelicula entity) throws ConstraintViolationException {
		Set<ConstraintViolation<FacturaPelicula>> constraintViolations = validator.validate(entity);

		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = false)
	public Long totalFacturaPeliculatByFactura(Integer factId) {
		return facturaPeliculaRepository.totalFacturaPeliculatByFactura(factId);
	}

	@Override
	public Integer totalItems(Integer factId) {
		return facturaPeliculaRepository.totalItems(factId);
	}

	@Override
	public FacturaPelicula getFcPeByFactPeli(Integer factId, Integer peliId) {
		return facturaPeliculaRepository.getFcPeByFactPeli(factId, peliId);
	}

	@Override
	public List<Integer> getFapeIdByFactId(Integer factId) {
		return getFapeIdByFactId(factId);
	}

	@Override
	public List<FacturaPelicula> findFapeByFactId(Integer factId) {
		return facturaPeliculaRepository.findFapeByFactId(factId);
	}

}
