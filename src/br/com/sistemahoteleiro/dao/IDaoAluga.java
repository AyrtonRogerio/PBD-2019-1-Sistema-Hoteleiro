/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaPessoaFisicaView;
import br.com.sistemahoteleiro.model.AlugaPessoaJuridicaView;

/**
 * @author ayrtons
 *
 */
public interface IDaoAluga extends IDaoGeneric<Aluga> {

	
	public List<AlugaPessoaFisicaView> buscarAlugadosFisicosView(String busca) throws DaoException; 
	
	public List<AlugaPessoaJuridicaView> buscarAlugadosJuridicosView(String busca) throws DaoException;
	
}
