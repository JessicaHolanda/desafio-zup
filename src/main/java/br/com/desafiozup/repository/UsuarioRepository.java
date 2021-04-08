package br.com.desafiozup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiozup.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
	public Boolean existsUsuarioByEmail(String email);
	public Boolean existsUsuarioByCpf(String cpf);
}
