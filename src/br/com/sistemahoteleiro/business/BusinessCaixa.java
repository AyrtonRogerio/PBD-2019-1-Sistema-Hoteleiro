/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoCaixa;
import br.com.sistemahoteleiro.dao.IDaoCaixa;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Caixa;

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

}
