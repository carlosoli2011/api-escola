package br.com.estudoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudoapi.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
	
	@Query("SELECT QUE VALIDA CARGA HORARIA E DISCIPLINA DO CURSO")
	public int consultaDisciplina(Disciplina disciplina);

}
