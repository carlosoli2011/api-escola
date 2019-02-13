package br.com.estudoapi.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudoapi.api.entity.Curso;
import br.com.estudoapi.api.entity.Disciplina;
import br.com.estudoapi.api.entity.Professor;
import br.com.estudoapi.api.repository.DisciplinaRepository;


@RequestMapping("/disciplina")
@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Disciplina>> listAllDisciplinas() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.CREATED);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Disciplina save(@RequestBody Disciplina disciplina) {
//		int idCurso = repository.consultaDisciplina(disciplina);
//		if (idCurso > 0) {
//			return new ResponseEntity<Disciplina>(disciplina, HttpStatus.BAD_REQUEST);
//		}
		
		return repository.save(disciplina);
	}

}
