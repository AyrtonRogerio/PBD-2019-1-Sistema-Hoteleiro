/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.util.List;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Entidade;

/**
 * @author ayrtons
 *
 */
public interface IDaoGeneric<T extends Entidade> {

	/**
	 * @param entidade
	 * @throws DaoException
	 */
	public void create(T t) throws DaoException;

	/**
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public T search(Class<T> classe, int id) throws DaoException;

	/**
	 * 
	 * @param t
	 * @throws DaoException
	 */
	public void disable(T t) throws DaoException;

	/**
	 * @param id
	 * @throws DaoException
	 */
	public void remove(T t) throws DaoException;

	/**
	 * @param entidade
	 * @throws DaoException
	 */
	public void update(T t) throws DaoException;

	/**
	 * @author ayrtons
	 *
	 * @param <T>
	 * @return
	 * @throws DaoException
	 */
	public List<T> searchAll() throws DaoException;

}
