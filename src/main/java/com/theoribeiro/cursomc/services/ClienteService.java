package com.theoribeiro.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theoribeiro.cursomc.domain.Cliente;
import com.theoribeiro.cursomc.repositories.ClienteRepository;
import com.theoribeiro.cursomc.services.exceptions.ObjectNotFoundException;

/*
 * CAMADA DE SERVICO - Retorna operação de AOS DADOS (Camada de Acesso aos dados)
 * CRIACAO DO ENDPOINT DE CLIENTE
 * */

@Service
public class ClienteService {
	
	@Autowired //instanciar automaticamente pelo spring a variavel repo
	private ClienteRepository repo; //Repository - acesso ao dado
	
	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id); //vai no BD buscar uma Cliente e retorna um Objeto pronto
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "+ Cliente.class.getName());
		}
		
		return obj;
	}
}
