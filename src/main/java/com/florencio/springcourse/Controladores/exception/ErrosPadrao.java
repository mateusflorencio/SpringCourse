package com.florencio.springcourse.controladores.exception;

import java.io.Serializable;

public class ErrosPadrao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer status;
	private String msg;
	private Long momento;

	public ErrosPadrao(Integer status, String msg, Long momento) {
		super();
		this.status = status;
		this.msg = msg;
		this.momento = momento;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getMomento() {
		return momento;
	}

	public void setMomento(Long momento) {
		this.momento = momento;
	}

}
