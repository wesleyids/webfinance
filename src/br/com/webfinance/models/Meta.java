package br.com.webfinance.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Meta extends Entidade {

	public Meta(){}
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private String descricao;
	private double valorMeta;
	private double valorInicialDisponivel; // simplicar nome
	private double valorDespositadoMesCorrente; // simplicar nome

	// Tempo em meses que deseja realizar o sonho
	private int tempo;

	// data de deposito/transferencia/etc
	@Temporal(TemporalType.DATE)
	private Date dataDeposito;

	@ManyToOne
	private Usuario usuario;
	
	// se tiver id, é a referencia do pai
	//private int childId;

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

	public double getValorMeta() {
		return valorMeta;
	}

	public void setValorMeta(double valorMeta) {
		this.valorMeta = valorMeta;
	}

	public double getValorInicialDisponivel() {
		return valorInicialDisponivel;
	}

	public void setValorInicialDisponivel(double valorInicialDisponivel) {
		this.valorInicialDisponivel = valorInicialDisponivel;
	}

	public double getValorDespositadoMesCorrente() {
		return valorDespositadoMesCorrente;
	}

	public void setValorDespositadoMesCorrente(
			double valorDespositadoMesCorrente) {
		this.valorDespositadoMesCorrente = valorDespositadoMesCorrente;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public Date getDataDeposito() {
		return dataDeposito;
	}

	public void setDataDeposito(Date dataDeposito) {
		this.dataDeposito = dataDeposito;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
