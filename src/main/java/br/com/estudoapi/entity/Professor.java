package br.com.estudoapi.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.estudoapi.util.TipoTitulo;
import lombok.Data;

@Data
@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;
	private String rg;
	private String cpf;
	@Enumerated
	private TipoTitulo titulo;

}
