/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import br.com.sistemahoteleiro.model.Cliente;

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
