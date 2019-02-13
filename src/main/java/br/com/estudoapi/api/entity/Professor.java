package br.com.estudoapi.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.com.estudoapi.api.util.TipoTitulo;
import lombok.Data;

@Entity
@Data
public class Professor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;
	private String rg;
	private String cpf;
	
	@Enumerated
	private TipoTitulo titulo;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name="id_professor")
	private transient List<Disciplina> disciplinas = new ArrayList<>();		
}
