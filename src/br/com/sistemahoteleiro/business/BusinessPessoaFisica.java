/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoPessoaFisica;
import br.com.sistemahoteleiro.dao.IDaoPessoaFisica;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.PessoaFisica;

/**
 * @author ayrtons
 *
 */
public class BusinessPessoaFisica extends BusinessGeneric<PessoaFisica> implements IBusinessPessoaFisica {

	private IDaoPessoaFisica daoPessoaFisica;
	
	/**
	 * 
	 */
	public BusinessPessoaFisica() {
		// TODO Auto-generated constructor stub
		daoPessoaFisica = new DaoPessoaFisica();
		init(daoPessoaFisica);
	}
	
	@Override
	public void isValid(PessoaFisica t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
