/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaPessoaFisicaView;
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

	
	
	
	public List<AlugaPessoaFisicaView> buscarAlugados(String busca) throws DaoException {
		
		try {
		TypedQuery<AlugaPessoaFisicaView> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_ALUGA_VIEW_FISICA, AlugaPessoaFisicaView.class);
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
			throw new DaoException("Erro ao buscar " + AlugaPessoaFisicaView.class.getSimpleName() + " " + e.getMessage());
		}
		
	}




	@Override
	public EntityManager entityManager() {
		// TODO Auto-generated method stub
		return super.entityManager();
	}




	@Override
	public void create(Aluga t) throws DaoException {
		// TODO Auto-generated method stub
		EntityManager em = entityManager();
		
		em.persist(t);
		em.refresh(t.getCaixa());
		em.refresh(t.getCliente());
		em.refresh(t.getUsuario());
		em.refresh(t.getQuarto());
		
	}


	
}
