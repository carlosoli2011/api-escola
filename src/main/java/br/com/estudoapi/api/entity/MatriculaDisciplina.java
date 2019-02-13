package br.com.estudoapi.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MatriculaDisciplina implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JoinColumn(name = "id_disciplina")
	@ManyToOne(targetEntity=Disciplina.class)
	private Disciplina disciplina;
	
	@JoinColumn(name = "id_matricula")
	@ManyToOne(targetEntity=Matricula.class)
	private Matricula matricula;

}
