package br.com.boxsystemV1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import br.com.boxsystemV1.model.Usuario;
import br.com.boxsystemV1.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario autenticar(Usuario usuario){
		
		return usuarioRepository.buscarLogin(usuario.getLogin());
	}	

	public Usuario salvar(Usuario usu){
		
		return usuarioRepository.save(usu);
	}	
	
}
