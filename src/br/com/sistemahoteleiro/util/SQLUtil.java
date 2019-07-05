/**
 * 
 */
package br.com.sistemahoteleiro.util;

/**
 * @author ayrton
 *
 */
public class SQLUtil {

	// HQL
	public static final String BUSCAR_LOGIN = "select u from Usuario u where u.login = :login and u.senha = :senha";

	public static final String BUSCAR_BUSCA_USUARIO = "select u from Usuario u where lower(str(u.nome)) like :busca or "
			+ "lower(str(u.login)) like :busca or lower(str(u.cpf)) like :busca or lower(str(u.rg)) like :busca";

	public static final String BUSCAR_BUSCA_QUARTO = "select q from Quarto q where (lower(str(q.tipoQuarto))) like :busca";

	public static final String BUSCAR_BUSCA_CLIENTE_FISICO = "select cf from PessoaFisica cf where lower(str(cf.nome)) like :busca "
			+ "or cf.cpf like :busca or cf.rg like :busca";

	public static final String BUSCAR_BUSCA_CLIENTE_JURIDICO = "select cj from PessoaJuridica cj where lower(str(cj.nome)) like :busca "
			+ "or lower(str(cj.razaoSocial)) like :busca or cj.cnpj like :busca";

//	public static final String BUSCAR_CAIXA_DATA = "select c from Caixa c where c.dataAbertura = :dataAbertura";
//
//	public static final String BUSCAR_CAIXA_ANTERIOR = "select c from Caixa where id = (select max(id) from Caixa)";

	// VIEWS
	public static final String BUSCAR_QUARTO_VIEW_DISP = "select q from QuartoView q where (lower(str(q.tipoQuarto))) like :busca and disponivel = true";

	public static final String BUSCAR_ALUGA_VIEW_DISP = "select a from AlugaView a ";

	public static final String BUSCAR_CAIXA_DATA = "select c from CaixaView c where c.dataAbertura = :dataAbertura";

	public static final String BUSCAR_CAIXA_ANTERIOR = "select c from CaixaView where id = (select max(id) from Caixa)";

}
