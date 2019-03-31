package com.devmoney.compsal.domain;

import javax.persistence.Entity;

import com.devmoney.compsal.domain.enums.PerfilUsuario;

@Entity
public class Gestor extends Usuario {
	private static final long serialVersionUID = 1L;

	public Gestor() {
	}

	public Gestor(Integer id, String nome, String email, String telefone, PerfilUsuario perfil) {
		super(id, nome, email, telefone, perfil);
	}
	
	
	
}
