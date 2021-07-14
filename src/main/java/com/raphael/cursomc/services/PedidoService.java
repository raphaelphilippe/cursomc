package com.raphael.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.cursomc.domain.Pedido;
import com.raphael.cursomc.repositories.PedidoRepository;
import com.raphael.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		
		//Versão de código utilizada até o Java 7
		//Pedido obj = repo.findOne(id);
		
		//Versão de código utilizada no Java 7 em diante
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Pedido.class.getName()));
	}
}
