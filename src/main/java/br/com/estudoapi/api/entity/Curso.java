package br.com.estudoapi.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.estudoapi.api.util.TipoPeriodo;
import lombok.Data;

@Data
@Entity
public class Curso implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;

	@Enumerated
	private TipoPeriodo periodo;

	private int duracao;

	@Column(name="quantidade_alunos")
	private int quantidadeAlunos;

	@Column(name="carga_horaria")
	private int cargaHoraria;
}
