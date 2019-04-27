/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoSuperUsuario;
import br.com.sistemahoteleiro.dao.IDaoSuperUsuario;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.SuperUsuario;

/**
 * @author ayrtons
 *
 */
public class BusinessSuperUsuario extends BusinessGeneric<SuperUsuario> implements IBusinessSuperUsuario{

	private IDaoSuperUsuario daoSuperUsuario;
	
	/**
	 * 
	 */
	public BusinessSuperUsuario() {
		// TODO Auto-generated constructor stub
		daoSuperUsuario = new DaoSuperUsuario();
		init(daoSuperUsuario);
	}
	
	
	@Override
	public void isValid(SuperUsuario t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
