package com.leodias.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.leodias.cursomc.dominios.Categoria;
import com.leodias.cursomc.dto.CategoriaDTO;
import com.leodias.cursomc.repositories.CategoriaRepository;
import com.leodias.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return Optional.of(obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())));

	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new com.leodias.cursomc.services.exceptions
			.DataIntegrityException("Não é possível excluir uma Categoria que contenha produtos");
			
		}
	}
	
	public List<Categoria> findAll() {
		List<Categoria> lista = repo.findAll();
		return lista;
	}
	
	public Page<Categoria> findPage(Integer page, Integer linhasPorPagina, String ordem, String direcao){
		
		PageRequest pr = PageRequest.of(page, linhasPorPagina, Direction.valueOf(direcao), ordem);
		return repo.findAll(pr);

	}
	
	public Categoria fromDTO(CategoriaDTO objDTO) {
		return new Categoria(objDTO.getId(), objDTO.getNome());
	}
}
