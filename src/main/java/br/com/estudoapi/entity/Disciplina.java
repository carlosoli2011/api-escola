package br.com.estudoapi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String ementa;
	
	@NotBlank
	private int limiteVagas;
	
	@NotBlank
	@ManyToMany(targetEntity=Professor.class)	
	private List<Professor> professor;
	
	@NotBlank
	@Enumerated
	private String diaDaSemana;
	
	@NotBlank
	private int cargaHoraria;

}
