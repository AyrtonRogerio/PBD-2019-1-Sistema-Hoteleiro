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
import com.jfoenix.controls.JFXTextField;

import br.com.sistemahoteleiro.enuns.TipoEstadoCivil;
import br.com.sistemahoteleiro.enuns.TipoOcupacao;
import br.com.sistemahoteleiro.enuns.TipoSexo;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.facade.Facade;
import br.com.sistemahoteleiro.model.Cliente;
import br.com.sistemahoteleiro.model.Contato;
import br.com.sistemahoteleiro.model.Endereco;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaJuridica;
import br.com.sistemahoteleiro.model.Quarto;
import br.com.sistemahoteleiro.util.MaskFieldUtil;
import br.com.sistemahoteleiro.view.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
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
	private PessoaFisica clienteFisico;
	private PessoaJuridica clienteJuridico;
	private Cliente clienteAtualiza;
	private List<Cliente> clientes;

	private Endereco endereco;
	private Contato contato;

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
	private TableView<Cliente> cliTabela;

	@FXML
	private TableColumn<Cliente, String> nomeCliCol;

	@FXML
	private TableColumn<Cliente, String> cpfCliCol;

	@FXML
	private TableColumn<Cliente, String> cnpjCliCol;

	@FXML
	private TableColumn<Cliente, String> ruaCliCol;

	@FXML
	private TableColumn<Cliente, String> bairroCliCol;

	@FXML
	private TableColumn<Cliente, String> numCliCol;

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
	private JFXTextField ufEndCliField;
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
		if (event.getSource() == buscCliBtn) {

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

		}

		/**
		 * Evento para cadastrar novo cliente, liber o Tab Dados gerais para preencher.
		 */
		if (event.getSource() == novoCliBtn) {

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
		 * Evento para voltar para a Lista de Clientes
		 */
		if (event.getSource() == voltarCliBtn) {

			dadosCliTab.setDisable(true);
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

			cadastrarCliente();

		}

		/**
		 * Evento pra atualizar o cliente
		 */
		if (event.getSource() == atualizarCliBtn) {

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		sexoCliCobBox.getItems().setAll(TipoSexo.values());
		estadCivCliCobBox.getItems().setAll(TipoEstadoCivil.values());
		ocupacaoCliCobBox.getItems().setAll(TipoOcupacao.values());

		nomeCliCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfCliCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		cnpjCliCol.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		ruaCliCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		bairroCliCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		numCliCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));

		try {
			clientes = Facade.getInstance().searchAllCliente();
			cliTabela.getItems().setAll(clientes);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mascarasField();

	}

	/**
	 * Método para cadastrar um quarto.
	 */
	public void cadastrarCliente() {

		endereco = new Endereco();

		endereco.setBairro(bairroEndCliField.getText());
		endereco.setCep(cepEndCliField.getText());
		endereco.setCidade(cidadeEndCliField.getText());
		endereco.setLogradouro(ruaEndCliField.getText());
		endereco.setNumero(numEndCliField.getText());
		endereco.setStatus(statusEnderecoCBox.isSelected());
		endereco.setUf(ufEndCliField.getText());

		contato = new Contato();

		contato.setCelular(celularContCliField.getText());
		contato.setTelefone(foneContCliField.getText());
		contato.setEmail(emailContCliField.getText());
		contato.setStatus(true);

		if (pessFisRadBtn.isSelected()) {

			clienteFisico = new PessoaFisica();

			clienteFisico.setNome(nomeCliField.getText());
			clienteFisico.setCpf(cpfCliField.getText());
			clienteFisico.setData_nascimento(dataCli.getValue());
			clienteFisico.setEndereco(endereco);
			clienteFisico.setEstado_civil(estadCivCliCobBox.getValue());
			clienteFisico.setOcupacao(ocupacaoCliCobBox.getValue());
			clienteFisico.setRg(rgCliField.getText());
			clienteFisico.setSexo(sexoCliCobBox.getValue());
			clienteFisico.setStatus(statusClienteCBox.isSelected());

			try {
				Facade.getInstance().createOrUpdatePessoaFisica(clienteFisico);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		if (pessJurRadBtn.isSelected()) {

			clienteJuridico = new PessoaJuridica();

			clienteJuridico.setNome(nomeCliField.getText());
			clienteJuridico.setCnpj(cnpjCliField.getText());
			clienteJuridico.setContato(contato);
			clienteJuridico.setEndereco(endereco);
			clienteJuridico.setRazaoSocial(razaoSociCliField.getText());
			clienteJuridico.setStatus(statusClienteCBox.isSelected());
			
			try {
			
				Facade.getInstance().createOrUpdatePessoaJuridica(clienteJuridico);
				
				
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	/**
	 * Método para preencher campos para atualizar o cliente.
	 */
	public void preencherCampos() {

	}

	/**
	 * Método para atualizar cliente selecionado da tabela.
	 * 
	 * @param c
	 */
	public void atualizarCliente(Cliente c) {

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

}
