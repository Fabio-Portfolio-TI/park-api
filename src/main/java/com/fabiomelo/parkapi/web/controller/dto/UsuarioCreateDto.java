package com.fabiomelo.parkapi.web.controller.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioCreateDto {

    private String username;
    private String password;
}
