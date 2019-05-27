/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Quarto;

/**
 * @author ayrtons
 *
 */
public interface IDaoQuarto extends IDaoGeneric<Quarto> {

	public List<Quarto> searchBuscarTodos(String string) throws DaoException;
	
}
