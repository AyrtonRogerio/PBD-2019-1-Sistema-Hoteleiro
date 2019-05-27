/**
 * 
 */
package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import br.com.sistemahoteleiro.enuns.TipoEstadoCivil;
import br.com.sistemahoteleiro.enuns.TipoEstadoUF;
import br.com.sistemahoteleiro.enuns.TipoOcupacao;
import br.com.sistemahoteleiro.enuns.TipoSexo;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.facade.Facade;
import br.com.sistemahoteleiro.model.Cliente;
import br.com.sistemahoteleiro.model.Contato;
import br.com.sistemahoteleiro.model.Endereco;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaJuridica;
import br.com.sistemahoteleiro.util.MaskFieldUtil;
import br.com.sistemahoteleiro.view.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

/**
 * @author ayrton
 *
 */
public class ControlerCliente implements Initializable {

//	private Cliente clienteFisico, clienteJuridico, clienteAtualiza;
	private PessoaFisica clienteFisico, fisica;
	private PessoaJuridica clienteJuridico, juridica;
	private Cliente clienteAtualiza;
	private List<PessoaFisica> pessoaFisicas;
	private List<PessoaJuridica> pessoaJuridicas;

	private Endereco enderecoFisico, enderecoJuridico;
	private Contato contatoFisico, contatoJuridico;

	@FXML
	private Tab listaClienteTab;

	@FXML
	private JFXTextField buscCliField;

	@FXML
	private JFXButton buscCliBtn;

	@FXML
	private JFXButton novoCliBtn;

	@FXML
	private JFXButton atualizarTabelaBtn;

	@FXML
	private JFXRadioButton cliFisiRadio;

	@FXML
	private JFXRadioButton cliJuriRadio;

	@FXML
	private Tab cliFisiTab;

	@FXML
	private TableView<PessoaFisica> cliTabela;

	@FXML
	private TableColumn<PessoaFisica, String> nomeCliCol;

	@FXML
	private TableColumn<PessoaFisica, String> cpfCliCol;

	@FXML
	private TableColumn<PessoaFisica, Endereco> ruaCliCol;

	@FXML
	private TableColumn<PessoaFisica, Endereco> bairroCliCol;

	@FXML
	private TableColumn<PessoaFisica, Endereco> numCliCol;

	@FXML
	private Tab cliJuriTab;

	@FXML
	private TableView<PessoaJuridica> cliJuriTabela;

	@FXML
	private TableColumn<PessoaJuridica, String> nomeCliJuriCol;

	@FXML
	private TableColumn<PessoaJuridica, String> cnpjJuriCol;

	@FXML
	private TableColumn<PessoaJuridica, Endereco> ruaCliJuriCol;

	@FXML
	private TableColumn<PessoaJuridica, Endereco> bairroCliJuriCol;

	@FXML
	private TableColumn<PessoaJuridica, Endereco> numCliJuriCol;

	@FXML
	private JFXButton detalhesCliBtn;

	@FXML
	private JFXButton editarCliBtn;

	@FXML
	private Tab dadosCliTab;

	@FXML
	private RadioButton pessFisRadBtn;

	@FXML
	private RadioButton pessJurRadBtn;

	@FXML
	private JFXButton voltarCliBtn;

	@FXML
	private JFXButton contCliBtn;

	@FXML
	private GridPane CliJuriGridLay;

	@FXML
	private JFXTextField razaoSociCliField;

	@FXML
	private JFXTextField cnpjCliField;

	@FXML
	private JFXTextField nomeCliField;
	@FXML
	private JFXCheckBox statusClienteCBox;

	@FXML
	private GridPane CliFisGridLay;

	@FXML
	private JFXTextField cpfCliField;

	@FXML
	private JFXDatePicker dataCli;

	@FXML
	private JFXComboBox<TipoSexo> sexoCliCobBox;

	@FXML
	private JFXComboBox<TipoEstadoCivil> estadCivCliCobBox;

	@FXML
	private JFXComboBox<TipoOcupacao> ocupacaoCliCobBox;
	@FXML
	private JFXTextField rgCliField;

	@FXML
	private Tab endClienteTab;

	@FXML
	private JFXTextField ruaEndCliField;

	@FXML
	private JFXTextField cepEndCliField;

	@FXML
	private JFXTextField numEndCliField;

	@FXML
	private JFXTextField bairroEndCliField;

	@FXML
	private JFXTextField cidadeEndCliField;

	@FXML
	private JFXComboBox<TipoEstadoUF> ufEndCliCobBox;
	@FXML
	private JFXCheckBox statusEnderecoCBox;

	@FXML
	private JFXButton voltarEndCliBtn;

	@FXML
	private JFXButton continEndCliBtn;

	@FXML
	private Tab contClienteTab;

	@FXML
	private JFXTextField celularContCliField;

	@FXML
	private JFXTextField foneContCliField;

	@FXML
	private JFXTextField emailContCliField;

	@FXML
	private JFXCheckBox statusContatoCBox;

	@FXML
	private JFXButton voltarContCliBtn;

	@FXML
	private JFXButton cadastCliBtn;

	@FXML
	private JFXButton atualizarCliBtn;

	@FXML
	void action(ActionEvent event) {

		/**
		 * Evento para buscar clientes.
		 */
		if (event.getSource() == buscCliBtn && (cliFisiRadio.isSelected() || cliJuriRadio.isSelected())) {

			if (cliFisiRadio.isSelected()) {
				cliJuriRadio.setSelected(false);
				try {
					pessoaFisicas = Facade.getInstance().seearchBuscarTodosPessoasFisica(buscCliField.getText());
					cliTabela.getItems().setAll(pessoaFisicas);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (cliJuriRadio.isSelected()) {

				cliJuriRadio.setSelected(false);
				try {
					pessoaJuridicas = Facade.getInstance().searchBuscarTodosPessoasJuridica(buscCliField.getText());
					cliTabela.getItems().setAll(pessoaFisicas);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		/**
		 * Evento para atualizar Tabela dos clientes.
		 */
		if (event.getSource() == atualizarTabelaBtn) {

		}

		/**
		 * Evento para editar cliente selecionado da tabela.
		 */
		if (event.getSource() == editarCliBtn) {

			cadastCliBtn.setDisable(true);
			atualizarCliBtn.setDisable(false);
			if(cliFisiRadio.isSelected()) {
			preencherCamposFisico();
			} else if(cliJuriRadio.isSelected()) {
				preencherCamposJuridicos();
			}
			dadosCliTab.setDisable(false);
			dadosCliTab.getTabPane().getSelectionModel().select(dadosCliTab);

		}

		/**
		 * Evento para cadastrar novo cliente, liber o Tab Dados gerais para preencher.
		 */
		if (event.getSource() == novoCliBtn) {

			cadastCliBtn.setDisable(false);
			atualizarCliBtn.setDisable(true);

			dadosCliTab.setDisable(false);
			dadosCliTab.getTabPane().getSelectionModel().select(dadosCliTab);

		}

		/**
		 * Evento para habilitar cliente físico e desabilitar cliente jurídico.
		 */
		if (event.getSource() == pessFisRadBtn) {
			if (pessFisRadBtn.isSelected()) {
				pessJurRadBtn.setSelected(false);
				CliJuriGridLay.setDisable(true);
				CliFisGridLay.setDisable(false);
			}
		}

		/**
		 * Evento para habilitar cliente jurídico e desabilitar cliente físico.
		 */
		if (event.getSource() == pessJurRadBtn) {
			if (pessJurRadBtn.isSelected()) {
				pessFisRadBtn.setSelected(false);
				CliFisGridLay.setDisable(true);
				CliJuriGridLay.setDisable(false);

			}
		}

		
		/**
		 * Evento para habilitar cliente físico e desabilitar cliente jurídico de pesquisa.
		 */
		if (event.getSource() == cliFisiRadio) {
			if (pessFisRadBtn.isSelected()) {
				cliJuriRadio.setSelected(false);
				cliFisiRadio.setSelected(true);
			}
		}

		/**
		 * Evento para habilitar cliente jurídico e desabilitar cliente físico de pesquisa.
		 */
		if (event.getSource() == cliJuriRadio) {
			if (cliJuriRadio.isSelected()) {
				cliFisiRadio.setSelected(false);
				cliJuriRadio.setSelected(true);
				

			}
		}

		
		
		/**
		 * Evento para voltar para a Lista de Clientes
		 */
		if (event.getSource() == voltarCliBtn) {

			dadosCliTab.setDisable(true);
			endClienteTab.setDisable(true);
			contClienteTab.setDisable(true);
			listaClienteTab.getTabPane().getSelectionModel().select(listaClienteTab);

		}

		/**
		 * Evento para ir para o Tab Endereço
		 */
		if (event.getSource() == contCliBtn) {

			endClienteTab.setDisable(false);
			endClienteTab.getTabPane().getSelectionModel().select(endClienteTab);

		}

		/**
		 * Evento para voltar para o Tab Dados Gerais
		 */
		if (event.getSource() == voltarEndCliBtn) {

			endClienteTab.setDisable(true);
			contClienteTab.setDisable(true);
			dadosCliTab.getTabPane().getSelectionModel().select(dadosCliTab);

		}

		/**
		 * Evento para ir para o Tab Contatos
		 */
		if (event.getSource() == continEndCliBtn) {

			contClienteTab.setDisable(false);
			contClienteTab.getTabPane().getSelectionModel().select(contClienteTab);

		}

		/**
		 * Evento para voltar para o Tab Endereço
		 */
		if (event.getSource() == voltarContCliBtn) {

			contClienteTab.setDisable(true);
			endClienteTab.getTabPane().getSelectionModel().select(endClienteTab);

		}

		/**
		 * Evento pra cadastrar o cliente
		 */
		if (event.getSource() == cadastCliBtn) {

			if (pessFisRadBtn.isSelected()) {

				cadastrarClienteFisico();

				dadosCliTab.setDisable(true);
				endClienteTab.setDisable(true);
				contClienteTab.setDisable(true);
				listaClienteTab.getTabPane().getSelectionModel().select(listaClienteTab);

			} else if (pessJurRadBtn.isSelected()) {

				cadastrarClienteJuridico();

				dadosCliTab.setDisable(true);
				endClienteTab.setDisable(true);
				contClienteTab.setDisable(true);
				listaClienteTab.getTabPane().getSelectionModel().select(listaClienteTab);

			}

			try

			{
				pessoaFisicas = Facade.getInstance().searchAllPessoaFisica();
				cliTabela.getItems().setAll(pessoaFisicas);
				
				pessoaJuridicas = Facade.getInstance().searchAllPessoaJuridica();
				cliJuriTabela.getItems().setAll(pessoaJuridicas);
				
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		/**
		 * Evento pra atualizar o cliente
		 */
		if (event.getSource() == atualizarCliBtn) {
			cadastCliBtn.setDisable(false);
			atualizarCliBtn.setDisable(true);

			atualizarCliente(clienteAtualiza);

			dadosCliTab.setDisable(true);
			endClienteTab.setDisable(true);
			contClienteTab.setDisable(true);
			listaClienteTab.getTabPane().getSelectionModel().select(listaClienteTab);

			try

			{
				pessoaFisicas = Facade.getInstance().searchAllPessoaFisica();
				cliTabela.getItems().setAll(pessoaFisicas);
				
				pessoaJuridicas = Facade.getInstance().searchAllPessoaJuridica();
				cliJuriTabela.getItems().setAll(pessoaJuridicas);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comboBoxTabela();
		mascarasField();

	}

	/**
	 * Método para cadastrar um cliente físico.
	 */
	public void cadastrarClienteFisico() {

		enderecoFisico = new Endereco();

		enderecoFisico.setBairro(bairroEndCliField.getText());
		enderecoFisico.setCep(cepEndCliField.getText());
		enderecoFisico.setCidade(cidadeEndCliField.getText());
		enderecoFisico.setLogradouro(ruaEndCliField.getText());
		enderecoFisico.setNumero(numEndCliField.getText());
		enderecoFisico.setStatus(statusEnderecoCBox.isSelected());
		enderecoFisico.setUf(ufEndCliCobBox.getValue());

		contatoFisico = new Contato();

		contatoFisico.setCelular(celularContCliField.getText());
		contatoFisico.setTelefone(foneContCliField.getText());
		contatoFisico.setEmail(emailContCliField.getText());
		contatoFisico.setStatus(statusContatoCBox.isSelected());

		clienteFisico = new PessoaFisica();

		clienteFisico.setNome(nomeCliField.getText());
		clienteFisico.setCpf(cpfCliField.getText());
		clienteFisico.setData_nascimento(dataCli.getValue());
		clienteFisico.setEndereco(enderecoFisico);
		clienteFisico.setContato(contatoFisico);
		clienteFisico.setEstado_civil(estadCivCliCobBox.getValue());
		clienteFisico.setOcupacao(ocupacaoCliCobBox.getValue());
		clienteFisico.setRg(rgCliField.getText());
		clienteFisico.setSexo(sexoCliCobBox.getValue());
		clienteFisico.setStatus(statusClienteCBox.isSelected());

		try {

			Facade.getInstance().createOrUpdatePessoaFisica(clienteFisico);

			Message.getInstance().viewMessage(AlertType.CONFIRMATION, "Cadastrado", "Cliente foi cadastrado!",
					"O cliente foi cadastrado com sucesso!");

			pessoaFisicas = Facade.getInstance().searchAllPessoaFisica();
			cliTabela.getItems().setAll(pessoaFisicas);

			dadosCliTab.setDisable(true);
			endClienteTab.setDisable(true);
			contClienteTab.setDisable(true);
			listaClienteTab.getTabPane().getSelectionModel().select(listaClienteTab);

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao salvar a pessoa física",
					e.getMessage());
		}

	}

	/**
	 * Método para cadastrar um cliente jurídico
	 */
	public void cadastrarClienteJuridico() {

		enderecoJuridico = new Endereco();

		enderecoJuridico.setBairro(bairroEndCliField.getText());
		enderecoJuridico.setCep(cepEndCliField.getText());
		enderecoJuridico.setCidade(cidadeEndCliField.getText());
		enderecoJuridico.setLogradouro(ruaEndCliField.getText());
		enderecoJuridico.setNumero(numEndCliField.getText());
		enderecoJuridico.setStatus(statusEnderecoCBox.isSelected());
		enderecoJuridico.setUf(ufEndCliCobBox.getValue());

		contatoJuridico = new Contato();

		contatoJuridico.setCelular(celularContCliField.getText());
		contatoJuridico.setTelefone(foneContCliField.getText());
		contatoJuridico.setEmail(emailContCliField.getText());
		contatoJuridico.setStatus(statusContatoCBox.isSelected());

		clienteJuridico = new PessoaJuridica();

		clienteJuridico.setNome(nomeCliField.getText());
		clienteJuridico.setCnpj(cnpjCliField.getText());
		clienteJuridico.setContato(contatoJuridico);
		clienteJuridico.setEndereco(enderecoJuridico);
		clienteJuridico.setRazaoSocial(razaoSociCliField.getText());
		clienteJuridico.setStatus(statusClienteCBox.isSelected());

		try {

			Facade.getInstance().createOrUpdatePessoaJuridica(clienteJuridico);

			Message.getInstance().viewMessage(AlertType.CONFIRMATION, "Cadastrado", "Cliente foi cadastrado!",
					"O cliente foi cadastrado com sucesso!");

			pessoaJuridicas = Facade.getInstance().searchAllPessoaJuridica();
			cliJuriTabela.getItems().setAll(pessoaJuridicas);

			dadosCliTab.setDisable(true);
			endClienteTab.setDisable(true);
			contClienteTab.setDisable(true);
			listaClienteTab.getTabPane().getSelectionModel().select(listaClienteTab);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao salvar a pessoa física",
					e.getMessage());
		}

	}

	/**
	 * Método para preencher campos para atualizar o cliente físico.
	 */
	public void preencherCamposFisico() {

		clienteAtualiza = cliTabela.getSelectionModel().getSelectedItem();

		if (clienteAtualiza instanceof PessoaFisica) {

			CliFisGridLay.setDisable(false);
			CliJuriGridLay.setDisable(true);

			try {

				fisica = Facade.getInstance().searchPessoaFisica(clienteAtualiza.getId());

				System.out.println(fisica.getCpf());
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao buscar a pessoa física",
						e.getMessage());
			}

			nomeCliField.setText(fisica.getNome());
			cpfCliField.setText(fisica.getCpf());
			dataCli.setValue(fisica.getData_nascimento());

			estadCivCliCobBox.setValue(fisica.getEstado_civil());
			ocupacaoCliCobBox.setValue(fisica.getOcupacao());
			rgCliField.setText(fisica.getRg());
			sexoCliCobBox.setValue(fisica.getSexo());
			statusClienteCBox.setSelected(fisica.isStatus());

			// Endereco
			bairroEndCliField.setText(fisica.getEndereco().getBairro());
			cepEndCliField.setText(fisica.getEndereco().getCep());
			cidadeEndCliField.setText(fisica.getEndereco().getCidade());
			ruaEndCliField.setText(fisica.getEndereco().getLogradouro());
			numEndCliField.setText(fisica.getEndereco().getNumero());
			statusEnderecoCBox.setSelected(fisica.getEndereco().isStatus());
			ufEndCliCobBox.setValue(fisica.getEndereco().getUf());

			// Contato
			celularContCliField.setText(fisica.getContato().getCelular());
			foneContCliField.setText(fisica.getContato().getTelefone());
			emailContCliField.setText(fisica.getContato().getEmail());
			statusContatoCBox.setSelected(fisica.getContato().isStatus());

		}

		

	}
	
	/**
	 * Método para preencher campos para atualizar o cliente físico.
	 */
	public void preencherCamposJuridicos() {
		
		
		clienteAtualiza = cliJuriTabela.getSelectionModel().getSelectedItem();
		
		if (clienteAtualiza instanceof PessoaJuridica) {

			// Pane da pessoa Jurídica habilitado, pane da pessoa física desabilitado
			CliFisGridLay.setDisable(false);
			CliJuriGridLay.setDisable(true);

			try {

				juridica = Facade.getInstance().searchPessoaJuridica(clienteAtualiza.getId());

			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao buscar a pessoa jurídica",
						e.getMessage());
			}

			// Pessoa Jurídica
			nomeCliField.setText(juridica.getNome());
			cnpjCliField.setText(juridica.getCnpj());
			razaoSociCliField.setText(juridica.getRazaoSocial());
			statusClienteCBox.setSelected(juridica.isStatus());

			// Endereco
			bairroEndCliField.setText(juridica.getEndereco().getBairro());
			cepEndCliField.setText(juridica.getEndereco().getCep());
			cidadeEndCliField.setText(juridica.getEndereco().getCidade());
			ruaEndCliField.setText(juridica.getEndereco().getLogradouro());
			numEndCliField.setText(juridica.getEndereco().getNumero());
			statusEnderecoCBox.setSelected(juridica.getEndereco().isStatus());
			ufEndCliCobBox.setValue(juridica.getEndereco().getUf());

			// Contato
			celularContCliField.setText(juridica.getContato().getCelular());
			foneContCliField.setText(juridica.getContato().getTelefone());
			emailContCliField.setText(juridica.getContato().getEmail());
			statusContatoCBox.setSelected(juridica.getContato().isStatus());

		}
		
	}

	/**
	 * Método para atualizar cliente selecionado da tabela.
	 * 
	 * @param c
	 */
	public void atualizarCliente(Cliente c) {

		if (c instanceof PessoaFisica) {
			PessoaFisica cF = (PessoaFisica) c;

			Endereco novoEndFis = cF.getEndereco();

			novoEndFis.setBairro(bairroEndCliField.getText());
			novoEndFis.setCep(cepEndCliField.getText());
			novoEndFis.setCidade(cidadeEndCliField.getText());
			novoEndFis.setLogradouro(ruaEndCliField.getText());
			novoEndFis.setNumero(numEndCliField.getText());
			novoEndFis.setStatus(statusEnderecoCBox.isSelected());
			novoEndFis.setUf(ufEndCliCobBox.getValue());

			Contato novoContFis = cF.getContato();

			novoContFis.setCelular(celularContCliField.getText());
			novoContFis.setTelefone(foneContCliField.getText());
			novoContFis.setEmail(emailContCliField.getText());
			novoContFis.setStatus(statusContatoCBox.isSelected());

			cF.setNome(nomeCliField.getText());
			cF.setCpf(cpfCliField.getText());
			cF.setData_nascimento(dataCli.getValue());
			cF.setEndereco(novoEndFis);
			cF.setContato(novoContFis);
			cF.setEstado_civil(estadCivCliCobBox.getValue());
			cF.setOcupacao(ocupacaoCliCobBox.getValue());
			cF.setRg(rgCliField.getText());
			cF.setSexo(sexoCliCobBox.getValue());
			cF.setStatus(statusClienteCBox.isSelected());

			try {
				Facade.getInstance().createOrUpdatePessoaFisica(cF);
				Message.getInstance().viewMessage(AlertType.CONFIRMATION, "Atualizado", "Cliente atualizado!",
						"O cliente foi atualizado com sucesso!");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro ao atualizar",
						"Ocorreu um erro ao atualizar o cliente físico!", e.getMessage());
			}

		} else if (c instanceof PessoaJuridica) {

			PessoaJuridica cJ = (PessoaJuridica) c;

			Endereco novoEndJur = cJ.getEndereco();

			novoEndJur.setBairro(bairroEndCliField.getText());
			novoEndJur.setCep(cepEndCliField.getText());
			novoEndJur.setCidade(cidadeEndCliField.getText());
			novoEndJur.setLogradouro(ruaEndCliField.getText());
			novoEndJur.setNumero(numEndCliField.getText());
			novoEndJur.setStatus(statusEnderecoCBox.isSelected());
			novoEndJur.setUf(ufEndCliCobBox.getValue());

			Contato novoContJur = cJ.getContato();

			novoContJur.setCelular(celularContCliField.getText());
			novoContJur.setTelefone(foneContCliField.getText());
			novoContJur.setEmail(emailContCliField.getText());
			novoContJur.setStatus(statusContatoCBox.isSelected());

			cJ.setNome(nomeCliField.getText());
			cJ.setCnpj(cnpjCliField.getText());
			cJ.setContato(novoContJur);
			cJ.setEndereco(novoEndJur);
			cJ.setRazaoSocial(razaoSociCliField.getText());
			cJ.setStatus(statusClienteCBox.isSelected());

			try {
				Facade.getInstance().createOrUpdatePessoaJuridica(cJ);
				Message.getInstance().viewMessage(AlertType.CONFIRMATION, "Atualizado", "Cliente atualizado!",
						"O cliente foi atualizado com sucesso!");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro ao atualizar",
						"Ocorreu um erro ao atualizar o cliente jurídico!", e.getMessage());
			}

		}

	}

	/**
	 * Método para limpar os campos.
	 */
	public void limparCampos() {

	}

	/**
	 * Método para colocar mascaras nos texfields.
	 */
	public void mascarasField() {

		MaskFieldUtil.cpfField(cpfCliField);
		MaskFieldUtil.cepField(cepEndCliField);
		MaskFieldUtil.cnpjField(cnpjCliField);
		MaskFieldUtil.foneField(celularContCliField);
		MaskFieldUtil.foneField(foneContCliField);

	}

	/**
	 * Método para carregar combo box e customização da tabela
	 */
	public void comboBoxTabela() {

		sexoCliCobBox.getItems().setAll(TipoSexo.values());
		estadCivCliCobBox.getItems().setAll(TipoEstadoCivil.values());
		ocupacaoCliCobBox.getItems().setAll(TipoOcupacao.values());
		ufEndCliCobBox.getItems().setAll(TipoEstadoUF.values());

		nomeCliCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfCliCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		ruaCliCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		bairroCliCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		numCliCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));

		ruaCliCol.setCellFactory(coluna -> {
			return new TableCell<PessoaFisica, Endereco>() {
				protected void updateItem(Endereco item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item.getLogradouro());

					}
				}
			};
		});

		bairroCliCol.setCellFactory(coluna -> {
			return new TableCell<PessoaFisica, Endereco>() {

				protected void updateItem(Endereco item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item.getBairro());

					}
				}
			};
		});

		numCliCol.setCellFactory(coluna -> {
			return new TableCell<PessoaFisica, Endereco>() {
				protected void updateItem(Endereco item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item.getNumero());

					}
				}
			};
		});
		
		nomeCliJuriCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cnpjJuriCol.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		ruaCliJuriCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		bairroCliJuriCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		numCliJuriCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));

		ruaCliJuriCol.setCellFactory(coluna -> {
			return new TableCell<PessoaJuridica, Endereco>() {
				protected void updateItem(Endereco item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item.getLogradouro());

					}
				}
			};
		});

		bairroCliJuriCol.setCellFactory(coluna -> {
			return new TableCell<PessoaJuridica, Endereco>() {

				protected void updateItem(Endereco item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item.getBairro());

					}
				}
			};
		});

		numCliJuriCol.setCellFactory(coluna -> {
			return new TableCell<PessoaJuridica, Endereco>() {
				protected void updateItem(Endereco item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item.getNumero());

					}
				}
			};
		});

		try

		{
			pessoaFisicas = Facade.getInstance().searchAllPessoaFisica();
			if(!pessoaFisicas.isEmpty()) {
			cliTabela.getItems().setAll(pessoaFisicas);
			}
			pessoaJuridicas = Facade.getInstance().searchAllPessoaJuridica();
			if(!pessoaJuridicas.isEmpty()) {
			cliJuriTabela.getItems().setAll(pessoaJuridicas);
			}
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
