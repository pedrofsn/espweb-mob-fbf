package br.ufg.empresa.dto;

import java.io.Serializable;

import br.ufg.empresa.model.Erro;

public class ErroDTO implements Serializable {

	private Erro erro;

	public ErroDTO() {

	}

	public ErroDTO(Erro erro) {
		this.erro = erro;
	}

	public Erro getErro() {
		return erro;
	}

	public void setErro(Erro erro) {
		this.erro = erro;
	}

}
