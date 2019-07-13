/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.PessoaJuridica;
import br.com.sistemahoteleiro.model.PessoaJuridicaView;

/**
 * @author ayrtons
 *
 */
public interface IDaoPessoaJuridica extends IDaoGeneric<PessoaJuridica> {

	public List<PessoaJuridica> searchBuscarTodos(String string) throws DaoException; 

	public List<PessoaJuridicaView> buscarPessoasJuridicasView(String string) throws DaoException;
	
}
