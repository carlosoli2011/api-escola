package br.com.estudoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudoapi.entity.Curso;
import br.com.estudoapi.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	
	@Query("SELECT QUANTIDADE DE ALUNOS DO CURSO COM O TOTAL DE MATRICULAS JA REALIZADAS")
	public int consultaLimiteVagas(Matricula matricula);

}
