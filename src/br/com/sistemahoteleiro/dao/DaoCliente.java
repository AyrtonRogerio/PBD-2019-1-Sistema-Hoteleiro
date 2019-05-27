/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Cliente;
import br.com.sistemahoteleiro.util.SQLUtil;

/**
 * @author ayrton
 *
 */
public class DaoCliente extends DaoGeneric<Cliente> implements IDaoCliente{

	/**
	 * @param class1
	 */
	public DaoCliente() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

	
	
}
