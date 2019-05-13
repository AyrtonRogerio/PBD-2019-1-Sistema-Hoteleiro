/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author ayrtons
 *
 */
@Entity
@Table(name = "parcela")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Parcela.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Parcela extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "parcela_sequence";
	
	@Column(name = "valor_total")
	private double valorTotal;
	
	@Column(name = "valor_parcela")
	private double valorParcela;
	
	@Column(name = "qtd")
	private int qtd;
	
	@Column(name = "qtd_paga")
	private int qtdPaga;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "caixa_id")
	private Caixa caixa;
	
	/**
	 * @return the valorTotal
	 */
	public double getValorTotal() {
		return valorTotal;
	}
	
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	/**
	 * @return the valorParcela
	 */
	public double getValorParcela() {
		return valorParcela;
	}
	
	/**
	 * @param valorParcela the valorParcela to set
	 */
	public void setValorParcela(double valorParcela) {
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
	
	/**
	 * @return the caixa
	 */
	public Caixa getCaixa() {
		return caixa;
	}
	
	/**
	 * @param caixa the caixa to set
	 */
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	
	
}
