/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoReserva;
import br.com.sistemahoteleiro.dao.IDaoReserva;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Reserva;

/**
 * @author ayrtons
 *
 */
public class BusinessReserva extends BusinessGeneric<Reserva> implements IBusinessReserva{

	private IDaoReserva daoReserva;
	
	/**
	 * 
	 */
	public BusinessReserva() {
		// TODO Auto-generated constructor stub
		daoReserva = new DaoReserva();
		init(daoReserva);
	}
	
	@Override
	public void isValid(Reserva t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
