package com.devmoney.compsal.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.devmoney.compsal.domain.Jogo;
import com.devmoney.compsal.domain.Time;
import com.devmoney.compsal.domain.UsuarioNew;

public class JogoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private Integer id;
	
	@NotEmpty(message="Preenchimento do Gênero é Obrigatório!")
	private String genero;
	@NotEmpty(message="Preenchimento do Time A é Obrigatório!")
	private Integer timeA;
	@NotEmpty(message="Preenchimento do Time B é Obrigatório!")
	private Integer timeB;
	@NotEmpty(message="Preenchimento do Árbitro Principal é Obrigatório!")
	private Integer arbitroPrincipal;
	@NotEmpty(message="Preenchimento do Árbitro Auxiliar é Obrigatório!")
	private Integer arbitroAuxiliar;
	@NotEmpty(message="Preenchimento do Anotador é Obrigatório!")
	private Integer anotador;
	@NotEmpty(message="Preenchimento da Data do Jogo é Obrigatório!")
	private String dataJogo;
	@NotEmpty(message="Preenchimento do Horário do Jogo é Obrigatório!")
	private String horario;
	@NotEmpty(message="Preenchimento do Local do Jogo é Obrigatório!")
	private String localJogo;

	public JogoDTO() {

	}

	public JogoDTO(Jogo obj) {
		this.id = obj.getId();
		this.genero = obj.getGenero();
		this.timeA = obj.getTimeA();
		this.timeB = obj.getTimeB();
		this.arbitroPrincipal = obj.getArbitroPrincipal();
		this.arbitroAuxiliar = obj.getArbitroAuxiliar();
		this.anotador = obj.getAnotador();
		this.dataJogo = obj.getDataJogo();
		this.horario = obj.getHorario();
		this.localJogo = obj.getLocalJogo();

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

	public Integer getTimeA() {
		return timeA;
	}

	public void setTimeA(Integer timeA) {
		this.timeA = timeA;
	}

	public Integer getTimeB() {
		return timeB;
	}

	public void setTimeB(Integer timeB) {
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
