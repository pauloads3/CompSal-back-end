package com.devmoney.compsal.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.devmoney.compsal.domain.UsuarioNew;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String vivi;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento do Nome é Obrigatório!")
	@Length(min=5, max=50, message="(Nome) O tamanho deve estar entre 5 e 50 caracteres!")
	private String nome;
	@NotEmpty(message="Preenchimento do CPF é Obrigatório!")
	@Length(min=11, max=14, message="(CPF) O tamanho deve ser de 11 caracteres!")
	private String cpf;
	//@NotEmpty(message="Preenchimento do Apelido é Obrigatório!")
	private String apelido;
	@NotEmpty(message="Selecione seu Sexo é Obrigatório!")
	private String sexo;
	@NotEmpty(message="Preenchimento da Data de Nascimento é Obrigatório!")
	private String dtNascimento;
	@NotEmpty(message="Preenchimento do Telefone é Obrigatório!")
	private String telefone;
	@NotEmpty(message="Preenchimento do E-mail é Obrigatório!")
	private String email;
	@NotEmpty(message="Preenchimento do Endereço é Obrigatório!")
	private String endereco;
	@NotEmpty(message="Preenchimento do Nº do Endereço é Obrigatório!")
	private String numeroEnd;
	@NotEmpty(message="Preenchimento do CEP é Obrigatório!")
	private String cep;
	@NotEmpty(message="Preenchimento do Bairro é Obrigatório!")
	private String bairro;
	@NotEmpty(message="Preenchimento do Município é Obrigatório!")
	private String municipio;
	@NotEmpty(message="Selecione sua UF é Obrigatório!")
	private String uf;
	
	public UsuarioDTO() {
		//this.validaData();
	}
	
	public UsuarioDTO(UsuarioNew obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.apelido = obj.getApelido();
		this.sexo = obj.getSexo();
		this.dtNascimento = obj.getDtNascimento();
		this.telefone = obj.getTelefone();
		this.email = obj.getEmail();
		this.endereco = obj.getEndereco();
		this.numeroEnd = obj.getNumeroEnd();
		this.cep = obj.getCep();
		this.bairro = obj.getBairro();
		this.municipio = obj.getMunicipio();
		this.uf = obj.getUf();
		//this.validaData();
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

	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumeroEnd() {
		return numeroEnd;
	}

	public void setNumeroEnd(String numeroEnd) {
		this.numeroEnd = numeroEnd;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void validaData(){
		 Date data = null;
	    String dataTexto = new String("30/02/2006");
	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    	try {
	    		format.setLenient(false);
	    		data = format.parse(dataTexto);
	    	} catch (ParseException e) {
	    		System.err.println("*** validaData: O fulano escreveu a data Errada");
	    		//JOptionPane.showMessageDialog(null,"O Mané escreveu a data Errada","AVISO",JOptionPane.WARNING_MESSAGE);
	    	}
	}
	
	
		
}
