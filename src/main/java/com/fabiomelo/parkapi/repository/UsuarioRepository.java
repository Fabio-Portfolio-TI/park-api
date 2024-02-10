package com.fabiomelo.parkapi.repository;

import com.fabiomelo.parkapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
