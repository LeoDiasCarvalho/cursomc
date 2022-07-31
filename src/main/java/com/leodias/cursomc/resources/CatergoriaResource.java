package com.leodias.cursomc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leodias.cursomc.dominios.Categoria;
import com.leodias.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CatergoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		
		Optional<Categoria> obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}

}
