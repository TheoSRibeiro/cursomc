package com.theoribeiro.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

//CLASSE DE ASSOCIACAO -- SEM ID PROPRIO

@Entity //MAPEAMENTO DAS INSTANCIAS
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//PROTECAO CONTRA SERIALIZACAO DE JSON CICLICA
	@JsonIgnore // ItemPedidopk NAO VAI SER SERIALIZADO MAS O PEDIDO VAI SER, NAO PRECISA COLOCAR O @JsonMnagedReference LA NA CLASSE PEDIDO, POIS ELA JA VAI SER SERIALIZADA
	
	@EmbeddedId // Id embutido do tipo auxiliar
	//CRIACAO DE CHAVE COMPOSTA CONTENDO O PRODUTO E O PEDIDO
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	//CONSTRUTORES
	public ItemPedido() {
		
	}

	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	//GETTERS AND SETTERS
	
	//PROTECAO CONTRA SERIALIZACAO DE JSON CICLICA
	@JsonIgnore
	//INCLUSAO DO GET PRODUTO E PEDIDO 
	public Pedido getPedido() { //ACESSO AO PEDIDO FORA DA CLASSE ITEMPEDIDO
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
	
}
