package br.com.estudoapi.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Data
@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int matricula;
	private String nome;
	private String rg;
	private String cpf;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany
    @JoinColumn(name="id_aluno")
	private transient List<Matricula> matriculas = new ArrayList<>();

}
