/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Quarto;
import br.com.sistemahoteleiro.util.SQLUtil;

/**
 * @author ayrtons
 *
 */
public class DaoQuarto extends DaoGeneric<Quarto> implements IDaoQuarto{

	/**
	 * @param class1
	 */
	public DaoQuarto() {
		super(Quarto.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Quarto> searchBuscarTodos(String string) throws DaoException {
		// TODO Auto-generated method stub
		
		try {
			TypedQuery<Quarto> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_BUSCA_QUARTO, class1);
			typedQuery.setParameter("busca", "%" + string + "%");
						
			return typedQuery.getResultList();
			
			
		}catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Não foi encontrado nenhum quarto com essas informações!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Erro na busca de " + class1.getSimpleName() + " " + e.getMessage());
		}
	}
	
}
