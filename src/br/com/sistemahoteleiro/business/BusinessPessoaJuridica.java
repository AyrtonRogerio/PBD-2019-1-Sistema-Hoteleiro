/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.dao.DaoPessoaJuridica;
import br.com.sistemahoteleiro.dao.IDaoPessoaJuridica;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaJuridica;

/**
 * @author ayrtons
 *
 */
public class BusinessPessoaJuridica extends BusinessGeneric<PessoaJuridica> implements IBusinessPessoaJuridica{

	private IDaoPessoaJuridica daoPessoaJuridica;
	
	/**
	 * 
	 */
	public BusinessPessoaJuridica() {
		// TODO Auto-generated constructor stub
		daoPessoaJuridica = new DaoPessoaJuridica();
		init(daoPessoaJuridica);
	}
	
	@Override
	public void isValid(PessoaJuridica t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PessoaJuridica> searchBuscarTodos(String string) throws BusinessException {
		// TODO Auto-generated method stub
		 
		try {
			List<PessoaJuridica> pessoaJuridicas = daoPessoaJuridica.searchBuscarTodos(string);
		
			return pessoaJuridicas;
		
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
	
}
