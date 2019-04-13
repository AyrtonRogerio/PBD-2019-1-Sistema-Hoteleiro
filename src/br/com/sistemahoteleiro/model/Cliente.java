/**
 * 
 */
package br.com.sistemahoteleiro.model;

/**
 * @author ayrtons
 *
 */
public abstract class Cliente extends Entidade{

	private String nome;
	private Contato contato;
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
