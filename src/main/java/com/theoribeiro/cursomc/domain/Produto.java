package com.theoribeiro.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

//MAPEAMENTO DA TABELA PRODUTO
@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//MAPEAMENTO DA TABELA PRODUTO
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	
	@JsonBackReference //TIRAR O ERRO DOS OBJETOS BUSCADOS DA ASSOCIACAO ENTRE PRODUTO E CATEGORIA, OMITE A LISTA DE CATEGORIAS A CADA PRODUTO, JÁ QUE JA EXECUTOU UMA VEZ
	
	/*MAPEAMENTO DAS RELACOES ENTRE AS TABELAS PRODUTO E CATEGORIA, COMO SAO N PARA N, CRIAR UMA TERCEIRA TABELA COM
	  OS CODIGOS IDS DAS 2 TABELAS	
	*/
	@ManyToMany
	@JoinTable( name = "PRODUTO_CATEGORIA",
				joinColumns = @JoinColumn(name = "produto_id"),
				inverseJoinColumns = @JoinColumn(name = "categoria_id")
			  )
	//ASSOCIACAO ENTRE PRODUTO E  CATEGORIA, 1 ou + PRODUTOS PODEM TER VARIAS CATEGORIAS
	private List<Categoria> categorias = new ArrayList<>();
	
	//PROTECAO CONTRA SERIALIZACAO DE JSON CICLICA
		//IGNORAR OS ITENS ASSOCIADOS AO PRODUTO, POIS NAO EH NECESSARIO QUE O PRODUTO SAIBA DOS ITENS DO PEDIDO, JA OS ITENS DO PEDIDO EH NECESSARIO SABER DOS PRODUTOS
	@JsonIgnore
	//ASSOCIACAO ENTRE PRODUTO E ITEMPEDIDO
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	//CONSTUTOR VAZIO
	public Produto() {
	}
	
	//CONSTRUTOR COM ARGUMENTOS (PARAMETROS), MENOS A CATEGORIAS PQ JA FOI INICIALIZADA EM CIMA
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	//IGNORAR OS PEDIDOS AQUI TAMBEM PARA NAO OCORRER A SERIALIZACAO DE JSON CICLICA, TODO METODO GET VAI SER SERIALIZADO
	@JsonIgnore
	//IMPLEMENTACAO DO ACESSO DE PRODUTO E PEDIDO
	public List<Pedido> getPedidos(){
		List<Pedido> lista = new ArrayList<>();//CRIACAO DA LISTA DE PEDIDOS
		
		for(ItemPedido itemPedido : itens) {//PERCORRER OS ITENS DO PEDIDO NA LISTA DE ITENS
			//PARA CADA PEDIDO EXISTENTE NA LISTA DE ITENS, ADICIONAR O PEDIDO ASSOCIADO A ELE NA LISTA
			lista.add(itemPedido.getPedido());
		}
		return lista;
	}
	
	//GETTERS AND SETTERS
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	
	//HASHCODE AND EQUALS
	
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}
