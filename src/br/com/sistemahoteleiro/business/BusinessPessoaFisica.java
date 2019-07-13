/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.dao.DaoPessoaFisica;
import br.com.sistemahoteleiro.dao.IDaoPessoaFisica;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Cliente;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaFisicaView;

/**
 * @author ayrtons
 *
 */
public class BusinessPessoaFisica extends BusinessGeneric<PessoaFisica> implements IBusinessPessoaFisica {

	private IDaoPessoaFisica daoPessoaFisica;
	
	/**
	 * 
	 */
	public BusinessPessoaFisica() {
		// TODO Auto-generated constructor stub
		daoPessoaFisica = new DaoPessoaFisica();
		init(daoPessoaFisica);
	}
	
	@Override
	public void isValid(PessoaFisica t) throws ValidationException {
		// TODO Auto-generated method stub
		
		if(t.getContato() == null) {
			throw new ValidationException("Os campos contatos não pode estar vazio!");
		}
		
		if(t.getCpf().isEmpty()) {
			throw new ValidationException("O campo CPF não pode estar vazio!");
		}
		
		if(t.getEndereco() == null) {
			throw new ValidationException("Os campos de Endereço não pode estar vazio!");
		}
		
		if(t.getNome().isEmpty()) {
			throw new ValidationException("O campo nome não pode estar vazio!");
		}
		
		if(t.getRg().isEmpty()) {
			throw new ValidationException("O campo RG não pode estar vazio!");
		}
		
		
		
	}
	
	@Override
	public List<PessoaFisica> buscarTodos(String string) throws BusinessException {
		// TODO Auto-generated method stub
		 
		try {
			List<PessoaFisica> pessoaFisicas = daoPessoaFisica.buscarTodos(string);
		
			return pessoaFisicas;
		
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
	
	@Override
	public List<PessoaFisicaView> buscarPessoasFisicasView(String string) throws BusinessException {
		// TODO Auto-generated method stub
		 
		try {
			List<PessoaFisicaView> pessoaFisicas = daoPessoaFisica.buscarPessoasFisicasView(string);
		
			return pessoaFisicas;
		
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

}
