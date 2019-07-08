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
import br.com.sistemahoteleiro.model.ClienteView;
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

	public List<Cliente> buscarCliente(String busca) throws DaoException {
		
		try {
			
			TypedQuery<Cliente> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_CLIENTES_FISICO_JURIDICO, class1);
			typedQuery.setParameter("busca", "%" + busca + "%");
			
			return typedQuery.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Não foi encontrado nenhum cliente!");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Erro ao buscar " + class1.getSimpleName() + " " + e.getMessage());
		}
	}
	
//	public List<ClienteView> buscarCliente()
//	{
//		EntityManager em = entityManager();
//		
//		TypedQuery<ClienteView> query = em.createQuery("SELECT c FROM Cliente c, PessoaFisica pf, PessoaJuridica pj ", ClienteView.class);
//		query.setParameter("id", id);
//		query.setParameter("cpf", "%" + cpf + "%");
//		
//		return query.getResultList();
//	}
	
//	public static void main(String[] args) {
//		DaoCliente daoCliente = new DaoCliente();
//		
//		System.out.println(daoCliente.buscarCliente("a"));
//		
//	}
}
