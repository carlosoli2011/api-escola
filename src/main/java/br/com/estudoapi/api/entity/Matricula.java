package br.com.estudoapi.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date dataCadastro;
	private Date dataInicio;
	private Date dataFim;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aluno", nullable = false, updatable = false, insertable = true)
	@JsonBackReference(value = "aluno")
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curso", nullable = false, updatable = false, insertable = true)
	@JsonBackReference(value = "curso")
	private Curso curso;
}
