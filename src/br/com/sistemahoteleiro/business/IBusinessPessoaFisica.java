/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.PessoaFisica;

/**
 * @author ayrtons
 *
 */
public interface IBusinessPessoaFisica extends IBusinessGeneric<PessoaFisica>{

	public List<PessoaFisica> searchBuscarTodos(String string) throws BusinessException;
	
}
