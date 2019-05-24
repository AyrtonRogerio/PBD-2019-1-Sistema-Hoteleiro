/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.time.LocalDate;
import java.time.LocalTime;

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
		
		if(t.getCliente() == null) {
			throw new ValidationException("O cliente não foi selecionado para a reserva, "
					+ "por favor selecione um cliente!");
		}
		
		if(t.getDataReserva().isBefore(LocalDate.now())) {
			throw new ValidationException("Não pode ser selecionada uma data anterior a atual!");
		}
		
		if(t.getHoraReserva().isBefore(LocalTime.now())) {
			throw new ValidationException("Por favor, selecione uma hora que não seja a atual!");
		}
		
		if(t.getQuarto() == null) {
			throw new ValidationException("Quarto não selecionado. Por favor,"
					+ " selecione um quarto para efetuar a reserva!");
		}
		
		if(t.getValor() == 0.0) {
			throw new ValidationException("Valor não inserido. Por favor,"
					+ " insira um valor para efetuar a reserva!");	
		}
		
	}

}
