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

import br.com.estudoapi.api.entity.Professor;
import br.com.estudoapi.api.repository.ProfessorRepository;
import br.com.estudoapi.api.util.MensagemErro;
import br.com.estudoapi.api.util.ResourceException;

@RequestMapping("/professor")
@RestController
public class ProfessorController {

	@Autowired
	private ProfessorRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Professor>> listAllProfessores() {
		try {
			return new ResponseEntity<Iterable<Professor>>(repository.findAll(), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResourceException(HttpStatus.BAD_REQUEST,
					MensagemErro.ERRO_AO_LISTAR_PROFESSORES + e.getMessage());
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Professor> save(@RequestBody Professor professor) {
		try {
			// int idProfessor = repository.consultaProfessorDisciplina(professor);
			//
			// if (idProfessor > -1) {
			// new ResponseEntity<Professor>(repository.save(professor),
			// HttpStatus.BAD_REQUEST);
			// }

			return new ResponseEntity<Professor>(repository.save(professor), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResourceException(HttpStatus.BAD_REQUEST,
					MensagemErro.ERRO_AO_CADASTRAR_PROFESSOR + e.getMessage());
		}
	}
}

//{
//    "descricao": "Curso de Java",
//    "periodo": 1,
//    "duracao": 2,
//    "quantidadeAlunos": 15,
//    "cargaHoraria": 30
//}
