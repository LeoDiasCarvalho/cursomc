package com.leodias.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leodias.cursomc.dominios.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
