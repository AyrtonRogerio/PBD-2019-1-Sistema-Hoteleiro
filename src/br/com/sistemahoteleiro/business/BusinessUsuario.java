/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoUsuario;
import br.com.sistemahoteleiro.dao.IDaoUsuario;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Usuario;

/**
 * @author ayrton
 *
 */
public class BusinessUsuario extends BusinessGeneric<Usuario> implements IBusinessUsuario {

	private IDaoUsuario daoUsuario;
	
	/**
	 * 
	 */
	public BusinessUsuario() {
		// TODO Auto-generated constructor stub
		daoUsuario = new DaoUsuario();
		init(daoUsuario);
	}
	
	@Override
	public void isValid(Usuario t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
