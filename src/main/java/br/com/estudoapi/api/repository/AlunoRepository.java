package br.com.estudoapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudoapi.api.entity.Aluno;
import br.com.estudoapi.api.entity.Disciplina;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	@Query("SELECT a FROM Aluno a")
	public int consultaMatriculaPeriodoAluno(Aluno aluno);
}
