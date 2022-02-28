package com.florencio.springcourse.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.florencio.springcourse.domain.Cliente;

public class EmailDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	
	@NotEmpty
	@Email (message = "inserir um email adequado")
	public EmailDTO() {
		
	}
	
	public EmailDTO(Cliente cliente) {
		this.email= cliente.getEmail();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
