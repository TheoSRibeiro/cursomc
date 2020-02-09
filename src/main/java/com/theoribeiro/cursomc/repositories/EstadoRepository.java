package com.theoribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theoribeiro.cursomc.domain.Estado;

/*
 * Interface para operacoes de acesso aos dados de Estado no BD - CAMADA DE ACESSO A DADOS (REPOSITORY)
 * */

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
}
