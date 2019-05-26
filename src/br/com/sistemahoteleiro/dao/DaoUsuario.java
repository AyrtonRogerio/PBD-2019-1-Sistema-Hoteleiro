/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Usuario;
import br.com.sistemahoteleiro.util.Cryptography;
import br.com.sistemahoteleiro.util.SQLUtil;

/**
 * @author ayrton
 *
 */
public class DaoUsuario extends DaoGeneric<Usuario> implements IDaoUsuario{

	/**
	 * @param class1
	 */
	public DaoUsuario() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario searchLoginUsuario(String login, String senha) throws DaoException {
		// TODO Auto-generated method stub
		
		try {
			TypedQuery<Usuario> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_LOGIN, class1);
			typedQuery.setParameter("login", login);
			typedQuery.setParameter("senha", Cryptography.cryptography(senha.getBytes()));			
			return typedQuery.getSingleResult();
			
			
		}catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Não foi encontrado nenhum usuário com essas informações!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Erro na busca de " + class1.getSimpleName() + " " + e.getMessage());
		}
	}

	@Override
	public List<Usuario> searchBuscarTodos(String string) throws DaoException {
		// TODO Auto-generated method stub
		
		try {
			TypedQuery<Usuario> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_BUSCA_USUARIO, class1);
			typedQuery.setParameter("busca", "%" + string + "%");
						
			return typedQuery.getResultList();
			
			
		}catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Não foi encontrado nenhum usuário com essas informações!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Erro na busca de " + class1.getSimpleName() + " " + e.getMessage());
		}
	}
	
	
}