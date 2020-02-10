package com.theoribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theoribeiro.cursomc.domain.Cliente;

/*
 * Interface para operacoes de acesso aos dados de Cliente no BD - CAMADA DE ACESSO A DADOS (REPOSITORY)
 * */

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}
