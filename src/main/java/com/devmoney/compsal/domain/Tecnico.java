package com.devmoney.compsal.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.devmoney.compsal.domain.enums.PerfilUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tecnico extends Usuario {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Equipe equipe;
	
	public Tecnico() {
	}

	public Tecnico(Integer id, String nome, String email, String telefone, PerfilUsuario perfil) {
		super(id, nome, email, telefone, perfil);
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
}
