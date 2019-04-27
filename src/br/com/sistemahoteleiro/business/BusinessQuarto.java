/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoQuarto;
import br.com.sistemahoteleiro.dao.IDaoQuarto;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Quarto;

/**
 * @author ayrtons
 *
 */
public class BusinessQuarto extends BusinessGeneric<Quarto> implements IBusinessQuarto{

	private IDaoQuarto daoQuarto;
	
	/**
	 * 
	 */
	public BusinessQuarto() {
		// TODO Auto-generated constructor stub
		daoQuarto = new DaoQuarto();
		init(daoQuarto);
	}
	
	@Override
	public void isValid(Quarto t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
