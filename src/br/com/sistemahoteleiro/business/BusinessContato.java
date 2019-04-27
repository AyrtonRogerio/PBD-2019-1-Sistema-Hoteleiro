/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoContato;
import br.com.sistemahoteleiro.dao.IDaoContato;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Contato;

/**
 * @author ayrtons
 *
 */
public class BusinessContato extends BusinessGeneric<Contato> implements IBusinessContato{

	private IDaoContato daoContato;
	
	/**
	 * 
	 */
	public BusinessContato() {
		// TODO Auto-generated constructor stub
		daoContato = new DaoContato();
		init(daoContato);
	}
	
	
	@Override
	public void isValid(Contato t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
