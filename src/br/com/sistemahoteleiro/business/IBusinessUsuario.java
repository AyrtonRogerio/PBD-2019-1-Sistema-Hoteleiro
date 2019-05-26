/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.Usuario;

/**
 * @author ayrton
 *
 */
public interface IBusinessUsuario extends IBusinessGeneric<Usuario>{

	public Usuario searchLoginUsuario(String login, String senha) throws BusinessException;
	
	public List<Usuario> searchBuscarTodos(String string) throws BusinessException;
	
}
