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

	@Override
	public void createOrUpdateAdministrador(Administrador administrador) throws BusinessException {
		// TODO Auto-generated method stub
		businessAdministrador.createOrUpdate(administrador);
	}

	@Override
	public Administrador searchAdministrador(Administrador administrador, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrador> searchAllAdministrador(Administrador administrador) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAdministrador(Administrador administrador) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableAdministrador(Administrador administrador) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdateAluga(Aluga aluga) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Aluga searchAluga(Aluga aluga, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluga> searchAllAluga(Aluga aluga) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAluga(Aluga aluga) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableAluga(Aluga aluga) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdateCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Caixa searchCaixa(Caixa caixa, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caixa> searchAllCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdateContato(Contato contato) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contato searchContato(Contato contato, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> searchAllContato(Contato contato) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeContato(Contato contato) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableContato(Contato contato) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdateEndereco(Endereco endereco) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco searchEndereco(Endereco endereco, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> searchAllEndereco(Endereco endereco) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEndereco(Endereco endereco) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableEndereco(Endereco endereco) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdateFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario searchFuncionario(Funcionario funcionario, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> searchAllFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdateLog(Log log) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Log searchLog(Log log, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log> searchAllLog(Log log) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLog(Log log) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableLog(Log log) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdateParcela(Parcela parcela) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Parcela searchParcela(Parcela parcela, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parcela> searchAllParcela(Parcela parcela) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeParcela(Parcela parcela) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableParcela(Parcela parcela) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdatePessoaFisica(PessoaFisica pessoaFisica) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PessoaFisica searchPessoaFisica(PessoaFisica pessoaFisica, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaFisica> searchAllPessoaFisica(PessoaFisica pessoaFisica) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePessoaFisica(PessoaFisica pessoaFisica) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disablePessoaFisica(PessoaFisica pessoaFisica) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdatePessoaJuridica(PessoaJuridica pessoaJuridica) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PessoaJuridica searchPessoaJuridica(PessoaJuridica pessoaJuridica, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaJuridica> searchAllPessoaJuridica(PessoaJuridica pessoaJuridica) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePessoaJuridica(PessoaJuridica pessoaJuridica) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disablePessoaJuridica(PessoaJuridica pessoaJuridica) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdateQuarto(Quarto quarto) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Quarto searchQuarto(Quarto quarto, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quarto> searchAllQuarto(Quarto quarto) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeQuarto(Quarto quarto) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableQuarto(Quarto quarto) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdateReserva(Reserva reserva) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reserva searchReserva(Reserva reserva, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reserva> searchAllReserva(Reserva reserva) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeReserva(Reserva reserva) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableReserva(Reserva reserva) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrUpdateSuperUsuario(SuperUsuario superUsuario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SuperUsuario searchSuperUsuario(SuperUsuario superUsuario, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SuperUsuario> searchAllSuperUsuario(SuperUsuario superUsuario) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSuperUsuario(SuperUsuario superUsuario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableSuperUsuario(SuperUsuario superUsuario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
