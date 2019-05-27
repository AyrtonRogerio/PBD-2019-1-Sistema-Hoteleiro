/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.Quarto;


/**
 * @author ayrtons
 *
 */
public interface IBusinessQuarto extends IBusinessGeneric<Quarto>{

	public List<Quarto> searchBuscarTodos(String string) throws BusinessException;
	
}
