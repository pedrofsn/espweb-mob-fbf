package br.ufg.empresa.dto;

import java.util.List;

import br.ufg.empresa.model.Funcionario;

public class ListaFuncionarioDTO extends ErroDTO {

	private List<Funcionario> funcionarios;

	public ListaFuncionarioDTO(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
