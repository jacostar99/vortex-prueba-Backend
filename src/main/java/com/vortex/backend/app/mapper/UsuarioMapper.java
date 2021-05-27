package com.vortex.backend.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.vortex.backend.app.domain.Usuario;
import com.vortex.backend.app.dto.UsuarioDTO;

@Mapper
public interface UsuarioMapper {

	public UsuarioDTO toUsuarioDTO(Usuario usuario);

	public Usuario toUsuario(UsuarioDTO usuarioDTO);

	public List<UsuarioDTO> toUsuariosDTO(List<Usuario> usuarios);

	public List<Usuario> toUsuarios(List<UsuarioDTO> usuariosDTO);

}
