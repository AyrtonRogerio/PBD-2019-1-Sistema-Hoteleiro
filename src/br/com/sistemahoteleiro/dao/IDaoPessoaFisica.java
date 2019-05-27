/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.PessoaFisica;

/**
 * @author ayrtons
 *
 */
public interface IDaoPessoaFisica extends IDaoGeneric<PessoaFisica> {

	public List<PessoaFisica> searchBuscarTodos(String string) throws DaoException;
	
}
