package com.raphael.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.cursomc.domain.Categoria;
import com.raphael.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		//Versão de código utilizada até o Java 7
		//Categoria obj = repo.findOne(id);
		
		//Versão de código utilizada no Java 7 em diante
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
