package com.fabiomelo.parkapi.web.controller;

import com.fabiomelo.parkapi.entity.Usuario;
import com.fabiomelo.parkapi.service.UsuarioService;
import com.fabiomelo.parkapi.web.controller.dto.UsuarioCreateDto;
import com.fabiomelo.parkapi.web.controller.dto.UsuarioResponseDto;
import com.fabiomelo.parkapi.web.controller.dto.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    //public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
    public ResponseEntity<UsuarioResponseDto> create(@RequestBody UsuarioCreateDto createDto){
         Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updatePassword(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario user = usuarioService.editarSenha(id, usuario.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(users);
    }


}
