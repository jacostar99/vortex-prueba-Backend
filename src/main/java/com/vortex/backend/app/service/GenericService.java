package com.vortex.backend.app.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {

	// Devuelve una lista del tipo de dato que se especifique
	public List<T> consultarTodos() throws Exception;

	// Guardar una entidad
	public T guardar(T entity) throws Exception;

	// Actualizar una entidad
	public T actualizar(T entity) throws Exception;

	// Eliminar una entidad
	public void eliminar(T entity) throws Exception;

	// Eliminar entidad por su llave principal
	public void eliminarPorId(ID id) throws Exception;

	// Consultar entidad por su llave principal
	public Optional<T> consultarPorId(ID id) throws Exception;

	public Long count();

	public void validar(T entity) throws Exception;

}
