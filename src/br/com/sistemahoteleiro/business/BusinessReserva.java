/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.sistemahoteleiro.dao.DaoReserva;
import br.com.sistemahoteleiro.dao.IDaoReserva;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.AlugaPessoaFisicaView;
import br.com.sistemahoteleiro.model.Reserva;
import br.com.sistemahoteleiro.model.ReservaViewFisica;
import br.com.sistemahoteleiro.model.ReservaViewJuridica;

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
	
	@Override
	public List<ReservaViewFisica> buscarReservadosFisicosView(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		
		try {
			return daoReserva.buscarReservadosFisicosView(busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<ReservaViewJuridica> buscarReservadosJuridicosView(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		
		try {
			return daoReserva.buscarReservadosJuridicosView(busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
	
	@Override
	public double buscarValorTotalDeReservas(LocalDate data1, LocalDate data2) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoReserva.valorTotalDeReservas(data1, data2);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
	

}
