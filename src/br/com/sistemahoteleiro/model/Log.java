/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ayrtons
 *
 */
@Entity
@Table(name = "log")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Log.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Log extends Entidade{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "log_sequence";

	@Column
	private String autor;
	
	@Column
	private String tabela;
	
	@Column
	private String alteracao;
	
	
	@Column
	private LocalDate data;
	
	
	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}
	
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	/**
	 * @return the tabela
	 */
	public String getTabela() {
		return tabela;
	}
	
	/**
	 * @param tabela the tabela to set
	 */
	public void setTabela(String tabela) {
		this.tabela = tabela;
	}
	
	/**
	 * @return the alteracao
	 */
	public String getAlteracao() {
		return alteracao;
	}
	
	/**
	 * @param alteracao the alteracao to set
	 */
	public void setAlteracao(String alteracao) {
		this.alteracao = alteracao;
	}
	
	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
}
