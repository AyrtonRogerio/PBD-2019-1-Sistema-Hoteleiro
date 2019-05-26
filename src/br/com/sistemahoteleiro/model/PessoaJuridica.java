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
@Table(name = "pessoa_juridica")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = PessoaJuridica.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class PessoaJuridica extends Cliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "pessoa_juridica_sequence";

	@Column(name = "razao_social", length = 50)
	private String razaoSocial;
	
	@Column(nullable = false, unique = true)
	private String cnpj;
	
	
	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}
	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
