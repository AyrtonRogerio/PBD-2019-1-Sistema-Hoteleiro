/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author ayrtons
 *
 */
public class Log extends Entidade{


	private String autor;
	private String tabela;
	private String alteracao;
	private LocalDate data;
	private LocalTime hora;
	
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
	 * @return the hora
	 */
	public LocalTime getHora() {
		return hora;
	}
	/**
	 * @param hora the hora to set
	 */
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
}
