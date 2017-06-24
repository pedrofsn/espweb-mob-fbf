package br.ufg.empresa.model;

import java.io.Serializable;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = -6007123816065785663L;
	
	private int id;
	private String nome;
	private String cargo;

	public Funcionario() {
	}

	public Funcionario(int id, String nome, String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
