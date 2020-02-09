package com.theoribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theoribeiro.cursomc.domain.Cidade;

/*
 * Interface para operacoes de acesso aos dados de Cidade no BD - CAMADA DE ACESSO A DADOS (REPOSITORY)
 * */

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	
}
