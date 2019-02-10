package br.com.estudoapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String descricao;

	@NotBlank
	private int periodo;

	@NotBlank
	private int duracao;

	@NotBlank
	private int quantidadeAlunos;

	@NotBlank
	private int cargaHoraria;
	
	public Curso(String descricao, int periodo, int duracao, int quantidadeAlunos, int cargaHoraria) {
		this.descricao = descricao;
		this.periodo = periodo;
		this.duracao = duracao;
		this.quantidadeAlunos = quantidadeAlunos;
		this.cargaHoraria = cargaHoraria;
	}

	public int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	public void setQuantidadeAlunos(int quantidadeAlunos) {
		this.quantidadeAlunos = quantidadeAlunos;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	

}
