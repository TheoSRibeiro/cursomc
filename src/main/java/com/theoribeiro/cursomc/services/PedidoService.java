package com.theoribeiro.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theoribeiro.cursomc.domain.Pedido;
import com.theoribeiro.cursomc.repositories.PedidoRepository;
import com.theoribeiro.cursomc.services.exceptions.ObjectNotFoundException;

/*
 * CAMADA DE SERVICO - Retorna operação de AOS DADOS (Camada de Acesso aos dados)
 * */

@Service
public class PedidoService {
	
	@Autowired //instanciar automaticamente pelo spring a variavel repo
	private PedidoRepository repo; //Repository - acesso ao dado
	
	public Pedido buscar(Integer id) { //BUSCA PELO CODIGO ID
		Pedido obj = repo.findOne(id); //vai no BD buscar uma Pedido e retorna um Objeto pronto
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "+ Pedido.class.getName());
		}
		
		return obj;
	}
}
