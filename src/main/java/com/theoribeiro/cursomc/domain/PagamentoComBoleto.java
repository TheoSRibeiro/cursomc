package com.theoribeiro.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.theoribeiro.cursomc.domain.enums.EstadoPagamento;

//CLASSE QUE ESTENDE DE PAGAMENTO
@Entity //MAPEAMENTO RELACIONAL
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	//CONSTRUTORES
	public PagamentoComBoleto() {
		
	}
	
	//CONSTRUTOR DA SUPERCLASSE
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}


	//GETTERS AND SETTERS
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
}
