package com.fabiomelo.parkapi.web.controller.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioResponseDto {

    private Long id;

    private String usename;

    private String role;
}
