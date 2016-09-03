package br.com.boxsystemV1.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.boxsystemV1.model.Cliente;
import br.com.boxsystemV1.repository.ClienteRepository;

@Service
public class ClienteService {

	//Antigo DAO mas com spring boot renomear para Repository
	@Autowired
	ClienteRepository clienteRepository;
	
//	private Map<Integer,Cliente> bdclientes = new HashMap<>();
//	private Integer proximoId = 1;
	//Negocios
	public Cliente cadastrar(Cliente cliente){
		
		return clienteRepository.save(cliente);
		
	}
	
	public Collection<Cliente> buscarTodos(){
		
		return clienteRepository.findAll();
		
	}
	
	public void excluir(Cliente cliente){

		clienteRepository.delete(cliente);
		
	}

	public Cliente buscarId(Integer id){
		return clienteRepository.findOne(id);
	}
	
	public Cliente alterar(Cliente cliente){
		
		return clienteRepository.save(cliente);
		
	}
	
}
