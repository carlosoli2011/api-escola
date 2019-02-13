package br.com.estudoapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.estudoapi.api.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
	
	@Query("SELECT c FROM Curso c")
	public int consultaDisciplina(Curso curso);

}
