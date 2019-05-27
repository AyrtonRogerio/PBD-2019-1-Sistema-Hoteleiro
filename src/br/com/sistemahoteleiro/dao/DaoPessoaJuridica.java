/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaJuridica;
import br.com.sistemahoteleiro.util.SQLUtil;

/**
 * @author ayrtons
 *
 */
public class DaoPessoaJuridica extends DaoGeneric<PessoaJuridica> implements IDaoPessoaJuridica{

	/**
	 * @param class1
	 */
	public DaoPessoaJuridica() {
		super(PessoaJuridica.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PessoaJuridica> searchBuscarTodos(String string) throws DaoException {
		// TODO Auto-generated method stub
		
		try {
			TypedQuery<PessoaJuridica> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_BUSCA_CLIENTE_JURIDICO, class1);
			typedQuery.setParameter("busca", "%" + string + "%");
						
			return typedQuery.getResultList();
			
			
		}catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Não foi encontrado nenhum cliente físico com essas informações!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Erro na busca de " + class1.getSimpleName() + " " + e.getMessage());
		}
	}
	
}
