package br.com.estudoapi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(targetEntity=Disciplina.class)
	private List<Disciplina> disciplina;
	@ManyToMany(targetEntity=Aluno.class)
	private List<Aluno> alunos;
	private Date dataCadastro;
	private Date dataInicio;
	private Date dataFim;
	

}
