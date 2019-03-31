package com.devmoney.compsal.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import com.devmoney.compsal.domain.Sumula;

public class SumulaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	@NotEmpty(message="Preenchimento do Nome é Obrigatório!")
	@Length(min=5, max=50, message="O tamanho deve estar entre 5 e 50 caracteres!")
	private String nomeCompeticao;
	private String jogoNumero;
	
	private String nomeEquipeA;
	private String nomeEquipeB;
	private String placarEquipeA;
	private String placarEquipeB;
	
	private String categoria;
	private String ginasio;
	private String cidade;
	
	public SumulaDTO(Sumula obj) {
		this.id = obj.getId();
		this.nomeCompeticao = obj.getNomeCompeticao();
		this.jogoNumero = obj.getJogoNumero();
		this.nomeEquipeA = obj.getNomeEquipeA();
		this.nomeEquipeB = obj.getNomeEquipeB();
		this.placarEquipeA = obj.getPlacarEquipeA();
		this.placarEquipeB = obj.getPlacarEquipeB();
		this.categoria = obj.getCategoria();
		this.ginasio = obj.getGinasio();
		this.cidade = obj.getCidade();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNomeCompeticao() {
		return nomeCompeticao;
	}

	public void setNomeCompeticao(String nomeCompeticao) {
		this.nomeCompeticao = nomeCompeticao;
	}

	public String getJogoNumero() {
		return jogoNumero;
	}

	public void setJogoNumero(String jogoNumero) {
		this.jogoNumero = jogoNumero;
	}

	public String getNomeEquipeA() {
		return nomeEquipeA;
	}

	public void setNomeEquipeA(String nomeEquipeA) {
		this.nomeEquipeA = nomeEquipeA;
	}

	public String getNomeEquipeB() {
		return nomeEquipeB;
	}

	public void setNomeEquipeB(String nomeEquipeB) {
		this.nomeEquipeB = nomeEquipeB;
	}

	public String getPlacarEquipeA() {
		return placarEquipeA;
	}

	public void setPlacarEquipeA(String placarEquipeA) {
		this.placarEquipeA = placarEquipeA;
	}

	public String getPlacarEquipeB() {
		return placarEquipeB;
	}

	public void setPlacarEquipeB(String placarEquipeB) {
		this.placarEquipeB = placarEquipeB;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getGinasio() {
		return ginasio;
	}

	public void setGinasio(String ginasio) {
		this.ginasio = ginasio;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	

}
