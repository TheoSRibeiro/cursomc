package com.theoribeiro.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.theoribeiro.cursomc.domain.Categoria;
import com.theoribeiro.cursomc.domain.Produto;
import com.theoribeiro.cursomc.repositories.CategoriaRepository;
import com.theoribeiro.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{ //utilizar CommanLineRunner para instanciar o BD

	// O REPOSITORY SALVA OS DADOS NO BD
	@Autowired 
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { //INSTANCIAR O BD
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		//INSTANCIAR OS PRODUTOS DAS CATEGORIAS
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		//ASSOCIAR AS CATEGORIAS AOS PRODUTOS
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3)); //ADICIONA P1,P2 E P3 A CATEGORIA 1
		cat2.getProdutos().addAll(Arrays.asList(p2)); //ADICIONA P2 A CATEGORIA 2
		
		//ASSOCIAR OS PRODUTOS AS CATEGORIAS
		p1.getCategorias().addAll(Arrays.asList(cat1)); //PRODUTO 1 PERTENCE A CATEGORIA 1
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2)); //PRODUTO 2 PERTENCE A CATEGORIA 1 e 2
		p3.getCategorias().addAll(Arrays.asList(cat1)); //PRODUTO 3 PERTENCE A CATEGORIA 1
		
		//REPOSITORY PARA SALVAR AS CATEGORIAS, FOI CRIADO LA EM CIMA (@AUTOWIRED)  
		//CRIADO NA CLASSE CategoriaRepository 
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		
		//REPOSITORY PARA SALVAR OS PRODUTOS, FOI CRIADO LA EM CIMA (@AUTOWIRED)  
		//CRIADO NA CLASSE ProdutoRepository 
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
	}

}
