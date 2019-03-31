package com.devmoney.compsal.domain.enums;

public enum PerfilUsuario {
	
	COMUN(1, "ROLE_COMUN"),
	TECNICO(2, "ROLE_TECNICO"),
	ANOTADOR(3, "ROLE_ANOTADOR"),
	GESTOR(4, "ROLE_GESTOR");
	
	
	private int codigo;
	private String descricao;
	
	private PerfilUsuario(int codigo, String descricao) {
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
	public static PerfilUsuario toEnum(Integer codigo) {

		if (codigo == null) {
			return null;
		}

		// Esse 'for' percorre todos os valores possíveis deste Enum 'TipoCliente'
		for (PerfilUsuario x : PerfilUsuario.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id Inválido: " + codigo);
	}
	
}
