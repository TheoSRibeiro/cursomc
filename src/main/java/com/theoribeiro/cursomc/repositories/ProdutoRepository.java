package com.theoribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theoribeiro.cursomc.domain.Produto;

/*
 * Interface para operacoes de acesso aos dados de Produto no BD - CAMADA DE ACESSO A DADOS (REPOSITORY)
 * */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
}
