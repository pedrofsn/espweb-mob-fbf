package br.ufg.empresa.dto;

import br.ufg.empresa.model.Funcionario;

public class ObjetoFuncionarioDTO extends ErroDTO {

	private Funcionario funcionario;

	public ObjetoFuncionarioDTO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
