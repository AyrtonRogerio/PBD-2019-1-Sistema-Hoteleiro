/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Reserva;
import br.com.sistemahoteleiro.model.ReservaViewFisica;
import br.com.sistemahoteleiro.model.ReservaViewJuridica;

/**
 * @author ayrtons
 *
 */
public interface IDaoReserva extends IDaoGeneric<Reserva> {

	public List<ReservaViewFisica> buscarReservadosFisicosView(String busca) throws DaoException;
	
	public List<ReservaViewJuridica> buscarReservadosJuridicosView(String busca) throws DaoException;
	
	public double valorTotalDeReservas(LocalDate data1, LocalDate data2) throws DaoException;
	
}
