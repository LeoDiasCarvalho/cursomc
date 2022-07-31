package com.leodias.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leodias.cursomc.dominios.Categoria;
import com.leodias.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> buscarPorId(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj;
	}
}
