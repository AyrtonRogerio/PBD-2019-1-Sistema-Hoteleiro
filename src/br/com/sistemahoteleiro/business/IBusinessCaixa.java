/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.time.LocalDate;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.Caixa;
import br.com.sistemahoteleiro.model.CaixaView;

/**
 * @author ayrtons
 *
 */
public interface IBusinessCaixa extends IBusinessGeneric<Caixa>{

	public Caixa buscarPorData(LocalDate date) throws BusinessException;
	
	public Caixa buscarPorAnterior() throws BusinessException;
	
}
