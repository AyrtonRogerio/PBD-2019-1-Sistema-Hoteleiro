/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoEndereco;
import br.com.sistemahoteleiro.dao.IDaoEndereco;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Endereco;

/**
 * @author ayrtons
 *
 */
public class BusinessEndereco extends BusinessGeneric<Endereco> implements IBusinessEndereco{

	private IDaoEndereco daoEndereco;
	
	/**
	 * 
	 */
	public BusinessEndereco() {
		// TODO Auto-generated constructor stub
		daoEndereco = new DaoEndereco();
		init(daoEndereco);
	}
	
	@Override
	public void isValid(Endereco t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
