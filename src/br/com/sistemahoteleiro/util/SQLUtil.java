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
	
	public static final String BUSCAR_BUSCA_QUARTO = "select q from Quarto q where (lower(str(q.tipoQuarto))) like :busca";
	
	public static final String BUSCAR_BUSCA_CLIENTE_FISICO = "select cf from PessoaFisica cf where lower(str(cf.nome)) like :busca "
			+ "or cf.cpf like :busca or cf.rg like :busca";

	public static final String BUSCAR_BUSCA_CLIENTE_JURIDICO = "select cj from PessoaJuridica cj where lower(str(cj.nome)) like :busca "
			+ "or lower(str(cj.razaoSocial)) like :busca or cj.cnpj like :busca";
}
