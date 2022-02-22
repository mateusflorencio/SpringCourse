package com.florencio.springcourse.controladores.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationPadrao extends ErrosPadrao {

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> field = new ArrayList<>();

	public ValidationPadrao(Integer status, String msg, Long momento) {
		super(status, msg, momento);

	}

	public List<FieldMessage> getErrors() {
		return field;
	}

	public void addError(String fieldName, String message) {
		field.add(new FieldMessage(fieldName, message));
	}

}
