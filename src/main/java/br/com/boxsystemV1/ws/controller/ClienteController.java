package br.com.boxsystemV1.ws.controller;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.boxsystemV1.model.Cliente;
import br.com.boxsystemV1.service.ClienteService;

 
//Servlet
@RestController
@RequestMapping("/admin")
@Transactional
public class ClienteController {
	@Autowired
	ClienteService clienteService;
	
	//End point
	@RequestMapping(method=RequestMethod.POST,value="/clientes", 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarClienteED(@RequestBody Cliente cliente){
			
			Cliente clienteCadastrado = clienteService.cadastrar(cliente);
			return new ResponseEntity<>(clienteCadastrado,HttpStatus.CREATED);
			
		}

	@RequestMapping(method=RequestMethod.GET,value="/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientesED(){
			
			Collection<Cliente> clientesBuscados = clienteService.buscarTodos();
			return new ResponseEntity<>(clientesBuscados,HttpStatus.OK);
			
		}	

	@RequestMapping(method=RequestMethod.GET,value="/clientes/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarClienteIdED(@PathVariable Integer id){
			
			Cliente clienteBuscado = clienteService.buscarId(id);
			return new ResponseEntity<>(clienteBuscado,HttpStatus.OK);
			
		}		
	
	//Removendo acessando parametro vindo na URL
	@RequestMapping(method=RequestMethod.DELETE,value="/clientes/{id}")
	
	public ResponseEntity<Cliente> excluirClienteED(@PathVariable Integer id){
			
			Cliente clienteEncontrado = clienteService.buscarId(id);
		
			if(clienteEncontrado==null){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			clienteService.excluir(clienteEncontrado);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}	

	@RequestMapping(method=RequestMethod.PUT,value="/clientes", 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Cliente> alterarClienteED(@RequestBody Cliente cliente){
			
			Cliente clienteAlterado = clienteService.alterar(cliente);
			return new ResponseEntity<>(clienteAlterado,HttpStatus.OK);
			
		}	
	
}
