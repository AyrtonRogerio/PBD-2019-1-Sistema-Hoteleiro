/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoPessoaJuridica;
import br.com.sistemahoteleiro.dao.IDaoPessoaJuridica;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.PessoaJuridica;

/**
 * @author ayrtons
 *
 */
public class BusinessPessoaJuridica extends BusinessGeneric<PessoaJuridica> implements IBusinessPessoaJuridica{

	private IDaoPessoaJuridica daoPessoaJuridica;
	
	/**
	 * 
	 */
	public BusinessPessoaJuridica() {
		// TODO Auto-generated constructor stub
		daoPessoaJuridica = new DaoPessoaJuridica();
		init(daoPessoaJuridica);
	}
	
	@Override
	public void isValid(PessoaJuridica t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
