package br.com.estudoapi.util;

public enum TipoTitulo {

	MESTRE(1),
	DOUTOR(2),
	INSTRUTOR(3);
	
	private int id;
	
	private TipoTitulo (int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
