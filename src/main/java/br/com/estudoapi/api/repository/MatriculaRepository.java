package br.com.estudoapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudoapi.api.entity.Curso;
import br.com.estudoapi.api.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	
	@Query("SELECT m FROM Matricula m")
	public int consultaLimiteVagas(Matricula matricula);

}
