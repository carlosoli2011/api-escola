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

import br.com.estudoapi.entity.Curso;
import br.com.estudoapi.entity.Disciplina;
import br.com.estudoapi.repository.DisciplinaRepository;


@RequestMapping("/disciplina")
@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Disciplina> listAllDisciplinas() {
        return repository.findAll();
    }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Disciplina> save(@RequestBody Disciplina disciplina) {
		int idCurso = repository.consultaDisciplina(disciplina);
		if (idCurso > 0) {
			return new ResponseEntity<Disciplina>(disciplina, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Disciplina>(repository.save(disciplina), HttpStatus.CREATED);
	}

}
