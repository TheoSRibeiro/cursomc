package com.theoribeiro.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	PARCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
	//CONSTRUTOR
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	//GETTERS SOMENTE
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	//METODO CONVERSAO DE UM INTEIRO PARA EstadoPagamento
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		//PERCORRER TODAS AS POSSIBILIDADES DE EstadoPagamento ENUMERADO (PENDENTE, QUITADO E PARCELADO)
		for(EstadoPagamento ep : EstadoPagamento.values()) {
			if(cod.equals(ep.getCod())) {
				return ep;
			}
		}
		//SE NAO ACHOU... LANCA EXCESSAO
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
	
	

}
