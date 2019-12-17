package com.viewnext.apiusuarios.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.viewnext.apiusuarios.entidades.TemaDeUsuario;
import com.viewnext.apiusuarios.entidades.TemaDeUsuarioPK;

public interface AlmacenDAOTemasDeUsuarios 
	extends JpaRepository<TemaDeUsuario, TemaDeUsuarioPK> {
	/*
	@Query(value = "SELECT ")
	public List<TemaDeUsuario> findTemasDeUnUsuario(Integer idUsuario);
*/
}
