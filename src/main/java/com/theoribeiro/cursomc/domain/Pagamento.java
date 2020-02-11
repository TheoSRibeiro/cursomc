package com.theoribeiro.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.theoribeiro.cursomc.domain.enums.EstadoPagamento;

@Entity //MAPEAMENTO OBJETO RELACIONAL
@Inheritance(strategy = InheritanceType.JOINED) //MAPEAR AS SUBCLASSES(HERANCA)
public abstract class Pagamento implements Serializable{ //ABSTRACT PARA NAO INSTANCIAR OS ATRIBUTOS DO TIPO PAGAMENTO, SOMENTE PODERA INSTANCIAR NAS SUBCLASSES
	private static final long serialVersionUID = 1L;
	
	//ATRIBUTOS
	@Id //COMO A ASSOCIACAO EH DE 1 PARA 1, NAO COLOCA O @GeneratedValue, POIS O ID DE PAGAMENTO EH O MESMO DE PEDIDO CORRESPONDENTE A ESSE PAGAMENTO
	private Integer id;
	private Integer estado; //MUDA PARA INTEGER PARA ARMAZENAR UM NUMERO INTEIRO NO BD
	
	//PROTECAO CONTRA SERIALIZACAO DE JSON CICLICA
	@JsonBackReference //NAO PERMITE A SERIALIZACAO DO PAGAMENTO, SOMENTE DO PEDIDO
	//ASSOCIACAO
	@OneToOne
	@JoinColumn(name = "pedido_id") //CAMPO NO BD QUE MAPEIA O PEDIDO EH pedido_id
	@MapsId //MAPEAR O MESMO ID DE PEDIDO NO PAGAMENTO (id DE PAGAMENTO = id DE PEDIDO)
	private Pedido pedido;
	
	//CONSTRUTORES
	public Pagamento() {
		
	}

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}

	//GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado); //CAPTURAR NUMERO INTEIRO
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod(); //ARMAZENAR NUMERO INTEIRO NO BANCO
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
}
