package com.theoribeiro.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theoribeiro.cursomc.domain.Pedido;
import com.theoribeiro.cursomc.services.PedidoService;

/*
 * CONTROLADOR REST PARA ACECSSAR A CAMADA DE SERVICO
 * */

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired // Instanciar o objeto service automaticamente
	private PedidoService service;
	
	//@RequestMapping(method=RequestMethod.GET)
	@RequestMapping(value="/{id}", method=RequestMethod.GET) // inserir o ID para buscar pelo id do Pedido na URL
	//public String listar() {
	public ResponseEntity<?> find(@PathVariable Integer id) { //@PathVariable para pegar o id passado na URL 
		//ResponseEntity - para encapsular varias informacoes http para um servico REST, do tipo ? para ser de qualquer tipo 
		
		Pedido obj = service.buscar(id); //Buscar a Pedido que tem esse ID
		return ResponseEntity.ok().body(obj); //Retorna um ok e o Objeto requerido, o dado.
		
	}
}
