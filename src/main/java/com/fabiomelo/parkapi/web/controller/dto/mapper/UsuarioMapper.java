package com.fabiomelo.parkapi.web.controller.dto.mapper;

import com.fabiomelo.parkapi.entity.Usuario;
import com.fabiomelo.parkapi.web.controller.dto.UsuarioCreateDto;
import com.fabiomelo.parkapi.web.controller.dto.UsuarioResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateDto createDto){
        return new ModelMapper().map(createDto, Usuario.class);
    }
    //COnverção de Usuario para UsuarioDto
    public static UsuarioResponseDto toDto(Usuario usuario){
        String role = usuario.getRole().name().substring("ROLE_".length());
        PropertyMap<Usuario, UsuarioResponseDto> props = new PropertyMap<Usuario, UsuarioResponseDto>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(usuario, UsuarioResponseDto.class);
    }
}
