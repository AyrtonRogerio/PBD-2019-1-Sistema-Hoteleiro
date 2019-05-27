/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.dao.DaoQuarto;
import br.com.sistemahoteleiro.dao.IDaoQuarto;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Quarto;


/**
 * @author ayrtons
 *
 */
public class BusinessQuarto extends BusinessGeneric<Quarto> implements IBusinessQuarto{

	private IDaoQuarto daoQuarto;
	
	/**
	 * 
	 */
	public BusinessQuarto() {
		// TODO Auto-generated constructor stub
		daoQuarto = new DaoQuarto();
		init(daoQuarto);
	}
	
	@Override
	public void isValid(Quarto t) throws ValidationException {
		// TODO Auto-generated method stub
		if(t.getNumQuarto() == 0)
		{
		throw new ValidationException("O campo referente ao número do quarto não pode estar vazio!");	
		}
	
		if(t.getQtdCamas() == 0) {
			throw new ValidationException("O campo referente a quantidades de camas não pode estar vazio!");
		}
		
		if(t.getTipoQuarto().isEmpty()) {
			throw new ValidationException("O campo referente ao tipo do quarto não pode estar vazio!");
		}
		
	}
	
	
	@Override
	public List<Quarto> searchBuscarTodos(String string) throws BusinessException {
		// TODO Auto-generated method stub
		 
		try {
			List<Quarto> quartos = daoQuarto.searchBuscarTodos(string);
		
			return quartos;
		
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
	

}
