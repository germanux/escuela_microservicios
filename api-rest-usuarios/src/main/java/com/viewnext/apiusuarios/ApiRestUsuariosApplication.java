package com.viewnext.apiusuarios;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.entidades.Usuario;

@SpringBootApplication
public class ApiRestUsuariosApplication {

	public static void main(String[] args) throws SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SpringApplication.run(ApiRestUsuariosApplication.class, args);
		System.out.println("SPRING ARRANCADO");
		
		
		
		/*Usuario u = new Usuario();
		u.setEmail("eee@eee.com");
		System.out.println(u.getEmail());
		
		Constructor<?>[]   publicConstructors = 
				Class.forName("com.viewnext.apiusuarios.entidades.Usuario")
				.getConstructors();
		Method[]   metodos = 
				Class.forName("com.viewnext.apiusuarios.entidades.Usuario")
				.getMethods();

		System.out.println("Constructores: " + publicConstructors.length );
		Usuario usuDin = (Usuario) publicConstructors[0].newInstance((Object[])null);
		usuDin.setEmail("yyy@yyy.com");
		System.out.println(usuDin.getEmail());
		*/
		metodoTal(new Usuario());
	}
	static Usuario metodoTal(Usuario u) {
		// Algun proceso, movidas
		System.out.println(u.toString());
		return u;
	}
	static Tema metodoTal(Tema t) {
		// Algun proceso, movidas
		System.out.println(t.toString());
		return t;
	}

	/*static Object metodoTal(Object o) {
		// Algun proceso, movidas
		System.out.println(o.toString());
		return o;
	}*/
	static <T> T metodoTal(T o) {
		// Algun proceso, movidas
		System.out.println(o.toString());
		return o;
	}
}
