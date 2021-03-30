package br.com.desafiozup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiozup.model.AplicacaoVacina;
import br.com.desafiozup.repository.AplicacaoVacinaRepository;
import br.com.desafiozup.service.AplicacaoVacinaService;

@RestController
@RequestMapping("/vacinas")
@CrossOrigin("*")
public class AplicacaoVacinaController {

	@Autowired
	private AplicacaoVacinaRepository repository;
	
	@Autowired
	private AplicacaoVacinaService service;

	@GetMapping
	public ResponseEntity<List<AplicacaoVacina>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AplicacaoVacina> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/vacinas/{vacina}")
	public ResponseEntity<List<AplicacaoVacina>> GetbyTitulo(@PathVariable String vacina) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(vacina));
	}

	@PostMapping
	public ResponseEntity<AplicacaoVacina> post(@RequestBody AplicacaoVacina aplicacaoVacina) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.CadastrarAplicacaoVacina(aplicacaoVacina));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping
	public ResponseEntity<AplicacaoVacina> put(@RequestBody AplicacaoVacina aplicacaoVacina) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(aplicacaoVacina));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
