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
	private UsuarioNew goleiro;
	private UsuarioNew fixo;
	private UsuarioNew alaDireita;
	private UsuarioNew alaEsquerda;
	private UsuarioNew pivo;
	private UsuarioNew treinador;
	private UsuarioNew massagista;
	private UsuarioNew jogadorReserva1;
	private UsuarioNew jogadorReserva2;
	private UsuarioNew jogadorReserva3;
	private UsuarioNew jogadorReserva4;
	private UsuarioNew jogadorReserva5;
	
	

	
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

	public UsuarioNew getGoleiro() {
		return goleiro;
	}

	public void setGoleiro(UsuarioNew goleiro) {
		this.goleiro = goleiro;
	}

	public UsuarioNew getFixo() {
		return fixo;
	}

	public void setFixo(UsuarioNew fixo) {
		this.fixo = fixo;
	}

	public UsuarioNew getAlaDireita() {
		return alaDireita;
	}

	public void setAlaDireita(UsuarioNew alaDireita) {
		this.alaDireita = alaDireita;
	}

	public UsuarioNew getAlaEsquerda() {
		return alaEsquerda;
	}

	public void setAlaEsquerda(UsuarioNew alaEsquerda) {
		this.alaEsquerda = alaEsquerda;
	}

	public UsuarioNew getPivo() {
		return pivo;
	}

	public void setPivo(UsuarioNew pivo) {
		this.pivo = pivo;
	}

	public UsuarioNew getTreinador() {
		return treinador;
	}

	public void setTreinador(UsuarioNew treinador) {
		this.treinador = treinador;
	}

	public UsuarioNew getMassagista() {
		return massagista;
	}

	public void setMassagista(UsuarioNew massagista) {
		this.massagista = massagista;
	}

	public UsuarioNew getJogadorReserva1() {
		return jogadorReserva1;
	}

	public void setJogadorReserva1(UsuarioNew jogadorReserva1) {
		this.jogadorReserva1 = jogadorReserva1;
	}

	public UsuarioNew getJogadorReserva2() {
		return jogadorReserva2;
	}

	public void setJogadorReserva2(UsuarioNew jogadorReserva2) {
		this.jogadorReserva2 = jogadorReserva2;
	}

	public UsuarioNew getJogadorReserva3() {
		return jogadorReserva3;
	}

	public void setJogadorReserva3(UsuarioNew jogadorReserva3) {
		this.jogadorReserva3 = jogadorReserva3;
	}

	public UsuarioNew getJogadorReserva4() {
		return jogadorReserva4;
	}

	public void setJogadorReserva4(UsuarioNew jogadorReserva4) {
		this.jogadorReserva4 = jogadorReserva4;
	}

	public UsuarioNew getJogadorReserva5() {
		return jogadorReserva5;
	}

	public void setJogadorReserva5(UsuarioNew jogadorReserva5) {
		this.jogadorReserva5 = jogadorReserva5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

		
	
	
}
