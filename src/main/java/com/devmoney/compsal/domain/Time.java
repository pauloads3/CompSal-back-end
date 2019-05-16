package com.devmoney.compsal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Time implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String genero;
	private Integer goleiro;
	private Integer fixo;
	private Integer alaDireita;
	private Integer alaEsquerda;
	private Integer pivo;
	private Integer treinador;
	private Integer massagista;
	private Integer jogadorReserva1;
	private Integer jogadorReserva2;
	private Integer jogadorReserva3;
	private Integer jogadorReserva4;
	private Integer jogadorReserva5;
	
	public Time() {
		
	}
	
	public Time(Integer id, 
			String nome, 
			String genero, 
			Integer goleiro, 
			Integer fixo, 
			Integer alaDireita, 
			Integer alaEsquerda,
			Integer pivo,
			Integer treinador,
			Integer massagista,
			Integer jogadorReserva1,
			Integer jogadorReserva2,
			Integer jogadorReserva3,
			Integer jogadorReserva4,
			Integer jogadorReserva5
			
			) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.goleiro = goleiro;
		this.fixo = fixo;
		this.alaDireita = alaDireita;
		this.alaEsquerda =alaEsquerda;
		this.pivo = pivo;
		this.treinador = treinador;
		this.massagista = massagista;
		this.jogadorReserva1 = jogadorReserva1;
		this.jogadorReserva2 = jogadorReserva2;
		this.jogadorReserva3 = jogadorReserva3;
		this.jogadorReserva4 = jogadorReserva4;
		this.jogadorReserva5 = jogadorReserva5;
	
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getGoleiro() {
		return goleiro;
	}

	public void setGoleiro(Integer goleiro) {
		this.goleiro = goleiro;
	}

	public Integer getFixo() {
		return fixo;
	}

	public void setFixo(Integer fixo) {
		this.fixo = fixo;
	}

	public Integer getAlaDireita() {
		return alaDireita;
	}

	public void setAlaDireita(Integer alaDireita) {
		this.alaDireita = alaDireita;
	}

	public Integer getAlaEsquerda() {
		return alaEsquerda;
	}

	public void setAlaEsquerda(Integer alaEsquerda) {
		this.alaEsquerda = alaEsquerda;
	}

	public Integer getPivo() {
		return pivo;
	}

	public void setPivo(Integer pivo) {
		this.pivo = pivo;
	}

	public Integer getTreinador() {
		return treinador;
	}

	public void setTreinador(Integer treinador) {
		this.treinador = treinador;
	}

	public Integer getMassagista() {
		return massagista;
	}

	public void setMassagista(Integer massagista) {
		this.massagista = massagista;
	}

	public Integer getJogadorReserva1() {
		return jogadorReserva1;
	}

	public void setJogadorReserva1(Integer jogadorReserva1) {
		this.jogadorReserva1 = jogadorReserva1;
	}

	public Integer getJogadorReserva2() {
		return jogadorReserva2;
	}

	public void setJogadorReserva2(Integer jogadorReserva2) {
		this.jogadorReserva2 = jogadorReserva2;
	}

	public Integer getJogadorReserva3() {
		return jogadorReserva3;
	}

	public void setJogadorReserva3(Integer jogadorReserva3) {
		this.jogadorReserva3 = jogadorReserva3;
	}

	public Integer getJogadorReserva4() {
		return jogadorReserva4;
	}

	public void setJogadorReserva4(Integer jogadorReserva4) {
		this.jogadorReserva4 = jogadorReserva4;
	}

	public Integer getJogadorReserva5() {
		return jogadorReserva5;
	}

	public void setJogadorReserva5(Integer jogadorReserva5) {
		this.jogadorReserva5 = jogadorReserva5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
