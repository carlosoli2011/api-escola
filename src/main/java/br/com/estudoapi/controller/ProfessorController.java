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

import br.com.estudoapi.entity.Professor;
import br.com.estudoapi.repository.ProfessorRepository;


@RequestMapping("/professor")
@RestController
public class ProfessorController {

	@Autowired
	private ProfessorRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Professor> listAllProfessores() {
        return repository.findAll();
    }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Professor> save(@RequestBody Professor professor) {
		int idProfessor = repository.consultaProfessorDisciplina(professor);
		
		if (idProfessor > -1) {
			new ResponseEntity<Professor>(repository.save(professor), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Professor>(repository.save(professor), HttpStatus.CREATED);
	}
}
