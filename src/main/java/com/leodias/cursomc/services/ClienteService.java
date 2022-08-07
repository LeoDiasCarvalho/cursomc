package com.leodias.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leodias.cursomc.dominios.Cliente;
import com.leodias.cursomc.repositories.ClienteRepository;
import com.leodias.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Optional<Cliente> findById(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return Optional.of(obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())));
	}
}
