/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.dao.IDaoGeneric;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.exception.ValidationException;
import br.com.sistemahoteleiro.model.Entidade;

/**
 * @author ayrtons
 *
 */
public interface IBusinessGeneric <T extends Entidade> {

	/**
	 * @param dao
	 */
	public void init(IDaoGeneric<T> dao);
	
	/**
	 * @param t
	 * @throws BusinessException
	 */
	public void createOrUpdate(T t) throws BusinessException;
	
	/**
	 * @param t
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public  T search(Class<T> t, int id) throws BusinessException;
	
	/**
	 * @param t
	 * @return
	 * @throws BusinessException
	 */
	public List<T> searchAll(Class<T> t) throws BusinessException;
	
	/**
	 * @param t
	 * @throws BusinessException
	 */
	public void remove(T t) throws BusinessException;
	
	/**
	 * @param t
	 * @throws BusinessException
	 */
	public void disable(T t) throws BusinessException;
	
	/**
	 * @param t
	 * @throws ValidationException
	 */
	public void isValid(T t) throws ValidationException;
	
	
}
