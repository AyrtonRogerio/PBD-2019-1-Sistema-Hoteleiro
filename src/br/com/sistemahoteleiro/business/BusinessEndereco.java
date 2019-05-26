/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoEndereco;
import br.com.sistemahoteleiro.dao.IDaoEndereco;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Endereco;

/**
 * @author ayrtons
 *
 */
public class BusinessEndereco extends BusinessGeneric<Endereco> implements IBusinessEndereco{

	private IDaoEndereco daoEndereco;
	
	/**
	 * 
	 */
	public BusinessEndereco() {
		// TODO Auto-generated constructor stub
		daoEndereco = new DaoEndereco();
		init(daoEndereco);
	}
	
	@Override
	public void isValid(Endereco t) throws ValidationException {
		// TODO Auto-generated method stub
		if(t.getBairro().isEmpty()) {
			throw new ValidationException("O campo Bairro não pode estar vazio!");
		}
		
		if(t.getCep().isEmpty()) {
			throw new ValidationException("O campo CEP não pode estar vazio!");
		}
		
		if(t.getCidade().isEmpty()) {
			throw new ValidationException("O campo Cidade não pode estar vazio!");
		}
		
		if(t.getLogradouro().isEmpty()) {
			throw new ValidationException("O campo Logradouro não pode estar vazio!");
		}
		
		if(t.getNumero().isEmpty()) {
			throw new ValidationException("O campo Número não pode estar vazio!");
		}
		
//		if(t.getUf().isEmpty()) {
//			throw new ValidationException("O campo UF não pode estar vazio!");
//		}
//		
//		if(t.getUf().length() > 2) {
//			throw new ValidationException("O campo estado só pode conter 2 caracteres!");
//		}
	}

}
