package com.vortex.backend.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vortex.backend.app.domain.Usuario;
import com.vortex.backend.app.dto.UsuarioDTO;
import com.vortex.backend.app.mapper.UsuarioMapper;
import com.vortex.backend.app.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioRestController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	UsuarioMapper usuarioMapper;
    
	
	//CONSULTAR TODOS LOS USUARIOS
	@GetMapping("/consultarTodos")
	public ResponseEntity<?> consultarTodos() throws Exception {
		List<Usuario> usuarios = usuarioService.consultarTodos();
		List<UsuarioDTO> usuarioDTOs = usuarioMapper.toUsuariosDTO(usuarios);

		return ResponseEntity.ok().body(usuarioDTOs);
	}
    
	
	//CONSULTAR USUARIOS POR EMAIL
	@GetMapping("/consultarUsuarioPorId/{userId}")
	public ResponseEntity<?> consultarUsuarioPorId(@PathVariable("userId") Integer userId) throws Exception {
		Optional<Usuario> usuarioOptional = usuarioService.consultarPorId(userId);
		if (usuarioOptional.isPresent() == false) {
			return ResponseEntity.ok().body(null);
		}

		Usuario usuario = usuarioOptional.get();
		// Paso la informacion del Entity a el DTO
		UsuarioDTO usuarioDTO = usuarioMapper.toUsuarioDTO(usuario);

		return ResponseEntity.ok().body(usuarioDTO);
	}
    
	//GUARDAR USUARIO
	@PostMapping("/guardarUsuario")
	public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {

		Usuario usuario = usuarioMapper.toUsuario(usuarioDTO);
		usuario = usuarioService.guardar(usuario);
		usuarioDTO = usuarioMapper.toUsuarioDTO(usuario);

		return ResponseEntity.ok().body(usuarioDTO);
	}
    
	
	//ACTUALIZAR USUARIO
	@PutMapping("/actualizarUsuario")
	public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {

		Usuario usuario = usuarioMapper.toUsuario(usuarioDTO);
		usuario = usuarioService.actualizar(usuario);
		usuarioDTO = usuarioMapper.toUsuarioDTO(usuario);

		return ResponseEntity.ok().body(usuarioDTO);
	}
    
	//ELIMINAR USUARIO
	@DeleteMapping("/eliminarUsuario/{userId}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable("userId") Integer userId) throws Exception {
		
		try {
			usuarioService.eliminarPorId(userId);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	//CONSULTAR USUARIOS POR EMAIL
		@GetMapping("/consultarUsuarioPorEmail/{email}")
		public ResponseEntity<?> consultarUsuarioPorEmail(@PathVariable("email") String email) throws Exception {
			Optional<Usuario> usuarioOptional = usuarioService.consultarPorEmail(email);
			if (usuarioOptional.isPresent() == false) {
				return ResponseEntity.ok().body(null);
			}

			Usuario usuario = usuarioOptional.get();
			// Paso la informacion del Entity a el DTO
			UsuarioDTO usuarioDTO = usuarioMapper.toUsuarioDTO(usuario);

			return ResponseEntity.ok().body(usuarioDTO);
		}

}
