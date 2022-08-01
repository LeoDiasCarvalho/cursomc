package com.leodias.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leodias.cursomc.dominios.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
