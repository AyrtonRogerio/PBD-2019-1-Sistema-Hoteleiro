/**
 * 
 */
package br.com.sistemahoteleiro.business;

import java.time.LocalDate;
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
	
	public double buscarValorTotalDeAlugados(LocalDate data1, LocalDate data2) throws BusinessException;
	
}
