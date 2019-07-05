/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.time.LocalDate;

import br.com.sistemahoteleiro.dao.DaoCaixa;
import br.com.sistemahoteleiro.dao.IDaoCaixa;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Caixa;
import br.com.sistemahoteleiro.model.CaixaView;

/**
 * @author ayrtons
 *
 */
public class BusinessCaixa extends BusinessGeneric<Caixa> implements IBusinessCaixa{

	private IDaoCaixa daoCaixa;
	
	/**
	 * 
	 */
	public BusinessCaixa() {
		// TODO Auto-generated constructor stub
		daoCaixa = new DaoCaixa();
		init(daoCaixa);
	}
	
	@Override
	public void isValid(Caixa t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Caixa buscarPorData(LocalDate date) throws BusinessException {
		// TODO Auto-generated method stub
		Caixa c;
		try {
			c = daoCaixa.buscarPorData(date);
			return c;
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Caixa buscarPorAnterior() throws BusinessException {
		// TODO Auto-generated method stub
		Caixa c;
		
		try {
			c = daoCaixa.buscarPorAnterior();
		
			return c;
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		
	}
	
	

}
