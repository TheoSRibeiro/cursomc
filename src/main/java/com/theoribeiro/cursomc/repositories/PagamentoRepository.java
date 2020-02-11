package com.theoribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theoribeiro.cursomc.domain.Pagamento;

/*
 * Interface para operacoes de acesso aos dados de Pagamento no BD - CAMADA DE ACESSO A DADOS (REPOSITORY)
 * */

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
	
}
