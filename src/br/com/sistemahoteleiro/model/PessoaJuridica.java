/**
 * 
 */
package br.com.sistemahoteleiro.model;

/**
 * @author ayrtons
 *
 */
public class PessoaJuridica extends Cliente {

	private String razaoSocial;
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
