/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoSuperUsuario;
import br.com.sistemahoteleiro.dao.IDaoSuperUsuario;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.SuperUsuario;
import br.com.sistemahoteleiro.util.Cryptography;

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
	public void createOrUpdate(SuperUsuario t) throws BusinessException {
		// TODO Auto-generated method stub
		t.setSenha(Cryptography.cryptography(t.getSenha().getBytes()));
		super.createOrUpdate(t);
	}



	@Override
	public void isValid(SuperUsuario t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
