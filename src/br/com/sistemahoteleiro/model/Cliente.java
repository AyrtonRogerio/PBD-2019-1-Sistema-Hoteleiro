/**
 * 
 */
package br.com.sistemahoteleiro.model;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author ayrtons
 *
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Cliente.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public abstract class Cliente extends Entidade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final String SEQUENCE_ENTIDADE = "cliente_seuqence";
	
	@Column(length = 50, nullable = false, unique = true)
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "contato")
	private Contato contato;
	
	@OneToOne
	@Column(name = "endereco")
	private Endereco endereco;
	
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the contato
	 */
	public Contato getContato() {
		return contato;
	}
	
	/**
	 * @param contato the contato to set
	 */
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
