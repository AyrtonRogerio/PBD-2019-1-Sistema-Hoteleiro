/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoParcela;
import br.com.sistemahoteleiro.dao.IDaoParcela;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Parcela;

/**
 * @author ayrtons
 *
 */
public class BusinessParcela extends BusinessGeneric<Parcela> implements IBusinessParcela{

	private IDaoParcela daoParcela;
	
	/**
	 * 
	 */
	public BusinessParcela() {
		// TODO Auto-generated constructor stub
		daoParcela = new DaoParcela();
		init(daoParcela);
	}
	
	
	@Override
	public void isValid(Parcela t) throws ValidationException {
		// TODO Auto-generated method stub
		
//		if(t.get)
	}

}
