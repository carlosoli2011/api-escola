package br.com.estudoapi.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "id_aluno")
	@ManyToOne(targetEntity=Aluno.class)
	private Aluno aluno;
	
	@JoinColumn(name = "id_curso")
	@ManyToOne(targetEntity=Curso.class)
	private Curso curso;
	
	private Date dataCadastro;
	private Date dataInicio;
	private Date dataFim;
	

}
