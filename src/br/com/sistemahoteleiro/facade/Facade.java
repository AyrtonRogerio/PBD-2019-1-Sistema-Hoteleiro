/**
 * 
 */
package br.com.sistemahoteleiro.facade;

import java.time.LocalDate;
import java.util.List;

import br.com.sistemahoteleiro.business.BusinessAdministrador;
import br.com.sistemahoteleiro.business.BusinessAluga;
import br.com.sistemahoteleiro.business.BusinessCaixa;
import br.com.sistemahoteleiro.business.BusinessCliente;
import br.com.sistemahoteleiro.business.BusinessContato;
import br.com.sistemahoteleiro.business.BusinessEndereco;
import br.com.sistemahoteleiro.business.BusinessFuncionario;
//import br.com.sistemahoteleiro.business.BusinessLog;
import br.com.sistemahoteleiro.business.BusinessParcela;
import br.com.sistemahoteleiro.business.BusinessPessoaFisica;
import br.com.sistemahoteleiro.business.BusinessPessoaJuridica;
import br.com.sistemahoteleiro.business.BusinessQuarto;
import br.com.sistemahoteleiro.business.BusinessReserva;
import br.com.sistemahoteleiro.business.BusinessSuperUsuario;
import br.com.sistemahoteleiro.business.BusinessUsuario;
import br.com.sistemahoteleiro.business.IBusinessAdministrador;
import br.com.sistemahoteleiro.business.IBusinessAluga;
import br.com.sistemahoteleiro.business.IBusinessCaixa;
import br.com.sistemahoteleiro.business.IBusinessCliente;
import br.com.sistemahoteleiro.business.IBusinessContato;
import br.com.sistemahoteleiro.business.IBusinessEndereco;
import br.com.sistemahoteleiro.business.IBusinessFuncionario;
//import br.com.sistemahoteleiro.business.IBusinessLog;
import br.com.sistemahoteleiro.business.IBusinessParcela;
import br.com.sistemahoteleiro.business.IBusinessPessoaFisica;
import br.com.sistemahoteleiro.business.IBusinessPessoaJuridica;
import br.com.sistemahoteleiro.business.IBusinessQuarto;
import br.com.sistemahoteleiro.business.IBusinessReserva;
import br.com.sistemahoteleiro.business.IBusinessSuperUsuario;
import br.com.sistemahoteleiro.business.IBusinessUsuario;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.Administrador;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaPessoaFisicaView;
import br.com.sistemahoteleiro.model.AlugaPessoaJuridicaView;
import br.com.sistemahoteleiro.model.Caixa;
import br.com.sistemahoteleiro.model.CaixaView;
import br.com.sistemahoteleiro.model.Cliente;
import br.com.sistemahoteleiro.model.Contato;
import br.com.sistemahoteleiro.model.Endereco;
import br.com.sistemahoteleiro.model.Funcionario;
import br.com.sistemahoteleiro.model.Log;
import br.com.sistemahoteleiro.model.Parcela;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaFisicaView;
import br.com.sistemahoteleiro.model.PessoaJuridica;
import br.com.sistemahoteleiro.model.PessoaJuridicaView;
import br.com.sistemahoteleiro.model.Quarto;
import br.com.sistemahoteleiro.model.QuartoView;
import br.com.sistemahoteleiro.model.Reserva;
import br.com.sistemahoteleiro.model.ReservaViewFisica;
import br.com.sistemahoteleiro.model.SuperUsuario;
import br.com.sistemahoteleiro.model.Usuario;

/**
 * @author ayrtons
 *
 */
public class Facade implements IFacade {

	
	private static Facade instance;
	
	/**
	 * @author ayrtons
	 * @return {@link Facade}
	 */
	public static Facade getInstance() {
		
		if(instance == null) {
			instance = new Facade();
		}
		return instance;
	}
	
	private IBusinessAdministrador businessAdministrador;
	private IBusinessAluga businessAluga;
	private IBusinessCaixa businessCaixa;
	private IBusinessContato businessContato;
	private IBusinessEndereco businessEndereco;
	private IBusinessFuncionario businessFuncionario;
//	private IBusinessLog businessLog;
	private IBusinessParcela businessParcela;
	private IBusinessPessoaFisica businessPessoaFisica;
	private IBusinessPessoaJuridica businessPessoaJuridica;
	private IBusinessQuarto businessQuarto;
	private IBusinessReserva businessReserva;
	private IBusinessSuperUsuario businessSuperUsuario;
	private IBusinessCliente businessCliente;
	private IBusinessUsuario businessUsuario;
	
	private Facade() {
		
		businessAdministrador = new BusinessAdministrador();
		businessAluga = new BusinessAluga();
		businessCaixa = new BusinessCaixa();
		businessContato = new BusinessContato();
		businessEndereco = new BusinessEndereco();
		businessFuncionario = new BusinessFuncionario();
//		businessLog = new BusinessLog();
		businessParcela = new BusinessParcela();
		businessPessoaFisica = new BusinessPessoaFisica();
		businessPessoaJuridica = new BusinessPessoaJuridica();
		businessQuarto = new BusinessQuarto();
		businessReserva = new BusinessReserva();
		businessSuperUsuario = new BusinessSuperUsuario();
		businessCliente = new BusinessCliente();
		businessUsuario = new BusinessUsuario();
		
	}

	//Administrador
	
	@Override
	public void createOrUpdateAdministrador(Administrador administrador) throws BusinessException {
		// TODO Auto-generated method stub
		businessAdministrador.createOrUpdate(administrador);
	}

	@Override
	public Administrador searchAdministrador(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessAdministrador.search(Administrador.class, id);
	}

	@Override
	public List<Administrador> searchAllAdministrador() throws BusinessException {
		// TODO Auto-generated method stub
		return businessAdministrador.searchAll();
	}

	@Override
	public void removeAdministrador(Administrador administrador) throws BusinessException {
		// TODO Auto-generated method stub
		businessAdministrador.remove(administrador);
	}

	@Override
	public void disableAdministrador(Administrador administrador) throws BusinessException {
		// TODO Auto-generated method stub
		businessAdministrador.disable(administrador);
	}

	//Aluga
	
	@Override
	public void createOrUpdateAluga(Aluga aluga) throws BusinessException {
		// TODO Auto-generated method stub
		businessAluga.createOrUpdate(aluga);
	}

	@Override
	public Aluga searchAluga(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessAluga.search(Aluga.class, id);
	}

	@Override
	public List<Aluga> searchAllAluga() throws BusinessException {
		// TODO Auto-generated method stub
		return businessAluga.searchAll();
	}

	@Override
	public void removeAluga(Aluga aluga) throws BusinessException {
		// TODO Auto-generated method stub
		businessAluga.remove(aluga);
	}

	@Override
	public void disableAluga(Aluga aluga) throws BusinessException {
		// TODO Auto-generated method stub
		businessAluga.disable(aluga);
	}

	@Override
	public List<AlugaPessoaFisicaView> buscarAlugadosFisicosView(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessAluga.buscarAlugadosFisicosView(busca);
	}

	@Override
	public List<AlugaPessoaJuridicaView> buscarAlugadosJuridicosView(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessAluga.buscarAlugadosJuridicosView(busca);
	}
	
	//Caixa
	
	@Override
	public void createOrUpdateCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		businessCaixa.createOrUpdate(caixa);
	}

	@Override
	public Caixa searchCaixa(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessCaixa.search(Caixa.class, id);
	}

	@Override
	public List<Caixa> searchAllCaixa() throws BusinessException {
		// TODO Auto-generated method stub
		return businessCaixa.searchAll();
	}

	@Override
	public void removeCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		businessCaixa.remove(caixa);
	}

	@Override
	public void disableCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		businessCaixa.disable(caixa);
	}
	
	@Override
	public Caixa buscarCaixaPorData(LocalDate date) throws BusinessException {
		// TODO Auto-generated method stub
		return businessCaixa.buscarPorData(date);
	}

	@Override
	public Caixa buscarCaixaPorAnterior() throws BusinessException {
		// TODO Auto-generated method stub
		return businessCaixa.buscarPorAnterior();
	}
	

	//Contato
	
	@Override
	public void createOrUpdateContato(Contato contato) throws BusinessException {
		// TODO Auto-generated method stub
		businessContato.createOrUpdate(contato);
	}

	@Override
	public Contato searchContato(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessContato.search(Contato.class, id);
	}

	@Override
	public List<Contato> searchAllContato() throws BusinessException {
		// TODO Auto-generated method stub
		return businessContato.searchAll();
	}

	@Override
	public void removeContato(Contato contato) throws BusinessException {
		// TODO Auto-generated method stub
		businessContato.remove(contato);
	}

	@Override
	public void disableContato(Contato contato) throws BusinessException {
		// TODO Auto-generated method stub
		businessContato.disable(contato);
	}

	//Endereco
	
	@Override
	public void createOrUpdateEndereco(Endereco endereco) throws BusinessException {
		// TODO Auto-generated method stub
		businessEndereco.createOrUpdate(endereco);
	}

	@Override
	public Endereco searchEndereco(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessEndereco.search(Endereco.class, id);
	}

	@Override
	public List<Endereco> searchAllEndereco() throws BusinessException {
		// TODO Auto-generated method stub
		return businessEndereco.searchAll();
	}

	@Override
	public void removeEndereco(Endereco endereco) throws BusinessException {
		// TODO Auto-generated method stub
		businessEndereco.remove(endereco);
	}

	@Override
	public void disableEndereco(Endereco endereco) throws BusinessException {
		// TODO Auto-generated method stub
		businessEndereco.disable(endereco);
	}

	//Funcionario
	
	@Override
	public void createOrUpdateFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		businessFuncionario.createOrUpdate(funcionario);
	}

	@Override
	public Funcionario searchFuncionario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessFuncionario.search(Funcionario.class, id);
	}

	@Override
	public List<Funcionario> searchAllFuncionario() throws BusinessException {
		// TODO Auto-generated method stub
		return businessFuncionario.searchAll();
	}

	@Override
	public void removeFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		businessFuncionario.remove(funcionario);
	}

	@Override
	public void disableFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		businessFuncionario.disable(funcionario);
	}

	//Log
	
//	@Override
//	public void createOrUpdateLog(Log log) throws BusinessException {
//		// TODO Auto-generated method stub
//		businessLog.createOrUpdate(log);
//	}
//
//	@Override
//	public Log searchLog(int id) throws BusinessException {
//		// TODO Auto-generated method stub
//		return businessLog.search(Log.class, id);
//	}
//
//	@Override
//	public List<Log> searchAllLog() throws BusinessException {
//		// TODO Auto-generated method stub
//		return businessLog.searchAll();
//	}
//
//	@Override
//	public void removeLog(Log log) throws BusinessException {
//		// TODO Auto-generated method stub
//		businessLog.remove(log);
//	}
//
//	@Override
//	public void disableLog(Log log) throws BusinessException {
//		// TODO Auto-generated method stub
//		businessLog.disable(log);
//	}

	//Parcela
	
	@Override
	public void createOrUpdateParcela(Parcela parcela) throws BusinessException {
		// TODO Auto-generated method stub
		businessParcela.createOrUpdate(parcela);
	}

	@Override
	public Parcela searchParcela(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessParcela.search(Parcela.class, id);
	}

	@Override
	public List<Parcela> searchAllParcela() throws BusinessException {
		// TODO Auto-generated method stub
		return businessParcela.searchAll();
	}

	@Override
	public void removeParcela(Parcela parcela) throws BusinessException {
		// TODO Auto-generated method stub
		businessParcela.remove(parcela);
	}

	@Override
	public void disableParcela(Parcela parcela) throws BusinessException {
		// TODO Auto-generated method stub
		businessParcela.disable(parcela);
	}

	//PessoaFisica
	
	@Override
	public void createOrUpdatePessoaFisica(PessoaFisica pessoaFisica) throws BusinessException {
		// TODO Auto-generated method stub
		businessPessoaFisica.createOrUpdate(pessoaFisica);
	}

	@Override
	public PessoaFisica searchPessoaFisica(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaFisica.search(PessoaFisica.class, id);
	}

	@Override
	public List<PessoaFisica> searchAllPessoaFisica() throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaFisica.searchAll();
	}
	
	@Override
	public List<PessoaFisica> buscarPessoasFisica(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaFisica.buscarTodos(busca);
	}

	@Override
	public List<PessoaFisicaView> buscarPessoasFisicaView(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaFisica.buscarPessoasFisicasView(busca);
	}
	
	@Override
	public void removePessoaFisica(PessoaFisica pessoaFisica) throws BusinessException {
		// TODO Auto-generated method stub
		businessPessoaFisica.remove(pessoaFisica);
	}

	@Override
	public void disablePessoaFisica(PessoaFisica pessoaFisica) throws BusinessException {
		// TODO Auto-generated method stub
		businessPessoaFisica.disable(pessoaFisica);
	}

	//PessoaJuridica
	
	@Override
	public void createOrUpdatePessoaJuridica(PessoaJuridica pessoaJuridica) throws BusinessException {
		// TODO Auto-generated method stub
		businessPessoaJuridica.createOrUpdate(pessoaJuridica);
	}

	@Override
	public PessoaJuridica searchPessoaJuridica(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaJuridica.search(PessoaJuridica.class, id);
	}

	@Override
	public List<PessoaJuridica> searchAllPessoaJuridica() throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaJuridica.searchAll();
	}
	
	@Override
	public List<PessoaJuridica> buscarPessoasJuridica(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaJuridica.searchBuscarTodos(busca);
	}

	@Override
	public List<PessoaJuridicaView> buscarPessoasJuridicasView(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaJuridica.buscarPessoasJuridicasView(busca);
	}
	
	@Override
	public void removePessoaJuridica(PessoaJuridica pessoaJuridica) throws BusinessException {
		// TODO Auto-generated method stub
		businessPessoaJuridica.remove(pessoaJuridica);
	}

	@Override
	public void disablePessoaJuridica(PessoaJuridica pessoaJuridica) throws BusinessException {
		// TODO Auto-generated method stub
		businessPessoaJuridica.disable(pessoaJuridica);
	}

	//Quarto
	
	@Override
	public void createOrUpdateQuarto(Quarto quarto) throws BusinessException {
		// TODO Auto-generated method stub
		businessQuarto.createOrUpdate(quarto);
	}

	@Override
	public Quarto searchQuarto(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessQuarto.search(Quarto.class, id);
	}

	@Override
	public List<Quarto> searchAllQuarto() throws BusinessException {
		// TODO Auto-generated method stub
		return businessQuarto.searchAll();
	}

	@Override
	public List<QuartoView> buscarQuartoViewDisponivel(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessQuarto.buscarDisponivel(busca);
	}
	
	@Override
	public void removeQuarto(Quarto quarto) throws BusinessException {
		// TODO Auto-generated method stub
		businessQuarto.remove(quarto);
	}

	@Override
	public void disableQuarto(Quarto quarto) throws BusinessException {
		// TODO Auto-generated method stub
		businessQuarto.disable(quarto);
	}

	//Reserva
	
	@Override
	public void createOrUpdateReserva(Reserva reserva) throws BusinessException {
		// TODO Auto-generated method stub
		businessReserva.createOrUpdate(reserva);
	}

	@Override
	public Reserva searchReserva(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessReserva.search(Reserva.class, id);
	}

	@Override
	public List<Reserva> searchAllReserva() throws BusinessException {
		// TODO Auto-generated method stub
		return businessReserva.searchAll();
	}

	@Override
	public List<ReservaViewFisica> buscarReservadosFisicosView(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessReserva.buscarReservadosFisicosView(busca);
	}
	
	@Override
	public void removeReserva(Reserva reserva) throws BusinessException {
		// TODO Auto-generated method stub
		businessReserva.remove(reserva);
	}

	@Override
	public void disableReserva(Reserva reserva) throws BusinessException {
		// TODO Auto-generated method stub
		businessReserva.disable(reserva);
	}

	//SuperUsuario
	
	@Override
	public void createOrUpdateSuperUsuario(SuperUsuario superUsuario) throws BusinessException {
		// TODO Auto-generated method stub
		businessSuperUsuario.createOrUpdate(superUsuario);
	}

	@Override
	public SuperUsuario searchSuperUsuario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessSuperUsuario.search(SuperUsuario.class, id);
	}

	@Override
	public List<SuperUsuario> searchAllSuperUsuario() throws BusinessException {
		// TODO Auto-generated method stub
		return businessSuperUsuario.searchAll();
	}

	@Override
	public void removeSuperUsuario(SuperUsuario superUsuario) throws BusinessException {
		// TODO Auto-generated method stub
		businessSuperUsuario.remove(superUsuario);
	}

	@Override
	public void disableSuperUsuario(SuperUsuario superUsuario) throws BusinessException {
		// TODO Auto-generated method stub
		businessSuperUsuario.disable(superUsuario);
	}

	//Cliente
	@Override
	public void createOrUpdateCliente(Cliente cliente) throws BusinessException {
		// TODO Auto-generated method stub
		businessCliente.createOrUpdate(cliente);
	}

	@Override
	public Cliente searchCliente(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessCliente.search(Cliente.class, id);
	}

	@Override
	public List<Cliente> searchAllCliente() throws BusinessException {
		// TODO Auto-generated method stub
		return businessCliente.searchAll();
	}
	
	@Override
	public void removeCliente(Cliente cliente) throws BusinessException {
		// TODO Auto-generated method stub
		businessCliente.remove(cliente);
	}

	@Override
	public void disableCliente(Cliente cliente) throws BusinessException {
		// TODO Auto-generated method stub
		businessCliente.disable(cliente);
	}

	@Override
	public List<Cliente> buscarCliente(String buscar) throws BusinessException {
		// TODO Auto-generated method stub
		return businessCliente.buscarCliente(buscar);
	}
	
	//Usuario
	@Override
	public void createOrUpdateUsuario(Usuario usuario) throws BusinessException {
		// TODO Auto-generated method stub
		businessUsuario.createOrUpdate(usuario);
	}

	@Override
	public Usuario searchUsuario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.search(Usuario.class, id);
	}

	@Override
	public List<Usuario> searchAllUsuario() throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.searchAll();
	}

	@Override
	public void removeUsuario(Usuario usuario) throws BusinessException {
		// TODO Auto-generated method stub
		businessUsuario.remove(usuario);
	}

	@Override
	public void disableUsuario(Usuario usuario) throws BusinessException {
		// TODO Auto-generated method stub
		businessUsuario.disable(usuario);
	}

	@Override
	public Usuario searchLoginUsuario(String login, String senha) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.searchLoginUsuario(login, senha);
	}

	@Override
	public List<Usuario> seearchBuscarTodosUsuario(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessUsuario.searchBuscarTodos(busca);
	}




}
