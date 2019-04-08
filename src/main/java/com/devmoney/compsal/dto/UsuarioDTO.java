package com.devmoney.compsal.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.devmoney.compsal.domain.Arbitro;
import com.devmoney.compsal.domain.UsuarioNew;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento do Nome é Obrigatório!")
	@Length(min=5, max=50, message="O tamanho deve estar entre 5 e 50 caracteres!")
	private String nome;
	private String cpf;
	private String apelido;
	
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(UsuarioNew obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

		
}
