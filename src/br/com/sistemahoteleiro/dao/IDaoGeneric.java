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
public interface IDaoGeneric <T extends Entidade>{

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
     * @param id
     * @throws DaoException
     */
    public void remove(Class<T> t, int id) throws DaoException;

    /**
     * @param entidade
     * @throws DaoException
     */
    public void update(T t) throws DaoException;

    /**
     * @return
     * @throws DaoException
     */
    public List<T> searchAll() throws DaoException;

	/**
	 * @param classe
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	
	
}
