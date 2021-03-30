package br.com.desafiozup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafiozup.model.AplicacaoVacina;

public interface AplicacaoVacinaRepository extends JpaRepository<AplicacaoVacina, Long> {
	public List<AplicacaoVacina> findAllByTituloContainingIgnoreCase (String titulo);
}
