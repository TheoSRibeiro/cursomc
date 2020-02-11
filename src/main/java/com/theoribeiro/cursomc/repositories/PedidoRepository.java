package com.theoribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theoribeiro.cursomc.domain.Pedido;

/*
 * Interface para operacoes de acesso aos dados de Pedido no BD - CAMADA DE ACESSO A DADOS (REPOSITORY)
 * */

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
}
