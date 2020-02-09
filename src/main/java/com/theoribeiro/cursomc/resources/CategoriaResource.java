package com.theoribeiro.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theoribeiro.cursomc.domain.Categoria;
import com.theoribeiro.cursomc.services.CategoriaService;

/*
 * CONTROLADOR REST PARA ACECSSAR A CAMADA DE SERVICO
 * */

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired // Instanciar o objeto service automaticamente
	private CategoriaService service;
	
	//@RequestMapping(method=RequestMethod.GET)
	@RequestMapping(value="/{id}", method=RequestMethod.GET) // inseriu i ID para buscar pelo id da categoria na URL
	//public String listar() {
	public ResponseEntity<?> find(@PathVariable Integer id) { //@PathVariable para pegar o id passado na URL 
		//ResponseEntity - para encapsular varias informacoes http para um servico REST, do tipo ? para ser de qualquer tipo 
		
		Categoria obj = service.buscar(id); //Buscar a CAtegoria que tem esse ID
		return ResponseEntity.ok().body(obj); //Retorna um ok e o Objeto requerido, o dado.
		
		/*// Não precisa mais disso
		Categoria cat1 = new Categoria(1,"Informática");
		Categoria cat2 = new Categoria(2,"Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		//return "Rest está Funcionando!";
		return lista;
		*/
	}
}
