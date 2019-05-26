/**
 * 
 */
package br.com.sistemahoteleiro.business;

import br.com.sistemahoteleiro.dao.DaoAdministrador;
import br.com.sistemahoteleiro.dao.IDaoAdministrador;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Administrador;
import br.com.sistemahoteleiro.util.Cryptography;

/**
 * @author ayrtons
 *
 */
public class BusinessAdministrador extends BusinessGeneric<Administrador> implements IBusinessAdministrador {

	private IDaoAdministrador daoAdministrador;
	
	/**
	 * 
	 */
	public BusinessAdministrador() {
		// TODO Auto-generated constructor stub
		daoAdministrador = new DaoAdministrador();
		init(daoAdministrador);
	}
	
	@Override
	public void createOrUpdate(Administrador t) throws BusinessException {
		// TODO Auto-generated method stub
		t.setSenha(Cryptography.cryptography(t.getSenha().getBytes()));
		super.createOrUpdate(t);
	}



	@Override
	public void isValid(Administrador t) throws ValidationException {
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
