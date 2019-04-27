/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoFuncionario;
import br.com.sistemahoteleiro.dao.IDaoFuncionario;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Funcionario;

/**
 * @author ayrtons
 *
 */
public class BusinessFuncionario extends BusinessGeneric<Funcionario> implements IBusinessFuncionario {

	private IDaoFuncionario daoFuncionario;
	
	/**
	 * 
	 */
	public BusinessFuncionario() {
		// TODO Auto-generated constructor stub
		daoFuncionario = new DaoFuncionario();
		init(daoFuncionario);
	}
	
	@Override
	public void isValid(Funcionario t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

}
