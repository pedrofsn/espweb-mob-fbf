package br.ufg.empresa.dto;

import java.util.List;

import br.ufg.empresa.model.Funcionario;

public class ListaFuncionarioDTO extends ErroDTO {

	private int total;
	private List<Funcionario> funcionarios;

	public ListaFuncionarioDTO(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
		this.total = (funcionarios != null) ? funcionarios.size() : 0;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
