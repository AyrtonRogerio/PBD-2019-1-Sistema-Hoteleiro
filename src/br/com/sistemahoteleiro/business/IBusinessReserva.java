/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.time.LocalDate;
import java.util.List;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.Reserva;
import br.com.sistemahoteleiro.model.ReservaViewFisica;
import br.com.sistemahoteleiro.model.ReservaViewJuridica;

/**
 * @author ayrtons
 *
 */
public interface IBusinessReserva extends IBusinessGeneric<Reserva>{

	
	public List<ReservaViewFisica> buscarReservadosFisicosView(String busca) throws BusinessException;
	
	public List<ReservaViewJuridica> buscarReservadosJuridicosView(String busca) throws BusinessException;
	
	public double buscarValorTotalDeReservas(LocalDate data1, LocalDate data2) throws BusinessException;
}
