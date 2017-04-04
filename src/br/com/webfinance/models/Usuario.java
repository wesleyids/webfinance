package br.com.webfinance.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Usuario extends Entidade {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sobrenome;
	private String email;
	private String password;

	@OneToMany(mappedBy = "usuario")
	private List<Despesa> despesas;
	
	@OneToMany(mappedBy = "usuario")
	private List<Categoria> categorias;
	
	@OneToMany(mappedBy = "usuario")
	private List<Renda> rendas;
	
	@OneToMany(mappedBy = "usuario")
	private List<Meta> metas;

	public Usuario() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Despesa> getDespesas(){
		return despesas;
	}
	
	public void setDespesas(List<Despesa> despesas){
		this.despesas = despesas;
	}
	
	public List<Categoria> getCategorias(){
		return categorias;
	}
	
	public void getCategoria(List<Categoria> categorias){
		this.categorias = categorias;
	}

	public List<Renda> getRendas(){
		return rendas;
	}
	
	public void setRendas(List<Renda> rendas){
		this.rendas = rendas;
	}
	
	public List<Meta> getMetas(){
		return metas;
	}
	
	public void setMetas(List<Meta> metas){
		this.metas = metas;
	}
}
