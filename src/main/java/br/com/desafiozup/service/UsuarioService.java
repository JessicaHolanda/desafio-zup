package br.com.desafiozup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafiozup.exception.UserException;
import br.com.desafiozup.model.Usuario;
import br.com.desafiozup.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public Usuario CadastrarUsuario(Usuario usuario) {
		
		if (repository.existsUsuarioByEmail(usuario.getEmail()) || repository.existsUsuarioByCpf(usuario.getCpf())) {
			throw new UserException("CPF ou Email já cadastrados!");
		}
		 
		return repository.save(usuario);
	}
}
