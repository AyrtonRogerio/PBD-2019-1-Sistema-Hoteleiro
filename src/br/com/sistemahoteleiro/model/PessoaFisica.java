/**
 * 
 */
package br.com.sistemahoteleiro.model;

/**
 * @author ayrtons
 *
 */
public class PessoaFisica extends Cliente {

	private String rg;
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
