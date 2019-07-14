/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Reserva;
import br.com.sistemahoteleiro.model.ReservaViewFisica;
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
			TypedQuery<ReservaViewFisica> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_RESERVA_VIEW_FISICA,
					ReservaViewFisica.class);
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
	
}
