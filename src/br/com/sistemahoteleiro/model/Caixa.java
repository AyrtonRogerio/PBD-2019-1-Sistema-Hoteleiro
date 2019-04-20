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
	private BigDecimal entrada;
	
	@Column
	private BigDecimal saida;
	
	@Column
	private BigDecimal saldo;
	
	/**
	 * @return the entrada
	 */
	public BigDecimal getEntrada() {
		return entrada;
	}
	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(BigDecimal entrada) {
		this.entrada = entrada;
	}
	/**
	 * @return the saida
	 */
	public BigDecimal getSaida() {
		return saida;
	}
	/**
	 * @param saida the saida to set
	 */
	public void setSaida(BigDecimal saida) {
		this.saida = saida;
	}
	/**
	 * @return the saldo
	 */
	public BigDecimal getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	/**
	 * @return the parcelas
	 */
	
	
}
