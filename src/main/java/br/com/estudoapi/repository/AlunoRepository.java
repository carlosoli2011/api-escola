package br.com.estudoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudoapi.entity.Aluno;
import br.com.estudoapi.entity.Disciplina;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	@Query("SELECT QUE VALIDA A MATRICULA DO ALUNO")
	public int consultaMatriculaPeriodoAluno(Aluno aluno);
}
