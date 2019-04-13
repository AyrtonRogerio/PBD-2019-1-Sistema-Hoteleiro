/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ayrtons
 *
 */
public class Caixa extends Entidade {

	private BigDecimal entrada;
	private BigDecimal saida;
	private BigDecimal saldo;
	private List<Parcela> parcelas;
	
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
	public List<Parcela> getParcelas() {
		return parcelas;
	}
	/**
	 * @param parcelas the parcelas to set
	 */
	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}
	
	
}
