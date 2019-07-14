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

	public static final String BUSCAR_CAIXA_DATA = "select c from Caixa c where c.dataAbertura = :dataAbertura";

	public static final String BUSCAR_CAIXA_ANTERIOR = "select c from Caixa where id = (select max(id) from Caixa)";

	public static final String BUSCAR_CLIENTES_FISICO_JURIDICO = "SELECT DISTINCT e FROM Cliente e, PessoaFisica pf, PessoaJuridica pj "
			+ "WHERE lower(str(e.nome)) like :busca or lower(str(pf.cpf)) like :busca or lower(str(pj.cnpj)) like :busca";

	// VIEWS
	
	public static final String BUSCAR_PESSOAS_FISICAS_VIEW = "select pf from PessoaFisicaView pf "
			+ "inner join Endereco e on pf.endereco.id = e.id where lower(str(pf.nome)) like :busca or pf.cpf = :busca";
	
	public static final String BUSCAR_PESSOAS_JURIDICAS_VIEW = "select pj from PessoaJuridicaView pj "
			+ "inner join Endereco e on pj.endereco.id = e.id where lower(str(pj.nome)) like :busca or pj.cnpj = :busca";
	
	public static final String BUSCAR_QUARTO_VIEW_DISP = "select q from QuartoView q where (lower(str(q.tipoQuarto))) like :busca and disponivel = true";

	public static final String BUSCAR_ALUGA_VIEW_FISICA = "select a from AlugaPessoaFisicaView a"
			+ " inner join Quarto q on a.quarto.id = q.id where lower(str(a.nome)) like :busca or lower(str(a.cpf)) like :busca";

	public static final String BUSCAR_ALUGA_VIEW_JURIDICA = "select a from AlugaPessoaJuridicaView a "
			+ "inner join Quarto q on a.quarto.id = q.id where lower(str(a.nome)) like :busca or lower(str(a.cnpj)) like :busca";
	
	public static final String BUSCAR_RESERVA_VIEW_FISICA = "";
	
	public static final String BUSCAR_RESERVA_VIEW_JURIDICA = "";
	
	
	//Procedures
	
	
	
	//Triggers
	public static final String GATILHO_ALUGA_ATUALIZAR_SALDO_CAIXA_ = "CREATE OR REPLACE FUNCTION atualizar_saldo_caixa()" + 
			"RETURNS TRIGGER AS $$" + 
			"	DECLARE " + 
			"	id_caixa INTEGER;" + 
			"	id_aluga INTEGER;" + 
			"	saldo_total_aluga DOUBLE PRECISION;" + 
			"	n_saldo_caixa DOUBLE PRECISION;" + 
			"	saldo_caixa DOUBLE PRECISION;" + 
			"	" + 
			"BEGIN " + 
			"	" + 
			"	IF(TG_OP = 'INSERT') THEN" + 
			"		id_caixa := NEW.caixa_id;" + 
			"		id_aluga := NEW.id;" + 
			"	ELSIF(TG_OP = 'UPDATE') THEN" + 
			"		id_caixa := OLD.caixa_id;" + 
			"		id_aluga := OLD.id;" + 
			"	END IF;" + 
			"	" + 
			"	IF EXISTS (SELECT a FROM aluga AS a WHERE a.caixa_id = id_caixa) THEN" + 
			"			SELECT SUM(c.saldo) INTO saldo_caixa FROM caixa c WHERE c.id = id_caixa;" + 
			"			" + 
			"			SELECT a.valor_total INTO saldo_total_aluga FROM aluga a WHERE a.id = id_aluga;" + 
			"			n" + 
			"			SELECT (saldo_total_aluga + saldo_caixa) INTO n_saldo_caixa;" + 
			"			" + 
			"			UPDATE caixa SET saldo = n_saldo_caixa WHERE id = id_caixa;" + 
			"	END IF;" + 
			"	RETURN NULL;" + 
			"END; " + 
			"$$ LANGUAGE plpgsql;" + 
			"" + 
			"CREATE TRIGGER atualizar_saldo_caixa" + 
			"AFTER INSERT OR UPDATE " + 
			"ON aluga" + 
			"FOR EACH ROW " + 
			"EXECUTE PROCEDURE atualizar_saldo_caixa();";
	
}
