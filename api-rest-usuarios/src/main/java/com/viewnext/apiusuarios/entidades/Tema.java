package com.viewnext.apiusuarios.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tema implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8637532331745277608L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull	// Not null de JPA
	@Size(min = 1, max = 50)
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(
			fetch = FetchType.EAGER) // Forma de recuperar:
									// LAZY: perezosa (a petición)
									// EAGER: rápida, al hacer la consulta
	// @JoinTable(name = "usuario", joinColumns = {@JoinColumn(name= "id_tema_preferido")} )
	@JoinColumn(name = "id_tema_preferido")
	// @JsonIgnore 
	@JsonBackReference
	private List<Usuario> usuariosPref;

	private String descripcion;
	
	// Información específica de la columna en bb.dd.
	@Column(name="timestamp", nullable = false, 
			updatable = false, 
			insertable = false, 
			columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

		
	public Tema() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tema(Integer id, @NotNull @Size(min = 1, max = 50) String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public List<Usuario> getUsuariosPref() {
		return usuariosPref;
	}
	public void setUsuariosPref(List<Usuario> usuariosPref) {
		this.usuariosPref = usuariosPref;
	}
}
