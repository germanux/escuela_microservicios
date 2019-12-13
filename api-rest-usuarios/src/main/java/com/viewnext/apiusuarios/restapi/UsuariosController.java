package com.viewnext.apiusuarios.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@RestController()
@RequestMapping("/api/usuarios")
public class UsuariosController {

	// Inyección de depencias: Spring se encarga de
	// Instanciar el DAO (obj, no interfaz, y asignarlo
	// a nuestro RestController al contruirlo
	@Autowired
	private AlmacenDAOUsuarios dao;
	
	
	@PostMapping()
	public Usuario crearUsuario(@RequestBody Usuario usuario) {	
		// Recibe sin ID en el BODY de la petición HTTP y deserializa el JSON a un obj Usuario
		return dao.save(usuario);	// Devuelve con ID
	}
	
	@GetMapping
	public List<Usuario> leerTodos() {
		return dao.findAll();
	}
	
	@RequestMapping(value="/{id}", method = {RequestMethod.GET /*, RequestMethod.POST */} )
	public Usuario getUsuario(@PathVariable Integer id) {
		System.out.println(">>>> ID RECIBIDO " + id);
		//TODO Optional
		Optional<Usuario> usu = dao.findById(id);
		return usu.orElse(null);
	}
}






