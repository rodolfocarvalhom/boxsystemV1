package br.com.boxsystemV1.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.boxsystemV1.model.Uf;
import br.com.boxsystemV1.service.UfService;

@RestController
@RequestMapping("/admin")
public class ufController {

	@Autowired
	UfService ufService;
	
	//End point
	@RequestMapping(method=RequestMethod.POST,value="/uf", 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Uf> cadastrarUfED(@RequestBody Uf uf){
			
			Uf ufCadastrado = ufService.cadastrar(uf);
			return new ResponseEntity<>(ufCadastrado,HttpStatus.CREATED);
			
		}	

	@RequestMapping(method=RequestMethod.GET,value="/uf", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Uf>> buscarTodasUfED(){
			
			Collection<Uf> ufBuscados = ufService.buscarTodos();
			return new ResponseEntity<>(ufBuscados,HttpStatus.OK);
			
		}	

	@RequestMapping(method=RequestMethod.GET,value="/uf/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Uf> buscarUfIdED(@PathVariable Integer id){
			
			Uf ufBuscado = ufService.buscarId(id);
			return new ResponseEntity<>(ufBuscado,HttpStatus.OK);
			
		}	
	
}
