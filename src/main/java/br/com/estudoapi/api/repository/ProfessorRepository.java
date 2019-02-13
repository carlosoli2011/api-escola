package br.com.estudoapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudoapi.api.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	@Query("SELECT p FROM Professor p")
	public int consultaProfessorDisciplina(Professor professor);
}
