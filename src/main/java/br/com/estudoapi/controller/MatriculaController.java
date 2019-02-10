package br.com.estudoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudoapi.entity.Matricula;
import br.com.estudoapi.repository.MatriculaRepository;


@RequestMapping("/matricula")
@RestController
public class MatriculaController {

	@Autowired
	private MatriculaRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Matricula> listAllMatriculas() {
        return repository.findAll();
    }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Matricula> save(@RequestBody Matricula matricula) {
		int limiteVagas = repository.consultaLimiteVagas(matricula);
		
		if(limiteVagas > -1) {
			new ResponseEntity<Matricula>(matricula, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Matricula>(repository.save(matricula), HttpStatus.CREATED);
	}

}
