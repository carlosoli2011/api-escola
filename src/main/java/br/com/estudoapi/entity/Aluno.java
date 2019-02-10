package br.com.estudoapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	private Matricula matricula;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String rg;
	
	@NotBlank
	private String cpf;

}
