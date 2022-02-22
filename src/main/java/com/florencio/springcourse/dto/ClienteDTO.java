package com.florencio.springcourse.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.florencio.springcourse.domain.Cliente;
import com.florencio.springcourse.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty
	@Size(min = 5, max = 120, message = "Deve haver a inserção de 5 a 120 caracteres")
	private String nome;
	@NotEmpty
	@Email (message = "inserir um email adequado")
	private String email;

	public ClienteDTO() {

	}

	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
