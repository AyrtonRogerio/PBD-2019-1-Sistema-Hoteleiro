/**
 * 
 */
package br.com.sistemahoteleiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author ayrtons
 *
 */
@Entity
@Table(name = "pessoa_fisica")
@SequenceGenerator(name =  Entidade.SEQUENCE_ENTIDADE, sequenceName = PessoaFisica.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class PessoaFisica extends Cliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "pessoa_fisica_sequence";

	@Column(length = 12, nullable = false, unique = true)
	private String rg;
	
	@Column(length = 14, nullable = false, unique = true)
	private String cpf;
	
	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}
	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
