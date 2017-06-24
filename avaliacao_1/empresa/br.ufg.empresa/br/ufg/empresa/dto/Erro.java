package br.ufg.empresa.dto;

import java.io.Serializable;

import br.ufg.empresa.exception.IdInexistenteException;

public class Erro implements Serializable {

	private String erro;
	private int codeHttp;

	public Erro(Exception exception) {
		if (exception != null) {
			this.erro = exception.getMessage();

			if (exception instanceof IdInexistenteException) {
				this.codeHttp = 404;
			} else {
				this.codeHttp = 500;
			}
		}
	}

	public int getCodeHttp() {
		return codeHttp;
	}

	public void setCodeHttp(int codeHttp) {
		this.codeHttp = codeHttp;
	}

	public Erro(String erro) {
		this.erro = erro;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}
