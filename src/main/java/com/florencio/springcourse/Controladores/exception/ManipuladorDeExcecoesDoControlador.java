package com.florencio.springcourse.controladores.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.florencio.springcourse.services.exceptions.AuthorizationException;
import com.florencio.springcourse.services.exceptions.DataIntegrityException;
import com.florencio.springcourse.services.exceptions.FileException;
import com.florencio.springcourse.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ManipuladorDeExcecoesDoControlador {

	@ExceptionHandler(ObjectNotFoundException.class) // erro desse tipo de objeto
	public ResponseEntity<ErrosPadrao> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		ErrosPadrao err = new ErrosPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(DataIntegrityException.class) // erro desse tipo de objeto
	public ResponseEntity<ErrosPadrao> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {

		ErrosPadrao err = new ErrosPadrao(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class) // erro desse tipo de objeto
	public ResponseEntity<ErrosPadrao> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

		ValidationPadrao err = new ValidationPadrao(HttpStatus.BAD_REQUEST.value(), "Erro de valição",
				System.currentTimeMillis());

		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(AuthorizationException.class) // erro desse tipo de objeto
	public ResponseEntity<ErrosPadrao> authorization(ObjectNotFoundException e, HttpServletRequest request) {
		ErrosPadrao err = new ErrosPadrao(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}

	@ExceptionHandler(FileException.class) // erro desse tipo de objeto
	public ResponseEntity<ErrosPadrao> file(FileException e, HttpServletRequest request) {
		ErrosPadrao err = new ErrosPadrao(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(AmazonServiceException.class) // erro desse tipo de objeto
	public ResponseEntity<ErrosPadrao> amazonService(AmazonServiceException e, HttpServletRequest request) {
		
		HttpStatus code = HttpStatus.valueOf(e.getErrorCode()); // pega o erro do http
		ErrosPadrao err = new ErrosPadrao(code.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(code).body(err);
	}
	
	@ExceptionHandler(AmazonClientException.class) // erro desse tipo de objeto
	public ResponseEntity<ErrosPadrao> amazonClient(AmazonClientException e, HttpServletRequest request) {
		ErrosPadrao err = new ErrosPadrao(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(AmazonS3Exception.class) // erro desse tipo de objeto
	public ResponseEntity<ErrosPadrao> amazonS3 (AmazonS3Exception e, HttpServletRequest request) {
		ErrosPadrao err = new ErrosPadrao(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}
