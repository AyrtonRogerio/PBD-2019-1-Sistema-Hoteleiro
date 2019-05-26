/**
 * 
 */
package br.com.sistemahoteleiro.util;

/**
 * @author ayrton
 *
 */
public class SQLUtil {

	public static final String BUSCAR_LOGIN = "select u from Usuario u where u.login = :login and u.senha = :senha";
	
	public static final String BUSCAR_BUSCA_USUARIO = "select u from Usuario u where lower(str(u.nome)) like :busca or "
			+ "lower(str(u.login)) like :busca or lower(str(u.cpf)) like :busca or lower(str(u.rg)) like :busca";
	
}
