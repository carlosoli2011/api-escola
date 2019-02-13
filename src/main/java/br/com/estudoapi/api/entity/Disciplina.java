package br.com.estudoapi.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.com.estudoapi.api.util.TipoDiaSemana;
import lombok.Data;

@Entity
@Data
public class Disciplina implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;
	private String ementa;
	private int limiteVagas;
	private int cargaHoraria;

	@Enumerated
	private TipoDiaSemana diaDaSemana;
	
	@JoinColumn(name = "id_professor")
	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Professor.class)
	private Professor professor;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany
    @JoinColumn(name="id_disciplina")
	private transient List<CursoDisciplina> cursoDisciplinas = new ArrayList<>();

}
