package com.theoribeiro.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	//@JsonManagedReference NAO VAI SER MAIS UTILIZADO, TODOS OS @JsonBackReference FOI TROCADO POR @JsonIgnore, 
	//@JsonManagedReference //SERIALIZAR OS PRODUTOS SEM ERRO PARA OS OBJETOS ASSOCIADOS DA CATEGORIA
	
	/*MAPEAMENTO DAS RELACOES ENTRE AS TABELAS PRODUTO E CATEGORIA, COMO SAO N PARA N, CRIAR UMA TERCEIRA TABELA COM
	  OS CODIGOS IDS DAS 2 TABELAS, COMO JA FEZ ISSO NA CLASSE PRODUTO, NAO PRECISA REFAZER AQUI, ASSSIM:	
	*/
	@ManyToMany(mappedBy = "categorias")
	// ASSOCIACAO DE CATEGORIA E PRODUTO, 1 OU + CATEGORIAS PODEM TER VARIOS PRODUTOS
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria() {
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
