package com.cadastro.jrapi.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.dom4j.tree.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="login")

public class Login extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotBlank
	private String usuario;
	
	@NotBlank
	@NotNull
	@JsonIgnore
	private String senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
