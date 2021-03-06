/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaPessoaFisicaView;
import br.com.sistemahoteleiro.model.AlugaPessoaJuridicaView;
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

	
	public List<Aluga> buscarAlugadosPessoaFisica(String busca) throws DaoException{
		
		try {
			
			TypedQuery<Aluga> typedQuery = entityManager().createQuery("", class1);
			typedQuery.setParameter("busca", "%" + busca + "%");
			return typedQuery.getResultList();
			
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Não foi encontrado nenhum aluguel!");
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException(
					"Erro ao buscar " + class1.getSimpleName() + " " + e.getMessage());
		}
		
		
	}
	
	public List<AlugaPessoaFisicaView> buscarAlugadosFisicosView(String busca) throws DaoException {

		try {
			
			
			
			TypedQuery<AlugaPessoaFisicaView> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_ALUGA_VIEW_FISICA,
					AlugaPessoaFisicaView.class);
			typedQuery.setParameter("busca", "%" + busca + "%");
			return typedQuery.getResultList();
		
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Não foi encontrado nenhum aluguel!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException(
					"Erro ao buscar " + AlugaPessoaFisicaView.class.getSimpleName() + " " + e.getMessage());
		}

	}

	public List<AlugaPessoaJuridicaView> buscarAlugadosJuridicosView(String busca) throws DaoException {

		try {
			TypedQuery<AlugaPessoaJuridicaView> typedQuery = entityManager()
					.createQuery(SQLUtil.BUSCAR_ALUGA_VIEW_JURIDICA, AlugaPessoaJuridicaView.class);
			typedQuery.setParameter("busca", "%" + busca + "%");
			return typedQuery.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Não foi encontrado nenhum aluguel!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException(
					"Erro ao buscar " + AlugaPessoaJuridicaView.class.getSimpleName() + " " + e.getMessage());
		}

	}

	
	public double valorTotalDeAlugados(LocalDate data1, LocalDate data2) throws DaoException {
	
		try {

			StoredProcedureQuery query = entityManager().createStoredProcedureQuery("valor_total_data_aluga");
			
			query.registerStoredProcedureParameter(0, java.sql.Date.class, ParameterMode.IN);
			query.registerStoredProcedureParameter(1, java.sql.Date.class, ParameterMode.IN);
			
			query.setParameter(0, java.sql.Date.valueOf(data1.toString()));
			query.setParameter(1, java.sql.Date.valueOf(data2.toString()));
			
			double totalAluga =  (double) query.getSingleResult();

			return totalAluga;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao buscar a quantidade de alugados!");
		} 
		
	}



}
