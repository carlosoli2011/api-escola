package br.com.estudoapi.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.estudoapi.api.util.TipoDiaSemana;
import lombok.Data;

@Entity
@Data
public class Disciplina implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String descricao;
	private String ementa;
	private int limiteVagas;
	private int cargaHoraria;

	@Enumerated
	private TipoDiaSemana diaDaSemana;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_professor", nullable = false, updatable = false, insertable = true)
    @JsonBackReference(value="professor")
	private Professor professor;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false, updatable = false, insertable = true)
    @JsonBackReference(value="curso")
	private Curso curso;

}
