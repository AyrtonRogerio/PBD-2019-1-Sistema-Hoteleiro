/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author ayrtons
 *
 */
@Entity
@Table(name = "caixa")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Caixa.SEQUENCE_ENTIDADE, initialValue = 1,allocationSize = 1)
public class Caixa extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "caixa_sequence";
	
	@Column
	private double entrada;
	
	@Column
	private double saida;
	
	@Column
	private double saldo;
	
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
	 * @return the parcelas
	 */
	
	
}
