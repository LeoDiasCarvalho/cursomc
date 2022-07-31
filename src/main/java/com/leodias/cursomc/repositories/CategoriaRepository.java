package com.leodias.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leodias.cursomc.dominios.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}