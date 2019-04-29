/**
 * 
 */
package br.com.sistemahoteleiro.facade;

import java.util.List;

import br.com.sistemahoteleiro.business.BusinessAdministrador;
import br.com.sistemahoteleiro.business.BusinessAluga;
import br.com.sistemahoteleiro.business.BusinessCaixa;
import br.com.sistemahoteleiro.business.BusinessContato;
import br.com.sistemahoteleiro.business.BusinessEndereco;
import br.com.sistemahoteleiro.business.BusinessFuncionario;
import br.com.sistemahoteleiro.business.BusinessLog;
import br.com.sistemahoteleiro.business.BusinessParcela;
import br.com.sistemahoteleiro.business.BusinessPessoaFisica;
import br.com.sistemahoteleiro.business.BusinessPessoaJuridica;
import br.com.sistemahoteleiro.business.BusinessQuarto;
import br.com.sistemahoteleiro.business.BusinessReserva;
import br.com.sistemahoteleiro.business.BusinessSuperUsuario;
import br.com.sistemahoteleiro.business.IBusinessAdministrador;
import br.com.sistemahoteleiro.business.IBusinessAluga;
import br.com.sistemahoteleiro.business.IBusinessCaixa;
import br.com.sistemahoteleiro.business.IBusinessContato;
import br.com.sistemahoteleiro.business.IBusinessEndereco;
import br.com.sistemahoteleiro.business.IBusinessFuncionario;
import br.com.sistemahoteleiro.business.IBusinessLog;
import br.com.sistemahoteleiro.business.IBusinessParcela;
import br.com.sistemahoteleiro.business.IBusinessPessoaFisica;
import br.com.sistemahoteleiro.business.IBusinessPessoaJuridica;
import br.com.sistemahoteleiro.business.IBusinessQuarto;
import br.com.sistemahoteleiro.business.IBusinessReserva;
import br.com.sistemahoteleiro.business.IBusinessSuperUsuario;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.model.Administrador;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.Caixa;
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
	private IBusinessLog businessLog;
	private IBusinessParcela businessParcela;
	private IBusinessPessoaFisica businessPessoaFisica;
	private IBusinessPessoaJuridica businessPessoaJuridica;
	private IBusinessQuarto businessQuarto;
	private IBusinessReserva businessReserva;
	private IBusinessSuperUsuario businessSuperUsuario;
	
	private Facade() {
		
		businessAdministrador = new BusinessAdministrador();
		businessAluga = new BusinessAluga();
		businessCaixa = new BusinessCaixa();
		businessContato = new BusinessContato();
		businessEndereco = new BusinessEndereco();
		businessFuncionario = new BusinessFuncionario();
		businessLog = new BusinessLog();
		businessParcela = new BusinessParcela();
		businessPessoaFisica = new BusinessPessoaFisica();
		businessPessoaJuridica = new BusinessPessoaJuridica();
		businessQuarto = new BusinessQuarto();
		businessReserva = new BusinessReserva();
		businessSuperUsuario = new BusinessSuperUsuario();
		
	}

	//Administrador
	
	@Override
	public void createOrUpdateAdministrador(Administrador administrador) throws BusinessException {
		// TODO Auto-generated method stub
		businessAdministrador.createOrUpdate(administrador);
	}

	@Override
	public Administrador searchAdministrador(Administrador administrador, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessAdministrador.search(Administrador.class, id);
	}

	@Override
	public List<Administrador> searchAllAdministrador(Administrador administrador) throws BusinessException {
		// TODO Auto-generated method stub
		return businessAdministrador.searchAll(Administrador.class);
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
	public Aluga searchAluga(Aluga aluga, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessAluga.search(Aluga.class, id);
	}

	@Override
	public List<Aluga> searchAllAluga(Aluga aluga) throws BusinessException {
		// TODO Auto-generated method stub
		return businessAluga.searchAll(Aluga.class);
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

	//Caixa
	
	@Override
	public void createOrUpdateCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		businessCaixa.createOrUpdate(caixa);
	}

	@Override
	public Caixa searchCaixa(Caixa caixa, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessCaixa.search(Caixa.class, id);
	}

	@Override
	public List<Caixa> searchAllCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		return businessCaixa.searchAll(Caixa.class);
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

	//Contato
	
	@Override
	public void createOrUpdateContato(Contato contato) throws BusinessException {
		// TODO Auto-generated method stub
		businessContato.createOrUpdate(contato);
	}

	@Override
	public Contato searchContato(Contato contato, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessContato.search(Contato.class, id);
	}

	@Override
	public List<Contato> searchAllContato(Contato contato) throws BusinessException {
		// TODO Auto-generated method stub
		return businessContato.searchAll(Contato.class);
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
	public Endereco searchEndereco(Endereco endereco, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessEndereco.search(Endereco.class, id);
	}

	@Override
	public List<Endereco> searchAllEndereco(Endereco endereco) throws BusinessException {
		// TODO Auto-generated method stub
		return businessEndereco.searchAll(Endereco.class);
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
	public Funcionario searchFuncionario(Funcionario funcionario, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessFuncionario.search(Funcionario.class, id);
	}

	@Override
	public List<Funcionario> searchAllFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		return businessFuncionario.searchAll(Funcionario.class);
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
	
	@Override
	public void createOrUpdateLog(Log log) throws BusinessException {
		// TODO Auto-generated method stub
		businessLog.createOrUpdate(log);
	}

	@Override
	public Log searchLog(Log log, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessLog.search(Log.class, id);
	}

	@Override
	public List<Log> searchAllLog(Log log) throws BusinessException {
		// TODO Auto-generated method stub
		return businessLog.searchAll(Log.class);
	}

	@Override
	public void removeLog(Log log) throws BusinessException {
		// TODO Auto-generated method stub
		businessLog.remove(log);
	}

	@Override
	public void disableLog(Log log) throws BusinessException {
		// TODO Auto-generated method stub
		businessLog.disable(log);
	}

	//Parcela
	
	@Override
	public void createOrUpdateParcela(Parcela parcela) throws BusinessException {
		// TODO Auto-generated method stub
		businessParcela.createOrUpdate(parcela);
	}

	@Override
	public Parcela searchParcela(Parcela parcela, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessParcela.search(Parcela.class, id);
	}

	@Override
	public List<Parcela> searchAllParcela(Parcela parcela) throws BusinessException {
		// TODO Auto-generated method stub
		return businessParcela.searchAll(Parcela.class);
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
	public PessoaFisica searchPessoaFisica(PessoaFisica pessoaFisica, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaFisica.search(PessoaFisica.class, id);
	}

	@Override
	public List<PessoaFisica> searchAllPessoaFisica(PessoaFisica pessoaFisica) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaFisica.searchAll(PessoaFisica.class);
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
	public PessoaJuridica searchPessoaJuridica(PessoaJuridica pessoaJuridica, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaJuridica.search(PessoaJuridica.class, id);
	}

	@Override
	public List<PessoaJuridica> searchAllPessoaJuridica(PessoaJuridica pessoaJuridica) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPessoaJuridica.searchAll(PessoaJuridica.class);
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
	public Quarto searchQuarto(Quarto quarto, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessQuarto.search(Quarto.class, id);
	}

	@Override
	public List<Quarto> searchAllQuarto(Quarto quarto) throws BusinessException {
		// TODO Auto-generated method stub
		return businessQuarto.searchAll(Quarto.class);
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
	public Reserva searchReserva(Reserva reserva, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessReserva.search(Reserva.class, id);
	}

	@Override
	public List<Reserva> searchAllReserva(Reserva reserva) throws BusinessException {
		// TODO Auto-generated method stub
		return businessReserva.searchAll(Reserva.class);
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
	public SuperUsuario searchSuperUsuario(SuperUsuario superUsuario, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessSuperUsuario.search(SuperUsuario.class, id);
	}

	@Override
	public List<SuperUsuario> searchAllSuperUsuario(SuperUsuario superUsuario) throws BusinessException {
		// TODO Auto-generated method stub
		return businessSuperUsuario.searchAll(SuperUsuario.class);
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
	
	
	
}
