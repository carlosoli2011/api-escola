package br.com.estudoapi.api.util;

public enum TipoDiaSemana {

	SEGUNDA(1),
	TERCA(2),
	QUARTA(3),
	QUINTA(4),
	SEXTA(5),
	SABADO(6),
	DOMINGO(7);
	
	private int id;
	
	private TipoDiaSemana (int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
