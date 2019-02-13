package br.com.estudoapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudoapi.api.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
	
	@Query("SELECT d FROM Disciplina d")
	public int consultaDisciplina(Disciplina disciplina);

}
