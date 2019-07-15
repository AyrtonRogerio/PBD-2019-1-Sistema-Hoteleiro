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

	public static final String BUSCAR_CAIXA_ANTERIOR = "select c from Caixa c where id = (select max(id) from Caixa)";

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
	
	public static final String BUSCAR_RESERVA_VIEW_FISICA = "select r from ReservaViewFisica r "
			+ "inner join Quarto q on r.quarto.id = q.id where lower(str(r.nome)) like :busca or lower(str(r.cpf)) like :busca";
	
	public static final String BUSCAR_RESERVA_VIEW_JURIDICA = "";
	
	
	//Procedures
	
	public static final String STORED_PROCEDURES_CALCULAR_DIAS = "CREATE OR REPLACE FUNCTION calcular_dias(data_entrada date, data_saida date) \n" + 
			"RETURNS integer AS $$\n" + 
			"	\n" + 
			"	DECLARE num_dias int;\n" + 
			"	\n" + 
			"BEGIN\n" + 
			"\n" + 
			"	SELECT abs(data_saida - data_entrada) INTO num_dias;\n" + 
			"	\n" + 
			"	RETURN num_dias;\n" + 
			"	\n" + 
			"END; $$ \n" + 
			"LANGUAGE plpgsql;";
	
	
	
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
	
	public static final String GATILHO_RESERVA_ATUALIZAR_SALDO_CAIXA_ = "CREATE OR REPLACE FUNCTION reserva_atualizar_saldo_caixa()\n" + 
			"			RETURNS TRIGGER AS $$\n" + 
			"				DECLARE \n" + 
			"				id_caixa INTEGER; \n" + 
			"				id_reserva INTEGER;\n" + 
			"				saldo_total_reserva DOUBLE PRECISION; \n" + 
			"				n_saldo_caixa DOUBLE PRECISION; \n" + 
			"				saldo_caixa DOUBLE PRECISION;\n" + 
			"				 \n" + 
			"			BEGIN   \n" + 
			"				 \n" + 
			"				IF(TG_OP = 'INSERT') THEN\n" + 
			"					id_caixa := NEW.caixa_id;\n" + 
			"					id_reserva := NEW.id;\n" + 
			"				ELSIF(TG_OP = 'UPDATE') THEN\n" + 
			"					id_caixa := OLD.caixa_id;\n" + 
			"					id_reserva := OLD.id;\n" + 
			"				END IF;\n" + 
			"			\n" + 
			"				IF EXISTS (SELECT r FROM reserva AS r WHERE r.caixa_id = id_caixa) THEN\n" + 
			"						SELECT SUM(c.saldo) INTO saldo_caixa FROM caixa c WHERE c.id = id_caixa;\n" + 
			"						 \n" + 
			"						SELECT r.valor INTO saldo_total_reserva FROM reserva r WHERE r.id = id_reserva;\n" + 
			"						\n" + 
			"						SELECT (saldo_total_reserva + saldo_caixa) INTO n_saldo_caixa;\n" + 
			"			 \n" + 
			"			UPDATE caixa SET saldo = n_saldo_caixa WHERE id = id_caixa;\n" + 
			"END IF;\n" + 
			"RETURN NULL;\n" + 
			"END; \n" + 
			"$$ LANGUAGE plpgsql; \n" + 
			" \n" + 
			"CREATE TRIGGER reserva_atualizar_saldo_caixa\n" + 
			"AFTER INSERT OR UPDATE\n" + 
			"ON reserva \n" + 
			"FOR EACH ROW \n" + 
			"EXECUTE PROCEDURE reserva_atualizar_saldo_caixa();";
	
	public static final String GATILHOS_LOG = "CREATE OR REPLACE FUNCTION gera_log()\n" + 
			"RETURNS TRIGGER\n" + 
			"AS $$\n" + 
			"BEGIN\n" + 
			"INSERT INTO log (data, autor, alteracao, tabela)\n" + 
			"VALUES (now(), user, TG_OP, TG_RELNAME);\n" + 
			"RETURN NEW;\n" + 
			"END; \n" + 
			"$$ LANGUAGE plpgsql;\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_admin\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON administrador\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_aluga\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON aluga\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_caixa\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON caixa\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_contato\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON contato\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_endereco\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON endereco\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_funcionario\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON funcionario\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_pessoa_fisica\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON pessoa_fisica\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_pessoa_juridica\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON pessoa_juridica\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_quarto\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON quarto\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_reserva\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON reserva\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_super_usuario\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON super_usuario\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();";
	
}
