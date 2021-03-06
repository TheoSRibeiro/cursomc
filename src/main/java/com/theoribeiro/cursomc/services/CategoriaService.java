package com.theoribeiro.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theoribeiro.cursomc.domain.Categoria;
import com.theoribeiro.cursomc.repositories.CategoriaRepository;
import com.theoribeiro.cursomc.services.exceptions.ObjectNotFoundException;

/*
 * CAMADA DE SERVICO - Retorna operação de AOS DADOS (Camada de Acesso aos dados)
 * */

@Service
public class CategoriaService {
	
	@Autowired //instanciar automaticamente pelo spring a variavel repo
	private CategoriaRepository repo; //Repository - acesso ao dado
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id); //vai no BD buscar uma Categoria e retorna um Objeto pronto
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "+ Categoria.class.getName());
		}
		
		return obj;
	}
}
