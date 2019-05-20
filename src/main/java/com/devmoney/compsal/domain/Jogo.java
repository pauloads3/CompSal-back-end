package com.devmoney.compsal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String genero;
	private String timeA;
	private String timeB;
	private Integer arbitroPrincipal;
	private Integer arbitroAuxiliar;
	private Integer anotador;
	private String dataJogo;
	private String horario;
	private String localJogo;

	public Jogo() {

	}

	public Jogo(Integer id, String genero, String timeA, String timeB, Integer arbitroPrincipal,
			Integer arbitroAuxiliar, Integer anotador, String dataJogo, String horario, String localJogo) {
		this.id = id;
		this.genero = genero;
		this.timeA = timeA;
		this.timeB = timeB;
		this.arbitroPrincipal = arbitroPrincipal;
		this.arbitroAuxiliar = arbitroAuxiliar;
		this.anotador = anotador;
		this.dataJogo = dataJogo;
		this.horario = horario;
		this.localJogo = localJogo;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTimeA() {
		return timeA;
	}

	public void setTimeA(String timeA) {
		this.timeA = timeA;
	}

	public String getTimeB() {
		return timeB;
	}

	public void setTimeB(String timeB) {
		this.timeB = timeB;
	}

	public Integer getArbitroPrincipal() {
		return arbitroPrincipal;
	}

	public void setArbitroPrincipal(Integer arbitroPrincipal) {
		this.arbitroPrincipal = arbitroPrincipal;
	}

	public Integer getArbitroAuxiliar() {
		return arbitroAuxiliar;
	}

	public void setArbitroAuxiliar(Integer arbitroAuxiliar) {
		this.arbitroAuxiliar = arbitroAuxiliar;
	}

	public Integer getAnotador() {
		return anotador;
	}

	public void setAnotador(Integer anotador) {
		this.anotador = anotador;
	}

	public String getDataJogo() {
		return dataJogo;
	}

	public void setDataJogo(String dataJogo) {
		this.dataJogo = dataJogo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getLocalJogo() {
		return localJogo;
	}

	public void setLocalJogo(String localJogo) {
		this.localJogo = localJogo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
