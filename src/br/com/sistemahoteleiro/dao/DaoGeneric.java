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

	private EntityManagerFactory emf;
	
	public EntityManager entityManager() {
		emf = Persistence.createEntityManagerFactory("Hotel");
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
	public void remove(Class<T> t, int id) throws DaoException {
		
		EntityManager em = entityManager();
		T ent = null;
		
		try {
			
			em.getTransaction().begin();
			
			ent = em.find(t, id);
			em.remove(ent);
			em.getTransaction().commit();
			
		} catch (Exception e) {
		
			System.err.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new DaoException("Erro ao remover " + ent.getClass().getSimpleName() + ". " + e.getMessage());
	
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
	public List<T> searchAll(Class<T> t) throws DaoException {
		
		EntityManager em = entityManager();
		List<T> ent = null;
		
		try {
			
			ent = em.createQuery("from " + t.getSimpleName() + "where entidade.status = true", t).getResultList();
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			throw new DaoException("Erro ao buscar a lista " + t.getSimpleName());
			
		}finally {
			em.close();
		}
		
		return ent;
	}
	
	
	
}
