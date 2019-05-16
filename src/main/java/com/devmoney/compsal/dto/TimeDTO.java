package com.devmoney.compsal.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.devmoney.compsal.domain.Time;
import com.devmoney.compsal.domain.UsuarioNew;

public class TimeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
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
	
	

	
	public TimeDTO() {
		
	}
		
	public TimeDTO(Time obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.genero = obj.getGenero();
		this.goleiro = obj.getGoleiro();
		this.fixo = obj.getFixo();
		this.alaDireita = obj.getAlaDireita();
		this.alaEsquerda = obj.getAlaEsquerda();
		this.pivo = obj.getPivo();
		this.treinador = obj.getTreinador();
		this.massagista = obj.getMassagista();
		this.jogadorReserva1 = obj.getJogadorReserva1();
		this.jogadorReserva2 = obj.getJogadorReserva2();
		this.jogadorReserva3 = obj.getJogadorReserva3();
		this.jogadorReserva4 = obj.getJogadorReserva4();
		this.jogadorReserva5 = obj.getJogadorReserva5();
	
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
