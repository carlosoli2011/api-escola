package br.com.estudoapi.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.com.estudoapi.api.util.TipoPeriodo;
import lombok.Data;

@Data
@Entity
public class Curso {

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
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany
    @JoinColumn(name="id_curso")
	private transient List<CursoDisciplina> cursoDisciplinas = new ArrayList<>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany
    @JoinColumn(name="id_curso")
	private transient List<Disciplina> disciplinas = new ArrayList<>();	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany
    @JoinColumn(name="id_curso")
	private transient List<Matricula> matriculass = new ArrayList<>();
		

}
