package br.com.estudoapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudoapi.api.entity.Matricula;
import br.com.estudoapi.api.repository.MatriculaRepository;
import br.com.estudoapi.api.util.MensagemErro;
import br.com.estudoapi.api.util.ResourceException;

@RequestMapping("/matricula")
@RestController
public class MatriculaController {

	@Autowired
	private MatriculaRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Matricula> listAllMatriculas() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			throw new ResourceException(HttpStatus.BAD_REQUEST,
					MensagemErro.ERRO_AO_LISTAR_MATRICULAS + e.getMessage());
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Matricula> save(@RequestBody Matricula matricula) {
		try {
			// int limiteVagas = repository.consultaLimiteVagas(matricula);
			//
			// if (limiteVagas > -1) {
			// new ResponseEntity<Matricula>(matricula, HttpStatus.BAD_REQUEST);
			// }
			return new ResponseEntity<Matricula>(repository.save(matricula), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResourceException(HttpStatus.BAD_REQUEST,
					MensagemErro.ERRO_AO_CADASTRAR_MATRICULA + e.getMessage());
		}
	}

}
