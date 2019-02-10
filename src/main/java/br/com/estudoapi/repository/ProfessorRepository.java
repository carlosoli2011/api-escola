package br.com.estudoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudoapi.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	@Query("SELECT QUE VALIDA SE O TIPOTITULO MESTRE OU DOUTOR EXISTE ")
	public int consultaProfessorDisciplina(Professor professor);
}
