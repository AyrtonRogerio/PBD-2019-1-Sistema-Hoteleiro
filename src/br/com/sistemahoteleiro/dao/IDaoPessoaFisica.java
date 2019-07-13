/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaFisicaView;

/**
 * @author ayrtons
 *
 */
public interface IDaoPessoaFisica extends IDaoGeneric<PessoaFisica> {

	public List<PessoaFisica> buscarTodos(String string) throws DaoException;
	
	public List<PessoaFisicaView> buscarPessoasFisicasView(String string) throws DaoException;
	
}
