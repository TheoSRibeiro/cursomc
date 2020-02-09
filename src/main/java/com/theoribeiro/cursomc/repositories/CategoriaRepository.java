package com.theoribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theoribeiro.cursomc.domain.Categoria;

/*
 * Interface para operacoes de acesso aos dados de Categoria no BD - CAMADA DE ACESSO A DADOS (REPOSITORY)
 * */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}
