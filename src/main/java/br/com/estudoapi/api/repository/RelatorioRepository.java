package br.com.estudoapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.estudoapi.api.entity.Curso;

public interface RelatorioRepository extends JpaRepository<Curso, Long>{

	//public int buscarTipoRelatorio(String tipoRelatorio);
}
