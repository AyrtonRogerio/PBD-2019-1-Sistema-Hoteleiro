/**
 * 
 */
package br.com.sistemahoteleiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.cfg.annotations.Nullability;

import br.com.sistemahoteleiro.enuns.TipoEstadoUF;

/**
 * @author ayrtons
 *
 */
@Entity
@Table(name = "endereco")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Endereco.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Endereco extends Entidade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "endereco_sequence";

	@Column(length = 120, nullable = false)
	private String logradouro;
	
	@Column(length = 20, nullable = false)
	private String numero;
	
	@Column(length = 40, nullable = false)
	private String bairro;
	
	@Column(length = 9, nullable = false)
	private String cep;
	
	@Column(length = 50, nullable = false)
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	private TipoEstadoUF uf;
	
	
	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}
	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * @return the uf
	 */
	public TipoEstadoUF getUf() {
		return uf;
	}
	/**
	 * @param uf the uf to set
	 */
	public void setUf(TipoEstadoUF uf) {
		this.uf = uf;
	}
	
}
