package com.florencio.springcourse.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1), PESSOAJURIDICA(2);

	private int cod;

	TipoCliente(int i) {
		this.cod = i;
	}

	public int getCod() {
		return cod;
	}

	public static TipoCliente paraEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);

	}
}
