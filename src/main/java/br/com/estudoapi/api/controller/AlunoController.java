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

import br.com.estudoapi.api.entity.Aluno;
import br.com.estudoapi.api.repository.AlunoRepository;
import br.com.estudoapi.api.util.ResourceException;

@RequestMapping("/aluno")
@RestController
public class AlunoController {

	@Autowired
	private AlunoRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Aluno> listAllAlunos() {
		try {
		return repository.findAll();
		} catch (Exception e) {
			throw new ResourceException(HttpStatus.BAD_REQUEST, "Erro ao consultar os Alunos");
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
		try {
			// int idAluno = repository.consultaMatriculaPeriodoAluno(aluno);

			// if (idAluno > -1) {
			// return new ResponseEntity<Aluno>(aluno, HttpStatus.BAD_REQUEST);
			// }
			return new ResponseEntity<Aluno>(repository.save(aluno), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResourceException(HttpStatus.BAD_REQUEST, "Erro ao salvar o Aluno!");
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
