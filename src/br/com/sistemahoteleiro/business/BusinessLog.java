/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoLog;
import br.com.sistemahoteleiro.dao.IDaoLog;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Log;

/**
 * @author ayrtons
 *
 */
public class BusinessLog extends BusinessGeneric<Log> implements IBusinessLog{

	private IDaoLog daoLog;
	
	/**
	 * 
	 */
	public BusinessLog() {
		// TODO Auto-generated constructor stub
		daoLog = new DaoLog();
		init(daoLog);
	}
	
	
	@Override
	public void isValid(Log t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
