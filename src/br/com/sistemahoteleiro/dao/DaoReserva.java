/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Reserva;
import br.com.sistemahoteleiro.model.ReservaViewFisica;
import br.com.sistemahoteleiro.model.ReservaViewJuridica;
import br.com.sistemahoteleiro.util.SQLUtil;

/**
 * @author ayrtons
 *
 */
public class DaoReserva extends DaoGeneric<Reserva> implements IDaoReserva{

	/**
	 * @param class1
	 */
	public DaoReserva() {
		super(Reserva.class);
		// TODO Auto-generated constructor stub
	}

	public List<ReservaViewFisica> buscarReservadosFisicosView(String busca) throws DaoException {

		try {
			TypedQuery<ReservaViewFisica> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_RESERVA_VIEW_FISICA, ReservaViewFisica.class);
			typedQuery.setParameter("busca", "%" + busca + "%");
			return typedQuery.getResultList();
		
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Não foi encontrado nenhuma reserva!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException(
					"Erro ao buscar " + ReservaViewFisica.class.getSimpleName() + " " + e.getMessage());
		}

	}

	public List<ReservaViewJuridica> buscarReservadosJuridicosView(String busca) throws DaoException {

		try {
			TypedQuery<ReservaViewJuridica> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_RESERVA_VIEW_JURIDICA,
					ReservaViewJuridica.class);
			typedQuery.setParameter("busca", "%" + busca + "%");
			return typedQuery.getResultList();
		
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException("Não foi encontrado nenhuma reserva!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new DaoException(
					"Erro ao buscar " + ReservaViewJuridica.class.getSimpleName() + " " + e.getMessage());
		}

	}
	
	public double valorTotalDeReservas(LocalDate data1, LocalDate data2) throws DaoException {
		
		try {

			StoredProcedureQuery query = entityManager().createStoredProcedureQuery("soma_valor_reserva_data");
			
			query.registerStoredProcedureParameter(0, java.sql.Date.class, ParameterMode.IN);
			query.registerStoredProcedureParameter(1, java.sql.Date.class, ParameterMode.IN);
			
			query.setParameter(0, java.sql.Date.valueOf(data1.toString()));
			query.setParameter(1, java.sql.Date.valueOf(data2.toString()));
			
			double total =  (double) query.getSingleResult();

			return total;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Erro ao buscar o valor total das reserva!");
		} 
		
	}
	

	
}
