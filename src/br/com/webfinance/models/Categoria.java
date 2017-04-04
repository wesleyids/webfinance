package br.com.webfinance.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categoria extends Entidade {

	private static final long serialVersionUID = 1L;

	public Categoria(){}
	
	private String nome;

	@ManyToOne
	private Usuario usuario;

	@OneToMany(mappedBy = "categoria")
	private List<Despesa> despesa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Despesa> getDespesa() {
		return despesa;
	}

	public void setDespesa(List<Despesa> despesa) {
		this.despesa = despesa;
	}

}
