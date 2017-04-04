package br.com.webfinance.global;

import java.io.Serializable;

import br.com.webfinance.models.Entidade;

public class Response<T extends Entidade> implements Serializable {

	private static final long serialVersionUID = 1L;

	public Response() {
	}
	
	private Object mensagens;

	private T data;

	//private int pagination;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Object getMensagens() {
		return mensagens;
	}

	public void setMensagens(Object mensagens) {
		this.mensagens = mensagens;
	}
}
