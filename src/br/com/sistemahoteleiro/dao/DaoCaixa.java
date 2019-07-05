/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.time.LocalDate;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Caixa;
import br.com.sistemahoteleiro.model.CaixaView;
import br.com.sistemahoteleiro.util.SQLUtil;

/**
 * @author ayrtons
 *
 */
public class DaoCaixa extends DaoGeneric<Caixa> implements IDaoCaixa {

	/**
	 * @param class1
	 */
	public DaoCaixa() {
		super(Caixa.class);
		// TODO Auto-generated constructor stub
	}

	public Caixa buscarPorData(LocalDate dataAbertura) throws DaoException{
		
		try {
		TypedQuery<Caixa> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_CAIXA_DATA, class1);
		typedQuery.setParameter("dataAbertura", dataAbertura);
		return typedQuery.getSingleResult();
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
//			throw new DaoException("Erro na busca da " + class1.getSimpleName() + " " + e.getMessage());
		}
		return null;
	}

	@Override
	public Caixa buscarPorAnterior() throws DaoException {
		// TODO Auto-generated method stub
		try {
			
			TypedQuery<Caixa> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_CAIXA_ANTERIOR, class1);
			return typedQuery.getSingleResult();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
//			throw new DaoException("Erro ao buscar " + class1.getSimpleName() + " " + e.getMessage());
		}
		return null;
	}
	
}
