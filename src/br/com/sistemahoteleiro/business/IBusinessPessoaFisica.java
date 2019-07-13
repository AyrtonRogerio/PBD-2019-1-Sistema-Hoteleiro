/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaFisicaView;

/**
 * @author ayrtons
 *
 */
public interface IBusinessPessoaFisica extends IBusinessGeneric<PessoaFisica>{

	public List<PessoaFisica> buscarTodos(String string) throws BusinessException;
	
	public List<PessoaFisicaView> buscarPessoasFisicasView(String string) throws BusinessException;
	
}
