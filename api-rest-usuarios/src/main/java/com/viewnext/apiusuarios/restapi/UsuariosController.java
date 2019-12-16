package com.viewnext.apiusuarios.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		System.out.println(">>>> GET - ID RECIBIDO " + id);
		//TODO Optional
		Optional<Usuario> usu = dao.findById(id);
		return usu.orElse(null);
	}

	@PutMapping()
	public Usuario modificarUsuario(@RequestBody Usuario usuario) {	
		// Recibe sin ID en el BODY de la petición HTTP y deserializa el JSON a un obj Usuario
		return dao.save(usuario);	// Devuelve con ID
	}
	@RequestMapping(value="/{id}", method = RequestMethod.PUT )
	public Usuario modificarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
		System.out.println(">>>> MODIFICAR ID RECIBIDO " + id);

		usuario.setId(id);
		return dao.save(usuario);
	}
	@DeleteMapping(value="/{id}") 
	public void eliminarUsuario(@PathVariable Integer id) {
		System.out.println(">>>> ELIMINAR ID RECIBIDO " + id);

		dao.deleteById(id);
	}

	@DeleteMapping() 
	public void eliminarUsuario(@RequestBody Usuario usuario) {
		System.out.println(">>>> DELETE ");
		dao.delete(usuario);
		// Es equivalente a :
		// dao.deleteById(usuario.getId());
	}
	/** Captura un formulario
	 * 
	 * @param id
	 * @param name
	 */
	@PostMapping(value="/formulario") // Subruta /formulario porque la raiz con POST ya está cogida
	public Usuario crearUsuarioPorParam(
			//@RequestParam Integer id, 
			@RequestParam (name="nombre") String elNombreDelUsu, 
			@RequestParam String email,
			@RequestParam String password) 
	{
		Usuario usu = new Usuario(null, elNombreDelUsu, email, password);
		System.out.println(">>>> crearUsuarioPorParam ");
		
		return dao.save(usu);
	}

}






