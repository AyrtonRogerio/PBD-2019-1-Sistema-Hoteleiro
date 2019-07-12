/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.dao.DaoCliente;
import br.com.sistemahoteleiro.dao.IDaoCliente;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Cliente;


/**
 * @author ayrton
 *
 */
public class BusinessCliente extends BusinessGeneric<Cliente> implements IBusinessCliente{

	private IDaoCliente daoCliente;
	
	/**
	 * 
	 */
	public BusinessCliente() {
		// TODO Auto-generated constructor stub
		
		daoCliente = new DaoCliente();
		init(daoCliente);
	}
	
	@Override
	public void isValid(Cliente t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

	public List<Cliente> buscarCliente(String buscar) throws BusinessException{
		
		try {
			return daoCliente.buscarCliente(buscar);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		
	}
	
}
