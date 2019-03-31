package com.devmoney.compsal.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.devmoney.compsal.domain.Jogador;

public class JogadorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento do Nome é Obrigatório!")
	@Length(min=5, max=50, message="O tamanho deve estar entre 5 e 50 caracteres!")
	private String nome;

	private String numeroCamisa;
	private Integer qtdGols;
	private Boolean isCapitao;
	
	public JogadorDTO(Jogador obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.numeroCamisa = obj.getNumeroCamisa();
		this.qtdGols = obj.getQtdGols();
		this.isCapitao = obj.getIsCapitao();
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

	public Boolean getIsCapitao() {
		return isCapitao;
	}

	public void setIsCapitao(Boolean isCapitao) {
		this.isCapitao = isCapitao;
	}
	
}
