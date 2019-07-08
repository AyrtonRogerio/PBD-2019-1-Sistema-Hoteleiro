/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaView;
import br.com.sistemahoteleiro.util.SQLUtil;

/**
 * @author ayrtons
 *
 */
public class DaoAluga extends DaoGeneric<Aluga> implements IDaoAluga {

	/**
	 * @param class1
	 */
	public DaoAluga() {
		super(Aluga.class);
		// TODO Auto-generated constructor stub
	}

	
	public List<AlugaView> buscarAlugados(String busca) throws DaoException {
		
		try {
		TypedQuery<AlugaView> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_ALUGA_VIEW_DISP, AlugaView.class);
		typedQuery.setParameter("busca", "%" + busca + "%");
		return typedQuery.getResultList();
		}catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Não foi encontrado nenhum aluguel!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Erro ao buscar " + AlugaView.class.getSimpleName() + " " + e.getMessage());
		}
		
	}
	
}
