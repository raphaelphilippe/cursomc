package com.raphael.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.cursomc.domain.Cliente;
import com.raphael.cursomc.repositories.ClienteRepository;
import com.raphael.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		
		//Versão de código utilizada até o Java 7
		//Cliente obj = repo.findOne(id);
		
		//Versão de código utilizada no Java 7 em diante
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Cliente.class.getName()));
	}
}
