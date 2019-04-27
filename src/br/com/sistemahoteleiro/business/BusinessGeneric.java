/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;
import br.com.sistemahoteleiro.dao.IDaoGeneric;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Entidade;

/**
 * @author ayrtons
 *
 */
public abstract class BusinessGeneric<T extends Entidade> implements IBusinessGeneric<T> {

	protected IDaoGeneric<T> dao;

	@Override
	public void init(IDaoGeneric<T> dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}

	@Override
	public void createOrUpdate(T t) throws BusinessException {
		// TODO Auto-generated method stub

		try {
			isValid(t);
			if (t.getId() == null) {
				dao.create(t);
			} else {
				dao.update(t);
			}
		} catch (DaoException | ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public T search(Class<T> t, int id) throws BusinessException {
		// TODO Auto-generated method stub
		T ent = null;
		try {
			ent = dao.search(t, id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		return ent;
	}
	
	@Override
	public void disable(T t) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			dao.disable(t);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<T> searchAll(Class<T> t) throws BusinessException {
		// TODO Auto-generated method stub
		List<T> tList = null;
		
		try {
			dao.searchAll(t);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		
		return tList;
	}

	@Override
	public void remove(T t ) throws BusinessException {
		// TODO Auto-generated method stub

		try {
			dao.remove(t);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		
	}


}
