package br.com.estudoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudoapi.entity.Curso;
import br.com.estudoapi.repository.CursoRepository;

@RequestMapping("/curso")
@RestController
public class CursoController {

	@Autowired
	private CursoRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Iterable<Curso> listAllCursos() {
        return repository.findAll();
    }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Curso> save(@RequestBody Curso curso) {
		if (validaCargaHorariaCurso(curso)) {
			return new ResponseEntity<Curso>(curso, HttpStatus.BAD_REQUEST);
		}
		
		int idDisciplina = repository.consultaDisciplina(curso);
		if (idDisciplina >= 0) {
			return new ResponseEntity<Curso>(curso, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Curso>(repository.save(curso), HttpStatus.CREATED);
	}
	
	private boolean validaCargaHorariaCurso(Curso curso) {
		return (curso.getCargaHoraria() >= 20 && curso.getCargaHoraria() <= 40);
	}

}
