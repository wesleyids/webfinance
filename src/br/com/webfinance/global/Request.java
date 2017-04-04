package br.com.webfinance.global;

import java.io.Serializable;

import br.com.webfinance.models.Entidade;

public class Request<T extends Entidade> implements Serializable {

	private static final long serialVersionUID = 1L;

	private T entidade;

	private int id;

	public Request(T entidade) {
		this.entidade = entidade;
	}

	public Request(int id) {
		this.id = id;
	}
	
	public Request(int id, T entidade){
		this.id = id;
		this.entidade = entidade;
	}

	public T getEntidade() {
		return entidade;
	}

	public void setEntidade(T entidade) {
		this.entidade = entidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
