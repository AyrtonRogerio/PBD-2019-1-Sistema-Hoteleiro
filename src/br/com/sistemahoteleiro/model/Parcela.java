/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.math.BigDecimal;

/**
 * @author ayrtons
 *
 */
public class Parcela extends Entidade {

	private BigDecimal valorTotal;
	private BigDecimal valorParcela;
	private int qtd;
	private int qtdPaga;
	
	
	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * @return the valorParcela
	 */
	public BigDecimal getValorParcela() {
		return valorParcela;
	}
	/**
	 * @param valorParcela the valorParcela to set
	 */
	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}
	/**
	 * @return the qtd
	 */
	public int getQtd() {
		return qtd;
	}
	/**
	 * @param qtd the qtd to set
	 */
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	/**
	 * @return the qtdPaga
	 */
	public int getQtdPaga() {
		return qtdPaga;
	}
	/**
	 * @param qtdPaga the qtdPaga to set
	 */
	public void setQtdPaga(int qtdPaga) {
		this.qtdPaga = qtdPaga;
	}
	
	
}
