/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.Reserva;
import br.com.sistemahoteleiro.model.ReservaViewFisica;

/**
 * @author ayrtons
 *
 */
public interface IBusinessReserva extends IBusinessGeneric<Reserva>{

	
	public List<ReservaViewFisica> buscarReservadosFisicosView(String busca) throws BusinessException;
	
}
