/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Reserva;
import br.com.sistemahoteleiro.model.ReservaViewFisica;

/**
 * @author ayrtons
 *
 */
public interface IDaoReserva extends IDaoGeneric<Reserva> {

	public List<ReservaViewFisica> buscarReservadosFisicosView(String busca) throws DaoException;
	
}
