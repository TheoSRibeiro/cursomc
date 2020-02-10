package com.theoribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theoribeiro.cursomc.domain.Endereco;

/*
 * Interface para operacoes de acesso aos dados de Endereco no BD - CAMADA DE ACESSO A DADOS (REPOSITORY)
 * */

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	
}
