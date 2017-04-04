package br.com.webfinance.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Despesa extends Entidade {

	private static final long serialVersionUID = 1L;

	public Despesa() {
	}

	private String nome;
	private String descricao;
	private double valor;

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Usuario usuario;

	private String local;

	// pago = 1 ou á pagar = 0
	private int status;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
