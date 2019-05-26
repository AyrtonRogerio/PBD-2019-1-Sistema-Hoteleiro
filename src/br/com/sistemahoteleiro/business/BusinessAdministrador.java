/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoAdministrador;
import br.com.sistemahoteleiro.dao.IDaoAdministrador;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Administrador;
import br.com.sistemahoteleiro.util.Cryptography;

/**
 * @author ayrtons
 *
 */
public class BusinessAdministrador extends BusinessGeneric<Administrador> implements IBusinessAdministrador {

	private IDaoAdministrador daoAdministrador;
	
	/**
	 * 
	 */
	public BusinessAdministrador() {
		// TODO Auto-generated constructor stub
		daoAdministrador = new DaoAdministrador();
		init(daoAdministrador);
	}
	
	@Override
	public void createOrUpdate(Administrador t) throws BusinessException {
		// TODO Auto-generated method stub
		t.setSenha(Cryptography.cryptography(t.getSenha().getBytes()));
		super.createOrUpdate(t);
	}



	@Override
	public void isValid(Administrador t) throws ValidationException {
		// TODO Auto-generated method stub
		//if(t.getLogin().isEmpty()) {
			
		//}
	}

}
