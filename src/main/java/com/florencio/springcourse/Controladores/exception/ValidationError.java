package com.florencio.springcourse.controladores.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ErrosPadrao {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> field = new ArrayList<>();

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<FieldMessage> getErrors() {
		return field;
	}

	public void addError(String fieldName, String message) {
		field.add(new FieldMessage(fieldName, message));
	}

}
