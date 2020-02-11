package com.theoribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theoribeiro.cursomc.domain.ItemPedido;

/*
 * Interface para operacoes de acesso aos dados de ItemPedido no BD - CAMADA DE ACESSO A DADOS (REPOSITORY)
 * */

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
	
}
