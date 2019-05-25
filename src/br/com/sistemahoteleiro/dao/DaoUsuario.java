/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import br.com.sistemahoteleiro.model.Usuario;

/**
 * @author ayrton
 *
 */
public class DaoUsuario extends DaoGeneric<Usuario> implements IDaoUsuario{

	/**
	 * @param class1
	 */
	public DaoUsuario() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

}
