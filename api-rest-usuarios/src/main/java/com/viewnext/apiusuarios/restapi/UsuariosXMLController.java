package com.viewnext.apiusuarios.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.entidades.TemaDeUsuario;
import com.viewnext.apiusuarios.entidades.TemaDeUsuarioPK;
import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOTemas;
import com.viewnext.apiusuarios.model.AlmacenDAOTemasDeUsuarios;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@RestController()
@RequestMapping("/api/xml/usuarios")
public class UsuariosXMLController {

	// Inyección de depencias: Spring se encarga de
	// Instanciar el DAO (obj, no interfaz, y asignarlo
	// a nuestro RestController al contruirlo
	@Autowired
	private AlmacenDAOUsuarios dao;

	@Autowired
	private AlmacenDAOTemasDeUsuarios daoTemasUsu;
	
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, 
			produces = MediaType.APPLICATION_XML_VALUE)
	public Usuario crearUsuario(@RequestBody Usuario usuario) {	
		// Recibe sin ID en el BODY de la petición HTTP y deserializa el JSON a un obj Usuario
		return dao.save(usuario);	// Devuelve con ID
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public List<Usuario> leerTodos() {
		return dao.findAll();
	}
	
	@RequestMapping(value="/{id}", 
			method = {RequestMethod.GET /*, RequestMethod.POST */},
			produces = MediaType.APPLICATION_XML_VALUE
	)
	public Usuario getUsuario(@PathVariable Integer id) {
		System.out.println(">>>> GET - ID RECIBIDO " + id);
		//TODO Optional
		Optional<Usuario> usu = dao.findById(id);
		return usu.orElse(null);
	}

	@PutMapping(consumes = MediaType.APPLICATION_XML_VALUE, 
			produces = MediaType.APPLICATION_XML_VALUE)
	public Usuario modificarUsuario(@RequestBody Usuario usuario) {	
		// Recibe sin ID en el BODY de la petición HTTP y deserializa el JSON a un obj Usuario
		return dao.save(usuario);	// Devuelve con ID
	}
	@RequestMapping(value="/{id}", method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_XML_VALUE, 
			produces = MediaType.APPLICATION_XML_VALUE)
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

	@DeleteMapping(consumes = MediaType.APPLICATION_XML_VALUE) 
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
	@PostMapping(value="/formulario",
			produces = MediaType.APPLICATION_XML_VALUE) // Subruta /formulario porque la raiz con POST ya está cogida
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

	@GetMapping(value="/{idUsuario}/temas_usu", 
			produces = MediaType.APPLICATION_XML_VALUE)
	public List<TemaDeUsuario> getTemasDeUsuario(@PathVariable Integer idUsuario) 
	{
		System.out.println(">>>> getTemasDeUsuario - ID RECIBIDO " + idUsuario);
		
		List<TemaDeUsuario> temasUsu = //  daoTemasUsu.findTemasDeUnUsuario(idUsuario);
			daoTemasUsu.findTemasPorUsuarioHQL(idUsuario);
		return temasUsu;
	}

	
	@PostMapping(value = "/{id}/temas/{idt}",
			produces = MediaType.APPLICATION_XML_VALUE)
	public TemaDeUsuario addTemaDeUsuario(@PathVariable Integer id,
			@PathVariable(name = "idt") Integer idTema) {
		
		TemaDeUsuario nuevoTema = new TemaDeUsuario(id, idTema);
				
		return daoTemasUsu.save(nuevoTema);
	}
	
	@DeleteMapping(value = "/{id}/temas/{idt}")
	public String deleteTemaDeUsuario(@PathVariable Integer id,
			@PathVariable(name = "idt") Integer idTema) {
		
		daoTemasUsu.deleteById(new TemaDeUsuarioPK(id, idTema));
		//daoTemasUsu.delete(id, idTema);
		return "Tema de usuario borrado";
	}
}






