/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;
import br.com.sistemahoteleiro.dao.DaoUsuario;
import br.com.sistemahoteleiro.dao.IDaoUsuario;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Usuario;
import br.com.sistemahoteleiro.util.Cryptography;

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
	public void createOrUpdate(Usuario t) throws BusinessException {
		// TODO Auto-generated method stub
		t.setSenha(Cryptography.cryptography(t.getSenha().getBytes()));
		super.createOrUpdate(t);
	}



	@Override
	public void isValid(Usuario t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario searchLoginUsuario(String login, String senha) throws BusinessException {
		
		
		
		try {			
			Usuario	user = daoUsuario.searchLoginUsuario(login, senha);
		
			return user;
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> searchBuscarTodos(String string) throws BusinessException {
		// TODO Auto-generated method stub
		 
		try {
			List<Usuario> users = daoUsuario.searchBuscarTodos(string);
		
			return users;
		
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

}
