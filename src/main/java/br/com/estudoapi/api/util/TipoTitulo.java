package br.com.estudoapi.api.util;

public enum TipoTitulo {

	MESTRE(0),
	DOUTOR(1),
	INSTRUTOR(2);
	
	private int id;
	
	private TipoTitulo (int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
