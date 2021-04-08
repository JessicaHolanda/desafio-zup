package br.com.desafiozup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiozup.model.AplicacaoVacina;

@Repository
public interface AplicacaoVacinaRepository extends JpaRepository<AplicacaoVacina, Long> {
	public List<AplicacaoVacina> findAllByVacinaContainingIgnoreCase (String vacina);
}
