package br.ufg.empresa.model;

import java.io.Serializable;
import java.sql.Date;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = -6007123816065785663L;

	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	private Date nascimento;
	private String telefone;

	public Funcionario() {
	}

	public Funcionario(Integer id, String nome, String email, String cpf) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	public boolean isValidoParaCadastro() {
		return id == null && nome != null && email != null && cpf != null;
	}

	public boolean isValidoParaEdicao() {
		return id != null && nome != null && email != null && cpf != null;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
