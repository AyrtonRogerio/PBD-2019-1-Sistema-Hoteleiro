/**
 * 
 */
package br.com.sistemahoteleiro.dao;


import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Usuario;

/**
 * @author ayrton
 *
 */
public interface IDaoUsuario extends IDaoGeneric<Usuario> {

	public Usuario searchLoginUsuario(String login, String senha) throws DaoException;
	
	public List<Usuario> searchBuscarTodos(String string) throws DaoException;
	
}
