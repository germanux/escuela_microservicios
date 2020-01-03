package com.viewnext.apiusuarios.restapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.viewnext.apiusuarios.entidades.Usuario;

/** Cliente REST de API Json y XML, a su vez que es una API REST General
 * 
 * @author alumno
 *
 */
@RestController
@RequestMapping("/api/main/usuarios")
@CrossOrigin()
public class UsuariosMainController {

	final static String url = "172.16.2.17";
	final static String uriApiJson = "http://" + url + ":8081/api/usuarios";
	final static String uriApiXML = "http://" + url + ":8082/api/xml/usuarios";
	
	public static class ListaUsuario extends ArrayList<Usuario> {
		
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE
	})
	public List<Usuario> leerTodosTodos() {
		List<Usuario> listaTotal;
		RestTemplate restTemplate = new RestTemplate();
		
		// invocamos al método GET http sobre api json 0.0.1
		// y se encarga de des-serializar el JSON en un ArrayList<Usuario>
		listaTotal = restTemplate.getForObject(uriApiJson, ListaUsuario.class);
		
		//TODO: Pedir todos del API XML y añadirlo a la listaTotal

		List<Usuario> listaDelXML;
		listaDelXML = restTemplate.getForObject(uriApiXML, ListaUsuario.class);
		listaTotal.addAll(listaDelXML);
		
		return listaTotal;
	}
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE
	})
	public Usuario crearUsuario( 
			@RequestBody Usuario usuario,
			@RequestParam String api)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		if ("json".equals(api.toLowerCase())) {
			
			usuario = restTemplate.postForObject(
					uriApiJson, 
					usuario, 
					Usuario.class);
		} else {	// Debería ser XML

			usuario = restTemplate.postForObject(
					uriApiXML, 
					usuario, 
					Usuario.class);
		}
		return usuario;
	}
	
	@PostMapping(value="/form") 
	public Usuario crearUsuarioPorParam(
			@RequestParam String nombre, 
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String api) 
	{
		Usuario usuario = new Usuario(null, nombre, email, password);
		HttpEntity<Usuario> peticionHttp = new HttpEntity<Usuario>(usuario);

		RestTemplate restTemplate = new RestTemplate();
		
		if ("json".equals(api.toLowerCase())) {
			//HttpHeaders headers = new HttpHeaders();
			// headers.setContentType(MediaType.APPLICATION_JSON);
			//peticionHttp.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			int i = 10;
			usuario = restTemplate.postForObject(
					uriApiJson, 
					usuario, 
					Usuario.class);
		} else {	// Debería ser XML*/

			// peticionHttp.getHeaders().setContentType(MediaType.APPLICATION_XML);
			usuario = restTemplate.postForObject(
					uriApiXML, 
					usuario, 
					Usuario.class);
		}
		return usuario;
	}
}
