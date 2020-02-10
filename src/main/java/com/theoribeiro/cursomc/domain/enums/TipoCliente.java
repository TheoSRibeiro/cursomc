package com.theoribeiro.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	//CONSTRUTOR ENUMERADO EH PRIVATE
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	//ENUMERADO SO USA O GET
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		//PERCORRER TODAS AS POSSIBILIDADES DE TIPOCLIENTE ENUMERADO (PESSOAFISICA E PESSOAJURIDICA)
		for(TipoCliente cli : TipoCliente.values()) {
			if(cod.equals(cli.getCod())) {
				return cli;
			}
		}
		//SE NAO ACHOU... LANCA EXCESSAO
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
	
}
