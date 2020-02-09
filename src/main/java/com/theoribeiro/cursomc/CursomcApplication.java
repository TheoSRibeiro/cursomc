package com.theoribeiro.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.theoribeiro.cursomc.domain.Categoria;
import com.theoribeiro.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{ //utilizar CommanLineRunner para instanciar o BD

	// O REPOSITORY SALVA OS DADOS NO BD
	@Autowired
	private CategoriaRepository categoriaRepositpry;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { //INSTANCIAR O BD
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		categoriaRepositpry.save(Arrays.asList(cat1,cat2));
		
	}

}
