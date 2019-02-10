package br.com.estudoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudoapi.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
	
	@Query("SELECT d FROM ")
	public int consultaDisciplina(Curso curso);

}
