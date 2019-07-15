/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Log implements Serializable{


	@Id
	@Column(columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String autor;
	
	@Column
	private String tabela;
	
	@Column
	private String alteracao;
	
	
	@Column
	private LocalDate data;
	
	private static final long serialVersionUID = 1L;
	
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
	
	
}
