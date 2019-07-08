/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Cliente;

/**
 * @author ayrton
 *
 */
public interface IDaoCliente extends IDaoGeneric<Cliente> {

	public List<Cliente> buscarCliente(String busca) throws DaoException;
	
}
