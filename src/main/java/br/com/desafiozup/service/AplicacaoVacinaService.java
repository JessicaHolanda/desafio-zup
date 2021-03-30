package br.com.desafiozup.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.desafiozup.model.AplicacaoVacina;
import br.com.desafiozup.repository.AplicacaoVacinaRepository;


public class AplicacaoVacinaService {
	
	@Autowired
	private AplicacaoVacinaRepository repository;

	public AplicacaoVacina CadastrarAplicacaoVacina(AplicacaoVacina vacina) {
		

		return repository.save(vacina);
	}


}


