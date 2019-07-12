/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaPessoaFisicaView;

/**
 * @author ayrtons
 *
 */
public interface IDaoAluga extends IDaoGeneric<Aluga> {

	
	public List<AlugaPessoaFisicaView> buscarAlugados(String busca) throws DaoException; 
	
}
