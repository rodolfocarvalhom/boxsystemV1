package br.com.boxsystemV1.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.boxsystemV1.model.Uf;
import br.com.boxsystemV1.repository.UfRepository;

@Service
public class UfService {

	@Autowired
	UfRepository ufRepository;
	
	public Uf cadastrar(Uf uf){
		return ufRepository.save(uf);
	}

	public Collection<Uf> buscarTodos(){
		return ufRepository.findAll();
	}	
	
	public Uf buscarId(Integer id){
		return ufRepository.findOne(id);
	}	
}
