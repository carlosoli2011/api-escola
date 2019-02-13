package br.com.estudoapi.api.util;

public enum TipoPeriodo {
	
	TODOS(0),
	MATUTINO(1),
	VESPERTINO(2),
	NOTURNO(3),
	INTEGRAL(4);

	private int id;

	private TipoPeriodo (int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
