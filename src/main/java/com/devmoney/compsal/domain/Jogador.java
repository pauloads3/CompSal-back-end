package com.devmoney.compsal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Jogador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String numeroCamisa;
	private Integer qtdGols;
	private Boolean isCapitao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="Equipe_Id")
	private Equipe equipe;
	
	public Jogador() {
	}	

	public Jogador(Integer id, String nome, String numeroCamisa, Integer qtdGols, Equipe idEquipe, Boolean isCapitao) {
		super();
		this.id = id;
		this.nome = nome;
		this.numeroCamisa = numeroCamisa;
		this.qtdGols = qtdGols;
		this.equipe = idEquipe;
		this.isCapitao = isCapitao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroCamisa() {
		return numeroCamisa;
	}

	public void setNumeroCamisa(String numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}

	public Integer getQtdGols() {
		return qtdGols;
	}

	public void setQtdGols(Integer qtdGols) {
		this.qtdGols = qtdGols;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Boolean getIsCapitao() {
		return isCapitao;
	}

	public void setIsCapitao(Boolean isCapitao) {
		this.isCapitao = isCapitao;
	}
	
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
		Jogador other = (Jogador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
