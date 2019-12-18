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

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOTemas;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@RestController()
@RequestMapping("/api/temas")
public class TemasController {

	// Inyección de depencias: Spring se encarga de
	// Instanciar el DAO (obj, no interfaz, y asignarlo
	// a nuestro RestController al contruirlo
	@Autowired
	private AlmacenDAOTemas dao;
	
	
	@PostMapping()
	public Tema crearUsuario(@RequestBody Tema tema) {	
		// Recibe sin ID en el BODY de la petición HTTP y deserializa el JSON a un obj Usuario
		return dao.save(tema);	// Devuelve con ID
	}

	@PostMapping(value = "/lista")
	public List<Tema> crearUsuario(@RequestBody List<Tema> temas) {	

		return dao.saveAll(temas);	// Devuelve con ID
	}
	@GetMapping
	public List<Tema> leerTodos(			
			@RequestParam(name = "usuario", required = false) 
				Integer idUsuario) {
		List<Tema> temas;
		if (idUsuario == null) {
			temas = dao.findAll();
		} else {
			temas = dao.findTemasPorUsuario(idUsuario);
		}
		return temas;
	}
	
	@RequestMapping(value="/{id}", method = {RequestMethod.GET /*, RequestMethod.POST */} )
	public Tema getTema(@PathVariable Integer id) {
		System.out.println(">>>> GET Tema - ID RECIBIDO " + id);

		Optional<Tema> tema = dao.findById(id);
		return  tema.orElse(null);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT )
	public Tema modificarTema(@PathVariable Integer id, @RequestBody Tema tema) {
		System.out.println(">>>> MODIFICAR ID RECIBIDO " + id);

		tema.setId(id);		
		return dao.save(tema);
	}
	@DeleteMapping(value="/{id}") 
	public void eliminarTema(@PathVariable Integer id) {
		System.out.println(">>>> ELIMINAR ID RECIBIDO " + id);

		dao.deleteById(id);
	}

	@DeleteMapping() 
	public void eliminarTema(@RequestBody Tema t) {
		System.out.println(">>>> DELETE ");
		dao.delete(t);
		// Es equivalente a :
		// dao.deleteById(t.getId());
	}
	/** Captura un formulario
	 * 
	 * @param id
	 * @param name
	 */
	@PostMapping(value="/formulario") // Subruta /formulario porque la raiz con POST ya está cogida
	public Tema crearTemaPorParam(
			//@RequestParam Integer id, 
			@RequestParam (name="nombre") String elNombreDelUsu, 
			@RequestParam String descripon) 
	{
		Tema t = new Tema(null, elNombreDelUsu, descripon);
		System.out.println(">>>> crearUsuarioPorParam ");
		
		return dao.save(t);
	}

}






