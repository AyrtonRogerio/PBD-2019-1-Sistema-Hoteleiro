/**
 * 
 */
package br.com.sistemahoteleiro.dao;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaFisicaView;
import br.com.sistemahoteleiro.util.SQLUtil;

/**
 * @author ayrtons
 *
 */
public class DaoPessoaFisica extends DaoGeneric<PessoaFisica> implements IDaoPessoaFisica{

	/**
	 * @param class1
	 */
	public DaoPessoaFisica() {
		super(PessoaFisica.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<PessoaFisica> buscarTodos(String string) throws DaoException {
		// TODO Auto-generated method stub
		
		try {
			TypedQuery<PessoaFisica> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_BUSCA_CLIENTE_FISICO, class1);
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
	
	@Override
	public List<PessoaFisicaView> buscarTodosView(String string) throws DaoException {
		// TODO Auto-generated method stub
		
		try {
			TypedQuery<PessoaFisicaView> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_PESSOAS_FISICAS_VIEW, PessoaFisicaView.class);
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
	
//	public static void main(String[] args) {
//		
//		DaoPessoaFisica daoPessoaFisica = new DaoPessoaFisica();
//		
//		try {
//			System.out.println(daoPessoaFisica.buscarTodosView("a"));
//		} catch (DaoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
}
