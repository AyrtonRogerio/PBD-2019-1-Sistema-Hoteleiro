/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.Quarto;
import br.com.sistemahoteleiro.model.QuartoView;


/**
 * @author ayrtons
 *
 */
public interface IBusinessQuarto extends IBusinessGeneric<Quarto>{

	public List<QuartoView> buscarDisponivel(String string) throws BusinessException;
	
}
