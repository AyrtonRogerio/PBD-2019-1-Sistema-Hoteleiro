/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoFuncionario;
import br.com.sistemahoteleiro.dao.IDaoFuncionario;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Funcionario;

/**
 * @author ayrtons
 *
 */
public class BusinessFuncionario extends BusinessGeneric<Funcionario> implements IBusinessFuncionario {

	private IDaoFuncionario daoFuncionario;
	
	/**
	 * 
	 */
	public BusinessFuncionario() {
		// TODO Auto-generated constructor stub
		daoFuncionario = new DaoFuncionario();
		init(daoFuncionario);
	}
	
	@Override
	public void isValid(Funcionario t) throws ValidationException {
		// TODO Auto-generated method stub
		if(t.getCpf().isEmpty()) {
			throw new ValidationException("O campo CPF não pode estar vazio!");
		}
		
		if(t.getLogin().isEmpty()) {
			throw new ValidationException("O campo Login não pode estar vazio!");
		}
		
		if(t.getNome().isEmpty()) {
			throw new ValidationException("O campo Nome não pode estar vazio!");
		}
		
		if(t.getRg().isEmpty()) {
			throw new ValidationException("O campo RG não pode estar vazio!");
		}
		
		if(t.getSenha().isEmpty()) {
			throw new ValidationException("O campo Senha não pode estar vazio!");
		}
		
		if(t.getSenha().length() < 6) {
			
		}
		
	}

}
