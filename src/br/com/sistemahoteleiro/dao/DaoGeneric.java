/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Entidade;

/**
 * @author ayrtons
 *
 */
public abstract class DaoGeneric <T extends Entidade> implements IDaoGeneric<T>{

	protected Class<T> class1;
	
	
	
	/**
	 * @param class1
	 */
	public DaoGeneric(Class<T> class1) {
		this.class1 = class1;
	}

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");

	
	
	public EntityManager entityManager() {
		return emf.createEntityManager();
	}

	@Override
	public void create(T t) throws DaoException {
		
		EntityManager em = entityManager();
		
		try {
			
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			
		} catch (Exception e) {
		
			System.err.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new DaoException("Erro ao inserir " + t.getClass().getSimpleName() + e.getMessage());
		
		}finally {
			
			em.close();
		}
	}

	@Override
	public T search(Class<T> t, int id) throws DaoException {

		EntityManager em = entityManager(); 
		T result = null;
		
		try {
			
			result = em.find(t, id);
			
		}catch (NoResultException ex) {
			
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			throw new DaoException("Nenhum resultado encontrado para " + t.getSimpleName());
			
		} catch (Exception e) {

			System.err.println(e.getMessage());
			e.printStackTrace();
			throw new DaoException("Erro ao buscar " + t.getSimpleName() + " " + e.getMessage());
			
		}finally {
			
			em.close();
		
		}
		
		return result;
	}

	
	@Override
	public void disable(T t) throws DaoException {
		// TODO Auto-generated method stub
		EntityManager em = entityManager();
		
		try {
		
			t.setStatus(false);
			em.getTransaction().begin();
			em.merge(t);
			em.merge(t);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			em.getTransaction().rollback();
			throw new DaoException(e.getMessage());
			
		} finally {
			
			em.close();
			
		}
	}

	@Override
	public void remove(T t) throws DaoException {
		
		EntityManager em = entityManager();
//		T ent = null;
		
		try {
			
			em.getTransaction().begin();
			
//			ent = em.find(t);
			em.remove(t);
			em.getTransaction().commit();
			
		}catch (NoResultException e) {
			// TODO: handle exception
			
			e.printStackTrace();
			System.err.println(e.getMessage());
			em.getTransaction().rollback();
			throw new DaoException(e.getMessage());
			
		} catch (Exception e) {
		
			System.err.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new DaoException("Erro ao remover " + t.getClass().getSimpleName() + ". " + e.getMessage());
	
		} finally {
		
			em.close();
		
		}
	}

	@Override
	public void update(T t) throws DaoException {
		
		EntityManager em = entityManager();
		
		try {
			
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			
		} catch (Exception e) {
		
			System.err.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new DaoException("Erro ao atualizar " + t.getClass().getSimpleName() + ". " + e.getMessage());
		
		} finally {
		
			em.close();
		
		}
	}

	@Override
	public List<T> searchAll() throws DaoException {
		
		EntityManager em = entityManager();
		
		List<T> ent = null;
		
		try {
			
//			ent = em.createQuery("from " + class1.getName() + " entidade e where e.status = true").getResultList();
			ent = em.createQuery("from " + class1.getName()).getResultList();	
		} catch (Exception e) {
		
			System.err.println(e.getMessage());
			e.printStackTrace();
			throw new DaoException("Erro ao buscar a lista " + class1.getSimpleName());
			
		}finally {
			
			em.close();
			
		}
		
		return ent;
	}
	
	
}
