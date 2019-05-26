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
@Table(name = "contato")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Contato.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Contato extends Entidade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "contato_sequence";

	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(length = 14, nullable = false)
	private String telefone;
	
	@Column(length = 14, nullable = false)
	private String celular;
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}
	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
}
