/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.dao.DaoAluga;
import br.com.sistemahoteleiro.dao.IDaoAluga;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaPessoaFisicaView;
import br.com.sistemahoteleiro.model.AlugaPessoaJuridicaView;

/**
 * @author ayrtons
 *
 */
public class BusinessAluga extends BusinessGeneric<Aluga> implements IBusinessAluga{

	private IDaoAluga daoAluga;
	
	/**
	 * 
	 */
	public BusinessAluga() {
		// TODO Auto-generated constructor stub
		daoAluga = new DaoAluga();
		init(daoAluga);
	}
	
	
	@Override
	public void isValid(Aluga t) throws ValidationException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<AlugaPessoaFisicaView> buscarAlugadosFisicosView(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		
		try {
			return daoAluga.buscarAlugadosFisicosView(busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}


	@Override
	public List<AlugaPessoaJuridicaView> buscarAlugadosJuridicosView(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoAluga.buscarAlugadosJuridicosView(busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}


	
}
