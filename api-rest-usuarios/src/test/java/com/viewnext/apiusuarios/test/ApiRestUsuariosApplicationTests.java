package com.viewnext.apiusuarios.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.entidades.TemaDeUsuario;
import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOTemas;
import com.viewnext.apiusuarios.model.AlmacenDAOTemasDeUsuarios;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@SpringBootTest
class ApiRestUsuariosApplicationTests {

	//Spring hace un daoTemas = new AlmacenDAOTemas();
	// Y lo asigna automáticamente a esta variable
	// Esto es lo que se llama IoD (Inyección de Dependencias)
	@Autowired
	private AlmacenDAOTemas daoTemas;
	@Autowired
	private AlmacenDAOUsuarios daoUsu;
	
	@Test
	void testTemaPreferido() throws InterruptedException {
		// Thread.sleep(1000);
		Tema tema = daoTemas.findById(1).orElse(null);
		// assertEquals(2, tema.getId());
		assertNotEquals(0, tema.getNombre().length());
		
		Usuario usu = daoUsu.findById(1).orElse(null);
		/* Busca el registro de usuario (SELECT * FROM Usuario...)
		 * e instancia un new Usuario() mapeando los 
		 * campos de la tabla en las  variables miembro(propiedades), 
		 * y también hace lo mismo, en esta llamada
		 * con la propiedad usu.temaPreferido con Tema, 
		 * por las anotaciones @ManyToOne y @JoinColumn,
		 * es decir, hace otro SELECT * FROM tema WHERE ..., 
		 * e instancia un new Tema() y mapea...
		 */
		assertNotNull(usu);
		
		usu.setIdTemaPreferido(tema.getId());
		
		/* usu = */ 
		usu = daoUsu.saveAndFlush(usu);
		daoUsu.flush();
		usu = daoUsu.findById(1).orElse(null);
		
		Integer idTemaPref = usu.getIdTemaPreferido();
		assertEquals(tema.getId(), idTemaPref);
		
		Tema temaPref = usu.getTemaPreferido();
		assertEquals(tema.getNombre(), temaPref.getNombre());
		
		List<Usuario> usuariosPref = tema.getUsuariosPref();
		for (Usuario usuario : usuariosPref) {
			System.out.println(" Usuario " + usuario.getNombre()
					+ " prefiere " + tema.getNombre());
		}
		assertNotEquals(0, usuariosPref.size());
	}
}






