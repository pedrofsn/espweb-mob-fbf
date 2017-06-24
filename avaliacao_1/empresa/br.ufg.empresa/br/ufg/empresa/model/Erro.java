package br.ufg.empresa.model;

import java.io.Serializable;

import br.ufg.empresa.exception.IdInexistenteException;
import br.ufg.empresa.utils.Constantes;

public class Erro implements Serializable {

	private String erro;
	private int codeHttp;

	public Erro(Exception exception) {
		if (exception != null) {
			this.erro = exception.getMessage();

			if (exception instanceof IdInexistenteException) {
				this.codeHttp = Constantes.CODIGO_ERRO_HTTP_NOT_FOUND;
			} else {
				this.codeHttp = Constantes.CODIGO_ERRO_HTTP_INTERNO_NO_SERVIDOR;
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
