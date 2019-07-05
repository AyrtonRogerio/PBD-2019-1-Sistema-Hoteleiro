/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import java.time.LocalDate;

import br.com.sistemahoteleiro.exception.DaoException;
import br.com.sistemahoteleiro.model.Caixa;
import br.com.sistemahoteleiro.model.CaixaView;

/**
 * @author ayrtons
 *
 */
public interface IDaoCaixa extends IDaoGeneric<Caixa> {

	public Caixa buscarPorData(LocalDate date) throws DaoException;
	
	public Caixa buscarPorAnterior() throws DaoException;
	
}
