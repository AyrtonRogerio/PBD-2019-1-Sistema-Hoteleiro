/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoAluga;
import br.com.sistemahoteleiro.dao.IDaoAluga;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Aluga;

/**
 * @author ayrtons
 *
 */
public class BusinessAluga extends BusinessGeneric<Aluga> implements IBusinessAluga{

	private IDaoAluga daoAluga;
	
	/**
	 * 
	 */
	public BusinessAluga() {
		// TODO Auto-generated constructor stub
		daoAluga = new DaoAluga();
		init(daoAluga);
	}
	
	
	@Override
	public void isValid(Aluga t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
