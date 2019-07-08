/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaView;

/**
 * @author ayrtons
 *
 */
public interface IDaoAluga extends IDaoGeneric<Aluga> {

	
	public List<AlugaView> buscarAlugados(String busca) throws DaoException; 
	
}
