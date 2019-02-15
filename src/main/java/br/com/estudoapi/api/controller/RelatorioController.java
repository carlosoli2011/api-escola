package br.com.estudoapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudoapi.api.repository.RelatorioRepository;

@RequestMapping("/relatorio")
@RestController
public class RelatorioController {

	@Autowired
	private RelatorioRepository repository;

//	@RequestMapping("/relatorio/{tipoRelatorio}")//curso-disciplina curso-aluno aluno-curso
//	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public void buscarTipoRelatorio(@RequestBody String tipoRelatorio) {
//		repository.buscarTipoRelatorio(tipoRelatorio);
//		//retornar dados para criar a jtree para desk
//        //return e tipo de metodo
//    }
}	
