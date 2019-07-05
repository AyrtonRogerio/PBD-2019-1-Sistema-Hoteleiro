/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Quarto;
import br.com.sistemahoteleiro.model.QuartoView;

/**
 * @author ayrtons
 *
 */
public interface IDaoQuarto extends IDaoGeneric<Quarto> {

	public List<QuartoView> buscarDisponivel(String string) throws DaoException;
	
}
