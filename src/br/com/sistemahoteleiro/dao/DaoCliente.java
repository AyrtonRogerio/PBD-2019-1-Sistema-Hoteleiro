/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Cliente;
import br.com.sistemahoteleiro.util.SQLUtil;

/**
 * @author ayrton
 *
 */
public class DaoCliente extends DaoGeneric<Cliente> implements IDaoCliente{

	/**
	 * @param class1
	 */
	public DaoCliente() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

	public List<Cliente> buscarCliente(int id)
	{
		EntityManager em = entityManager();
		
		TypedQuery<Cliente> query = em.createQuery("SELECT e FROM Cliente e, PessoaFisica pf, PessoaJuridica pj WHERE e.id=:id AND ", Cliente.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}
	
//	public static void main(String[] args) {
//		DaoCliente daoCliente = new DaoCliente();
//		
//		System.out.println(daoCliente.buscarCliente(1));
//		
//	}
}
