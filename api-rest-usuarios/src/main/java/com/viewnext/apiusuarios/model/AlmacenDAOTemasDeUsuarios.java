package com.viewnext.apiusuarios.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.entidades.TemaDeUsuario;
import com.viewnext.apiusuarios.entidades.TemaDeUsuarioPK;


public interface AlmacenDAOTemasDeUsuarios 
	extends JpaRepository<TemaDeUsuario, TemaDeUsuarioPK> {
	
	@Query(value = "SELECT tu.* FROM tema_de_usuario AS tu\r\n" + 
			" INNER JOIN usuario AS u ON u.id = tu.id_usuario\r\n" + 
			" WHERE tu.id_usuario = ?1", 
			nativeQuery = true)
	public List<TemaDeUsuario> findTemasDeUnUsuario(Integer idUsuario);

	public List<TemaDeUsuario> findTemasPorUsuarioHQL(Integer idUsuario);
	
// Sólo versión 11 de Java
	/*
	public void delete(Integer idU, Integer idT) {
		deleteById(new TemaDeUsuarioPK(idU, idT));
	}; */
}
