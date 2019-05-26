/**
 * 
 */
package br.com.sistemahoteleiro.facade;

import java.util.List;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.Administrador;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.Caixa;
import br.com.sistemahoteleiro.model.Cliente;
import br.com.sistemahoteleiro.model.Contato;
import br.com.sistemahoteleiro.model.Endereco;
import br.com.sistemahoteleiro.model.Funcionario;
import br.com.sistemahoteleiro.model.Log;
import br.com.sistemahoteleiro.model.Parcela;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaJuridica;
import br.com.sistemahoteleiro.model.Quarto;
import br.com.sistemahoteleiro.model.Reserva;
import br.com.sistemahoteleiro.model.SuperUsuario;
import br.com.sistemahoteleiro.model.Usuario;

/**
 * @author ayrtons
 *
 */
public interface IFacade {

	/**
	 * Métodos da class {@link Administrador}
	 * 
	 * @param administrador
	 * @throws BusinessException
	 */
	public void createOrUpdateAdministrador(Administrador administrador) throws BusinessException;

	/**
	 * @param administrador
	 * @param id
	 * @return {@link Administrador}
	 * @throws BusinessException
	 */
	public Administrador searchAdministrador(Administrador administrador, int id) throws BusinessException;

	/**
	 * @param administrador
	 * @return {@link Administrador}
	 * @throws BusinessException
	 */
	public List<Administrador> searchAllAdministrador() throws BusinessException;

	/**
	 * @param administrador
	 * @throws BusinessException
	 */
	public void removeAdministrador(Administrador administrador) throws BusinessException;

	/**
	 * @param administrador
	 * @throws BusinessException
	 */
	public void disableAdministrador(Administrador administrador) throws BusinessException;

	//Aluga

	public void createOrUpdateAluga(Aluga aluga) throws BusinessException;

	public Aluga searchAluga(Aluga aluga, int id) throws BusinessException;

	public List<Aluga> searchAllAluga() throws BusinessException;

	public void removeAluga(Aluga aluga) throws BusinessException;

	public void disableAluga(Aluga aluga) throws BusinessException;

	//Caixa

	public void createOrUpdateCaixa(Caixa caixa) throws BusinessException;

	public Caixa searchCaixa(Caixa caixa, int id) throws BusinessException;

	public List<Caixa> searchAllCaixa() throws BusinessException;

	public void removeCaixa(Caixa caixa) throws BusinessException;

	public void disableCaixa(Caixa caixa) throws BusinessException;

	//Contato

	public void createOrUpdateContato(Contato contato) throws BusinessException;

	public Contato searchContato(Contato contato, int id) throws BusinessException;

	public List<Contato> searchAllContato() throws BusinessException;

	public void removeContato(Contato contato) throws BusinessException;

	public void disableContato(Contato contato) throws BusinessException;

	//Endereco

	public void createOrUpdateEndereco(Endereco endereco) throws BusinessException;

	public Endereco searchEndereco(Endereco endereco, int id) throws BusinessException;

	public List<Endereco> searchAllEndereco() throws BusinessException;

	public void removeEndereco(Endereco endereco) throws BusinessException;

	public void disableEndereco(Endereco endereco) throws BusinessException;

	//Funcionario

	public void createOrUpdateFuncionario(Funcionario funcionario) throws BusinessException;

	public Funcionario searchFuncionario(Funcionario funcionario, int id) throws BusinessException;

	public List<Funcionario> searchAllFuncionario() throws BusinessException;

	public void removeFuncionario(Funcionario funcionario) throws BusinessException;

	public void disableFuncionario(Funcionario funcionario) throws BusinessException;

	//Log

	public void createOrUpdateLog(Log log) throws BusinessException;

	public Log searchLog(Log log, int id) throws BusinessException;

	public List<Log> searchAllLog() throws BusinessException;

	public void removeLog(Log log) throws BusinessException;

	public void disableLog(Log log) throws BusinessException;

	//Parcela

	public void createOrUpdateParcela(Parcela parcela) throws BusinessException;

	public Parcela searchParcela(Parcela parcela, int id) throws BusinessException;

	public List<Parcela> searchAllParcela() throws BusinessException;

	public void removeParcela(Parcela parcela) throws BusinessException;

	public void disableParcela(Parcela parcela) throws BusinessException;

	//PessoaFisica

	public void createOrUpdatePessoaFisica(PessoaFisica pessoaFisica) throws BusinessException;

	public PessoaFisica searchPessoaFisica(int id) throws BusinessException;

	public List<PessoaFisica> searchAllPessoaFisica() throws BusinessException;

	public void removePessoaFisica(PessoaFisica pessoaFisica) throws BusinessException;

	public void disablePessoaFisica(PessoaFisica pessoaFisica) throws BusinessException;

	//PessoaJurida

	public void createOrUpdatePessoaJuridica(PessoaJuridica pessoaJuridica) throws BusinessException;

	public PessoaJuridica searchPessoaJuridica(PessoaJuridica pessoaJuridica, int id) throws BusinessException;

	public List<PessoaJuridica> searchAllPessoaJuridica() throws BusinessException;

	public void removePessoaJuridica(PessoaJuridica pessoaJuridica) throws BusinessException;

	public void disablePessoaJuridica(PessoaJuridica pessoaJuridica) throws BusinessException;

	//Quarto

	public void createOrUpdateQuarto(Quarto quarto) throws BusinessException;

	public Quarto searchQuarto(Quarto quarto, int id) throws BusinessException;

	public List<Quarto> searchAllQuarto() throws BusinessException;

	public void removeQuarto(Quarto quarto) throws BusinessException;

	public void disableQuarto(Quarto quarto) throws BusinessException;

	//Reserva

	public void createOrUpdateReserva(Reserva reserva) throws BusinessException;

	public Reserva searchReserva(Reserva reserva, int id) throws BusinessException;

	public List<Reserva> searchAllReserva() throws BusinessException;

	public void removeReserva(Reserva reserva) throws BusinessException;

	public void disableReserva(Reserva reserva) throws BusinessException;

	//SuperUsuario

	public void createOrUpdateSuperUsuario(SuperUsuario superUsuario) throws BusinessException;

	public SuperUsuario searchSuperUsuario(SuperUsuario superUsuario, int id) throws BusinessException;

	public List<SuperUsuario> searchAllSuperUsuario() throws BusinessException;

	public void removeSuperUsuario(SuperUsuario superUsuario) throws BusinessException;

	public void disableSuperUsuario(SuperUsuario superUsuario) throws BusinessException;

	//Cliente
	
	public void createOrUpdateCliente(Cliente cliente) throws BusinessException;
	
	public Cliente searchCliente(Cliente cliente, int id) throws BusinessException;

	public List<Cliente> searchAllCliente() throws BusinessException;

	public void removeCliente(Cliente cliente) throws BusinessException;

	public void disableCliente(Cliente cliente) throws BusinessException;

	
	//Usuario

	public void createOrUpdateUsuario(Usuario usuario) throws BusinessException;
	
	public Usuario searchUsuario(Usuario usuario, int id) throws BusinessException;

	public List<Usuario> searchAllUsuario() throws BusinessException;

	public void removeUsuario(Usuario usuario) throws BusinessException;

	public void disableUsuario(Usuario usuario) throws BusinessException;

	
}
