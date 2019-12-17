package com.viewnext.apiusuarios.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class TemaDeUsuarioPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5605757244443886858L;

	@Column(name="id_usuario")
	@NotNull
	private Integer usuario;

	@Column(name="id_tema", nullable = false)
	private Integer tema;

	public TemaDeUsuarioPK() {
		super();
	}

	public TemaDeUsuarioPK(@NotNull Integer usuario, Integer tema) {
		super();
		this.usuario = usuario;
		this.tema = tema;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getTema() {
		return tema;
	}

	public void setTema(Integer tema) {
		this.tema = tema;
	}
	
	
}
