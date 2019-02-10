package br.com.estudoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudoapi.entity.Curso;

public interface RelatorioRepository extends JpaRepository<Curso, Long>{

	@Query("SELECT DO TIPO RELATORIO")
	public int buscarTipoRelatorio(String tipoRelatorio);
}
