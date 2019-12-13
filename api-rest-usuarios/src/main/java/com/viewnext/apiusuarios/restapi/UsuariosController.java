package com.viewnext.apiusuarios.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@RestController()
@RequestMapping("/api")
public class UsuariosController {

	// Inyección de depencias: Spring se encarga de
	// Instanciar el DAO (obj, no interfaz, y asignarlo
	// a nuestro RestController al contruirlo
	@Autowired 
	private AlmacenDAOUsuarios dao;
	
	@RequestMapping(path = "/usuarios", method = {RequestMethod.GET /*, RequestMethod.POST */} )
	public Usuario getUsuario() {
		return new Usuario(-1, "Ok", "email", "111");
	}
	@PostMapping("/usuarios")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {	
		// Recibe sin ID en el BODY de la petición HTTP y deserializa el JSON a un obj Usuario
		return dao.save(usuario);	// Devuelve con ID
	}
}






