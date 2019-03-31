package com.devmoney.compsal.domain.enums;

public enum FuncaoArbitro {
	
	PRINCIPAL(10, "ROLE_PRINCIPAL"),
	AUXILIAR(11, "ROLE_AUXILIAR");
	
	private int codigo;
	private String descricao;
	
	private FuncaoArbitro(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	/*
	 * Metodo que recebe um código e retorna um objeto 'Perfil'
	 * instanciado.(Retorna baseado no código passado).
	 */
	public static FuncaoArbitro toEnum(Integer codigo) {

		if (codigo == null) {
			return null;
		}

		// Esse 'for' percorre todos os valores possíveis deste Enum 'TipoCliente'
		for (FuncaoArbitro x : FuncaoArbitro.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id Inválido: " + codigo);
	}
	
}
