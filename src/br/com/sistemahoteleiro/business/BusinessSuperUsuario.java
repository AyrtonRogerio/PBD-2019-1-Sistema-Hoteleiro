/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoSuperUsuario;
import br.com.sistemahoteleiro.dao.IDaoSuperUsuario;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.SuperUsuario;
import br.com.sistemahoteleiro.util.Cryptography;

/**
 * @author ayrtons
 *
 */
public class BusinessSuperUsuario extends BusinessGeneric<SuperUsuario> implements IBusinessSuperUsuario{

	private IDaoSuperUsuario daoSuperUsuario;
	
	/**
	 * 
	 */
	public BusinessSuperUsuario() {
		// TODO Auto-generated constructor stub
		daoSuperUsuario = new DaoSuperUsuario();
		init(daoSuperUsuario);
	}
	
	@Override
	public void createOrUpdate(SuperUsuario t) throws BusinessException {
		// TODO Auto-generated method stub
		t.setSenha(Cryptography.cryptography(t.getSenha().getBytes()));
		super.createOrUpdate(t);
	}



	@Override
	public void isValid(SuperUsuario t) throws ValidationException {
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
		
		if(t.getCargo() == null) {
			throw new ValidationException("O campo Cargo não pode estar vazio!");
		}
		
		if(t.getSenha().length() < 7 || t.getSenha().length() > 12) {
			throw new ValidationException("A senha tem que ter no mínimo 6 e no máximo 11 caracteres!");
		}
	}

}
