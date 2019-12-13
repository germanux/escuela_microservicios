package com.viewnext.apiusuarios.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viewnext.apiusuarios.entidades.Usuario;

public interface AlmacenDAOUsuarios extends JpaRepository<Usuario, Integer> {

}
