/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.util.List;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaPessoaFisicaView;
import br.com.sistemahoteleiro.model.AlugaPessoaJuridicaView;

/**
 * @author ayrtons
 *
 */
public interface IBusinessAluga extends IBusinessGeneric<Aluga> {

	public List<AlugaPessoaFisicaView> buscarAlugadosFisicosView(String busca) throws BusinessException;
	
	public List<AlugaPessoaJuridicaView> buscarAlugadosJuridicosView(String busca) throws BusinessException;
	
}
