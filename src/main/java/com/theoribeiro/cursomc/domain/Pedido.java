package com.theoribeiro.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity //MAPEAMENTO RELACIONAL
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //ID GERADO AUTOMATICAMENTE
	private Integer id;
	
	//FORMATAR A DATA NO BD PARA NAO APARECER EM ms E SIM NA DATA
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;
	
	//ASSOCIACOES
	
	//PROTECAO CONTRA SERIALIZACAO DE JSON CICLICA
	//@JsonManagedReference //O PEDIDO DO PAGAMENTO VAI SER SERIALIZADO MAS O PAGAMENTO NAO
	//@JsonManagedReference NAO VAI SER MAIS UTILIZADO, TODOS OS @JsonBackReference FOI TROCADO POR @JsonIgnore,
	
	//MAPEAR O PAGAMENTO COM PEDIDO COM RELACIONAMENTO DE 1 PARA 1
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido") //Casdade PARA NAO GERAR ERRO DE TRANSI-END AL SALVAR UM PEDIDO E PAGAMENTO
	private Pagamento pagamento;
	
	//PERMITIR A SERIALIZACAO DO CLIENTE DE UM PEDIDO PARA NAO DAR ERRO DE SERIALIZACAO JSON CICLICA
	//@JsonManagedReference
	//@JsonManagedReference NAO VAI SER MAIS UTILIZADO, TODOS OS @JsonBackReference FOI TROCADO POR @JsonIgnore,
	
	//MAPEAR PEDIDO COM CLIENTE - N para 1
	@ManyToOne
	@JoinColumn(name = "cliente_id") //NOME NA COLUNA NO BD (CHAVE ESTRANGEIRA)
	private Cliente cliente;
	
	//MAPEAMENTO DE PEDIDO E ENDERECO - N PARA 1
	@ManyToOne
	@JoinColumn(name="endereco_de_entrega_id") //NOME NA COLUNA NO BD (CHAVE ESTRANGEIRA)
	private Endereco enderecoDeEntrega;
	
	//MAPEAMETO ENTRE PEDIDO E ITEMPEDIDO
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>(); //SET PARA GARANTIR QUE NAO VAI TER ITEM REPETIDO NO MESMO PEDIDO
	
	//CONSTRUTORES
	public Pedido() {
		
	}
	
	public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}



	//GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
