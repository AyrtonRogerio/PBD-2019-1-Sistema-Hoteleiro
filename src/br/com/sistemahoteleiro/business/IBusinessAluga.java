/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaView;

/**
 * @author ayrtons
 *
 */
public interface IBusinessAluga extends IBusinessGeneric<Aluga> {

	public List<AlugaView> buscarAlugados(String busca) throws BusinessException;
	
}
