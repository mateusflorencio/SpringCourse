package com.florencio.springcourse.controladores.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.florencio.springcourse.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ManipuladorDeExcecoesDoControlador {
	
	@ExceptionHandler (ObjectNotFoundException.class)//erro desse tipo de objeto
	public ResponseEntity<ErrosPadrao> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		ErrosPadrao err=new ErrosPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
