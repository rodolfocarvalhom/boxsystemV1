package br.com.boxsystemV1.ws.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.boxsystemV1.model.Usuario;
import br.com.boxsystemV1.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.POST,value="/usuarios/autenticar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse autenticarED(@RequestBody Usuario usuario) throws ServletException{
		
		if(usuario.getLogin() == null || usuario.getSenha() == null){
			throw new ServletException("Nome e senha obrigatorios!");
		}
		
		Usuario usuAutenticado = usuarioService.autenticar(usuario);
		if(usuAutenticado == null){
			throw new ServletException("Usuario não encontrado!");
		}
		
		if(!usuAutenticado.getSenha().equals(usuario.getSenha())){
			throw new ServletException("Usuario ou senha inválido!");
		}
		
		//TOKEN
		//return new ResponseEntity<>(usuAutenticado,HttpStatus.OK);
		String token = Jwts.builder()
				.setSubject(usuAutenticado.getLogin())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();
		return new LoginResponse(token);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/usuarios/salvar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> salvarED(@RequestBody Usuario usuario){
		
		Usuario usuarioCadastrado = usuarioService.salvar(usuario);
		return new ResponseEntity<>(usuarioCadastrado,HttpStatus.CREATED);
	}	
	
	private class LoginResponse{
		public String token;
		public LoginResponse(String token){
			this.token=token;
		}
//		public String getToken() {
//			return token;
//		}
	}
	
}
