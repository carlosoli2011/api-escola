package br.com.estudoapi.api.controller;

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

import br.com.estudoapi.api.entity.Disciplina;
import br.com.estudoapi.api.repository.DisciplinaRepository;
import br.com.estudoapi.api.util.ResourceException;

@RequestMapping("/disciplina")
@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Disciplina>> listAllDisciplinas() {
		try {
			return new ResponseEntity<Iterable<Disciplina>>(repository.findAll(), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResourceException(HttpStatus.BAD_REQUEST, "Erro ao listar Disciplinas" + e.getMessage());
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Disciplina save(@RequestBody Disciplina disciplina) {
		try {
			return repository.save(disciplina);
		} catch (Exception e) {
			throw new ResourceException(HttpStatus.BAD_REQUEST, "Erro ao salvar Disciplinas! " + e.getMessage());
		}
	}
}

//{
//    "descricao": "Aprendendo Java parte 2",
//    "ementa": "descricao da ementa",
//    "limiteVagas": 20,
//    "professor": {"id":1},
//    "curso": {"id":1},
//    "diaDaSemana": 1,
//    "cargaHoraria": 20 
//}
