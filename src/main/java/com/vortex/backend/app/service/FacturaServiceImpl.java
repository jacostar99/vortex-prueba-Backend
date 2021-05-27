package com.vortex.backend.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vortex.backend.app.domain.Factura;
import com.vortex.backend.app.domain.Pelicula;
import com.vortex.backend.app.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	FacturaRepository facturaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Factura> consultarTodos() throws Exception {
		return facturaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Factura guardar(Factura entity) throws Exception {
		validar(entity);

		return facturaRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public Factura actualizar(Factura entity) throws Exception {
		validar(entity);
		if (entity.getFactId() == null || entity.getFactId() < 0) {
			throw new Exception("El fact es obligatorio");
		}
		if (facturaRepository.existsById(entity.getFactId()) == false) {
			throw new Exception("La factura con id: " + entity.getFactId() + " no existe");
		}
		return facturaRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void eliminar(Factura entity) throws Exception {
		if (entity == null) {
			throw new Exception("La factura es nula");
		}
		if (entity.getFactId() == null || entity.getFactId() < 0) {
			throw new Exception("El factid es obligatorio");
		}
		if (facturaRepository.existsById(entity.getFactId()) == false) {
			throw new Exception("La factura con id: " + entity.getFactId() + " no existe");
		}
		facturaRepository.deleteById(entity.getFactId());

	}

	@Override
	@Transactional(readOnly = false)
	public void eliminarPorId(Integer id) throws Exception {
		if (id == null || id < 0) {
			throw new Exception("El id es obligatorio");
		}
		if (facturaRepository.existsById(id)) {
			eliminar(facturaRepository.findById(id).get());
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Factura> consultarPorId(Integer id) throws Exception {
		return facturaRepository.findById(id);
	}

	@Override
	public Long count() {
		return facturaRepository.count();
	}

	@Override
	public void validar(Factura entity) throws Exception {
		if (entity == null) {
			throw new Exception("La factura es nula");
		}
		if (entity.getUsuario() == null) {
			throw new Exception("El usuario es obligatorio");
		}

		if (entity.getCantTotalpelis() == null || entity.getCantTotalpelis() < 0) {
			throw new Exception("La cantidad de peliculas es obligatorio");
		}

		if (entity.getFechaCompra() == null) {
			throw new Exception("La fecha de compra es obligatoria");

		}

		if (entity.getTotal() < 0) {
			throw new Exception("El total es obligatorio");
		}

	}

	@Override
	public List<Factura> findFactByEmail(String email) {
		return facturaRepository.findFactByEmail(email);
	}

	@Override
	public List<Pelicula> findPeliculaByFactId(Integer factId) {
		return facturaRepository.findPeliculaByFactId(factId);
	}

}
