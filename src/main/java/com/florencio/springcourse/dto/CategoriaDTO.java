package com.florencio.springcourse.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.florencio.springcourse.domain.Categoria;

@Entity
public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty (message = "PREENCHIMENTO OBRIGATÓRIO")
	@Size (min = 5, max = 80, message = "o tamanho deve ter entre 5 e 80 caracteres")
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
public CategoriaDTO(Categoria categoria) {
		this.id=categoria.getId();
		this.nome=categoria.getNome();
	}

	public CategoriaDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
