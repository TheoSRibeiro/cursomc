package com.theoribeiro.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theoribeiro.cursomc.domain.Cliente;
import com.theoribeiro.cursomc.services.ClienteService;

/*
 * CONTROLADOR REST PARA ACECSSAR A CAMADA DE SERVICO
 * */

@RestController
@RequestMapping(value="/clientes") //ENDPOINT - CLIENTES
public class ClienteResource {
	
	@Autowired // Instanciar o objeto service automaticamente
	private ClienteService service;
	
	//@RequestMapping(method=RequestMethod.GET)
	@RequestMapping(value="/{id}", method=RequestMethod.GET) // inseriu i ID para buscar pelo id da categoria na URL
	//public String listar() {
	public ResponseEntity<?> find(@PathVariable Integer id) { //@PathVariable para pegar o id passado na URL 
		//ResponseEntity - para encapsular varias informacoes http para um servico REST, do tipo ? para ser de qualquer tipo 
		
		Cliente obj = service.buscar(id); //Buscar a CAtegoria que tem esse ID
		return ResponseEntity.ok().body(obj); //Retorna um ok e o Objeto requerido, o dado.
		
		/*// Não precisa mais disso
		Cliente cat1 = new Cliente(1,"Informática");
		Cliente cat2 = new Cliente(2,"Escritório");
		
		List<Cliente> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		//return "Rest está Funcionando!";
		return lista;
		*/
	}
}
