package com.viewnext.apiusuarios.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.viewnext.apiusuarios.entidades.Tema;

public interface AlmacenDAOTemas 
	extends JpaRepository<Tema, Integer> {

	@Query(value = "SELECT tema.* FROM tema_de_usuario  \r\n" + 
			"  INNER JOIN tema ON tema.id = tema_de_usuario.id_tema  \r\n" + 
			"  WHERE tema_de_usuario.id_usuario = ?1", 
			nativeQuery = true)
	public List<Tema> findTemasPorUsuario(Integer idUsuario);
	

}
