package br.com.webfinance.util;

public class Status {

	private String status;

	private String mensagem;

	public Status(String status, String mensagem) {
		this.mensagem = mensagem;
		this.status = status;
	}

	public Status() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
