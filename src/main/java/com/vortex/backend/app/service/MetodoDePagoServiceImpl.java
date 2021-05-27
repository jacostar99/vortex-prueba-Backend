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

import com.vortex.backend.app.domain.MetodoDePago;
import com.vortex.backend.app.repository.MetodoDePagoRepository;


@Service
public class MetodoDePagoServiceImpl implements MetodoDePagoService {
	
	@Autowired
	MetodoDePagoRepository metodoDePagoRepository;

	@Autowired
	Validator validator;

	@Override
	@Transactional(readOnly = true)
	public List<MetodoDePago> consultarTodos() throws Exception {
		return metodoDePagoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public MetodoDePago guardar(MetodoDePago entity) throws Exception {
	    validar(entity);

		return metodoDePagoRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public MetodoDePago actualizar(MetodoDePago entity) throws Exception {
		validar(entity);

		if (metodoDePagoRepository.existsById(entity.getPagoId()) == false) {
			throw new Exception("El metodo de pago con pagoId: " + entity.getPagoId() + " no existe");
		}

		return metodoDePagoRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void eliminar(MetodoDePago entity) throws Exception {
		if (entity == null) {
			throw new Exception("El PaymentMethod es nulo");
		}
		if (entity.getPagoId() == null || entity.getPagoId() < 0) {
			throw new Exception("El payId es obligatorio");
		}
		if (metodoDePagoRepository.existsById(entity.getPagoId()) == false) {
			throw new Exception("El paymentMethod con payId: " + entity.getPagoId() + " no existe");
		}
		
		metodoDePagoRepository.deleteById(entity.getPagoId());
		
	}

	@Override
	@Transactional(readOnly = false)
	public void eliminarPorId(Integer id) throws Exception {
		if (id == null || id < 0) {
			throw new Exception("El pago id es obligatorio");
		}
		if (metodoDePagoRepository.existsById(id)) {
			eliminar(metodoDePagoRepository.findById(id).get());
		} else {
			throw new Exception("El metodo de pago con id: " + id + " no existe");
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<MetodoDePago> consultarPorId(Integer id) throws Exception {
		return metodoDePagoRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return metodoDePagoRepository.count();
	}

	@Override
	public void validar(MetodoDePago entity) throws Exception {
		if (entity == null) {
			throw new Exception("El PaymenthMethod es nulo");
		}
		Set<ConstraintViolation<MetodoDePago>> constraintViolation = validator.validate(entity);
		if (constraintViolation.isEmpty() == false) {
			throw new ConstraintViolationException(constraintViolation);
		}
	}

}
