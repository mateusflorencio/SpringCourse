package com.florencio.springcourse.dto;

import java.io.Serializable;

import com.florencio.springcourse.domain.Estado;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String estado;
	
	public EstadoDTO () {
		
	}

	public EstadoDTO(Estado estado) {
		super();
		this.id = estado.getId();
		this.estado = estado.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
