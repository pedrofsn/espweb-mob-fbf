package br.ufg.empresa.exception;

public class IdInexistenteException extends Exception {
	
	public IdInexistenteException(String idString) {
		super(String.format("Nenhum resultado encontrado com o ID '%s'", idString));
	}

}
