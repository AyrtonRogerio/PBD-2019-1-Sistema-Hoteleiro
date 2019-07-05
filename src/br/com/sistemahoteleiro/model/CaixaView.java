/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

/**
 * @author ayrton
 *
 */
@Immutable
@Entity
@Subselect("SELECT * FROM caixa")
public class CaixaView {

	@Id
	private Integer id;
	
	@Column
	private double entrada;
	
	@Column
	private double saida;
	
	@Column
	private double saldo;
	
	@Column(name = "data_abertura")
	private LocalDate dataAbertura;
	
	@Column(name = "data_fechamento")
	private LocalDate dataFechamento;
	
	@Column
	private boolean status;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the entrada
	 */
	public double getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the saida
	 */
	public double getSaida() {
		return saida;
	}

	/**
	 * @param saida the saida to set
	 */
	public void setSaida(double saida) {
		this.saida = saida;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the dataAbertura
	 */
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	/**
	 * @param dataAbertura the dataAbertura to set
	 */
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	/**
	 * @return the dataFechamento
	 */
	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	/**
	 * @param dataFechamento the dataFechamento to set
	 */
	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
