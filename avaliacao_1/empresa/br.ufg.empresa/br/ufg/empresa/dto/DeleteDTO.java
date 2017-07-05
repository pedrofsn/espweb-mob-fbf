package br.ufg.empresa.dto;

import java.io.Serializable;

public class DeleteDTO implements Serializable {
	
	private boolean status;

	public DeleteDTO(boolean status) {
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
