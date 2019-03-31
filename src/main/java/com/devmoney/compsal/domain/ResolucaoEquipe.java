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
public class ResolucaoEquipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer faltasAcumulativas1Periodo;
	private Integer faltasAcumulativas2Periodo;
	private Integer pedidosDeTempo1Periodo;
	private Integer pedidosDeTempo2Periodo;
	
	private Integer gols;
	private String tecnico;
	private String jogadorCapitao;
	
	@ManyToOne
	@JoinColumn(name="Equipe_Id")
	private Equipe equipe;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="Sumula_Id")
	private Sumula sumula;
	
	public ResolucaoEquipe() {
	}

	public ResolucaoEquipe(Integer id, Integer faltasAcumulativas1Periodo, Integer faltasAcumulativas2Periodo,
			Integer pedidosDeTempo1Periodo, Integer pedidosDeTempo2Periodo, Integer gols,
			Equipe equipe) {
		super();
		this.id = id;
		this.faltasAcumulativas1Periodo = faltasAcumulativas1Periodo;
		this.faltasAcumulativas2Periodo = faltasAcumulativas2Periodo;
		this.pedidosDeTempo1Periodo = pedidosDeTempo1Periodo;
		this.pedidosDeTempo2Periodo = pedidosDeTempo2Periodo;
		this.gols = gols;
		this.equipe = equipe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFaltasAcumulativas1Periodo() {
		return faltasAcumulativas1Periodo;
	}

	public void setFaltasAcumulativas1Periodo(Integer faltasAcumulativas1Periodo) {
		this.faltasAcumulativas1Periodo = faltasAcumulativas1Periodo;
	}

	public Integer getFaltasAcumulativas2Periodo() {
		return faltasAcumulativas2Periodo;
	}

	public void setFaltasAcumulativas2Periodo(Integer faltasAcumulativas2Periodo) {
		this.faltasAcumulativas2Periodo = faltasAcumulativas2Periodo;
	}

	public Integer getPedidosDeTempo1Periodo() {
		return pedidosDeTempo1Periodo;
	}

	public void setPedidosDeTempo1Periodo(Integer pedidosDeTempo1Periodo) {
		this.pedidosDeTempo1Periodo = pedidosDeTempo1Periodo;
	}

	public Integer getPedidosDeTempo2Periodo() {
		return pedidosDeTempo2Periodo;
	}

	public void setPedidosDeTempo2Periodo(Integer pedidosDeTempo2Periodo) {
		this.pedidosDeTempo2Periodo = pedidosDeTempo2Periodo;
	}

	public Integer getGols() {
		return gols;
	}

	public void setGols(Integer gols) {
		this.gols = gols;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getJogadorCapitao() {
		return jogadorCapitao;
	}

	public void setJogadorCapitao(String jogadorCapitao) {
		this.jogadorCapitao = jogadorCapitao;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Sumula getSumula() {
		return sumula;
	}

	public void setSumula(Sumula sumula) {
		this.sumula = sumula;
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
		ResolucaoEquipe other = (ResolucaoEquipe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}