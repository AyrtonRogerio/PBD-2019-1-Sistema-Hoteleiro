/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaJuridica;
import br.com.sistemahoteleiro.model.PessoaJuridicaView;

/**
 * @author ayrtons
 *
 */
public interface IBusinessPessoaJuridica extends IBusinessGeneric<PessoaJuridica>{

	public List<PessoaJuridica> searchBuscarTodos(String string) throws BusinessException;
	
	public List<PessoaJuridicaView> buscarPessoasJuridicasView(String string) throws BusinessException;
	
}
