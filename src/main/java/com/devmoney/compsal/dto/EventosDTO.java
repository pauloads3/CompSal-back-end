package com.devmoney.compsal.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.devmoney.compsal.domain.Eventos;

public class EventosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String tipo;
	private Integer idJogador;
	private String nomeJogador;
	private String nomeTime;
	private Integer idJogo;
	private Integer tempo;
	
	public EventosDTO() {
		//this.validaData();
	}
	
	public EventosDTO( Eventos obj) {
		this.id = obj.getId();
		this.tipo = obj.getTipo();
		this.idJogador = obj.getIdJogador();
		this.nomeJogador = obj.getNomeJogador();
		this.nomeTime = obj.getNomeTime();
		this.idJogo = obj.getIdJogo();
		this.tempo = obj.getTempo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(Integer idJogador) {
		this.idJogador = idJogador;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

	public Integer getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(Integer idJogo) {
		this.idJogo = idJogo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}	
}
