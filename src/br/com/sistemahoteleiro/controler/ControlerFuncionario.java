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
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import br.com.sistemahoteleiro.enuns.TipoCargo;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.facade.Facade;
import br.com.sistemahoteleiro.model.Administrador;
import br.com.sistemahoteleiro.model.Funcionario;
import br.com.sistemahoteleiro.model.SuperUsuario;
import br.com.sistemahoteleiro.model.Usuario;
import br.com.sistemahoteleiro.util.MaskFieldUtil;
import br.com.sistemahoteleiro.view.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author ayrton
 *
 */
public class ControlerFuncionario implements Initializable {

	private Usuario usuario, usuarioAtualiza;
	private List<Usuario> usuarios;
	private SuperUsuario superUsuario, superUsuarioAtualiza;
	private Administrador administrador, administradorAtualiza;
	private Funcionario funcionario, funcionarioAtualiza;

	@FXML
	private Tab listFuncTab;

	@FXML
	private JFXTextField buscaField;

	@FXML
	private JFXButton buscaFuncBtn;

	@FXML
	private JFXButton novoFuncBtn;

	@FXML
	private JFXButton atualizaTabelaBtn;

	@FXML
	private TableView<Usuario> funcListTabela;

	@FXML
	private TableColumn<Usuario, String> nomeCol;

	@FXML
	private TableColumn<Usuario, String> cpfCol;

	@FXML
	private TableColumn<Usuario, TipoCargo> cargoCol;

	@FXML
	private TableColumn<Usuario, Boolean> situacaoCol;

	@FXML
	private JFXButton editarFuncBtn;

	@FXML
	private JFXButton detalhesFuncBtn;

	@FXML
	private Tab funcTab;

	@FXML
	private JFXComboBox<TipoCargo> cargoCobBox;

	@FXML
	private JFXPasswordField senhaFuncPassField;

	@FXML
	private JFXPasswordField confSenhaFuncPassField;

	@FXML
	private JFXTextField nomeFuncField;

	@FXML
	private JFXTextField cpfFuncField;

	@FXML
	private JFXTextField loginFuncField;

	@FXML
	private JFXCheckBox situacaoCbox;

	@FXML
	private JFXTextField rgFuncField;

	@FXML
	private JFXButton voltarFuncBtn;

	@FXML
	private JFXButton cadFuncBtn;

	@FXML
	private JFXButton atualizarFuncBtn;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == buscaFuncBtn) {

		}

		if (event.getSource() == novoFuncBtn) {

			atualizarFuncBtn.setDisable(true);
			funcTab.setDisable(false);
			funcTab.getTabPane().getSelectionModel().select(funcTab);
		}

		if (event.getSource() == atualizaTabelaBtn) {

			try

			{
				usuarios = Facade.getInstance().searchAllUsuario();
				funcListTabela.getItems().setAll(usuarios);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (event.getSource() == editarFuncBtn) {
			cadFuncBtn.setDisable(true);
			funcTab.getTabPane().getSelectionModel().select(funcTab);
			preencherCampos();

		}

		if (event.getSource() == detalhesFuncBtn) {

			preencherCampos();

		}

		if (event.getSource() == voltarFuncBtn) {

		}

		if (event.getSource() == cadFuncBtn) {

			cadastrarUsuario();
			

		}

		if (event.getSource() == atualizarFuncBtn) {

			atualizarFuncionario(usuarioAtualiza);

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		mascarasField();
		carregarComboBoxTabela();
	}

	/**
	 * Método para cadastrar SuperUsuário, Administrador e funcionário.
	 */
	public void cadastrarUsuario() {

		nomeFuncField.getText();
		cpfFuncField.getText();
		rgFuncField.getText();
		cargoCobBox.getValue();
		loginFuncField.getText();
		senhaFuncPassField.getText();
		confSenhaFuncPassField.getText();
		situacaoCbox.isSelected();

		/**
		 * 
		 */
		if (cargoCobBox.getValue().equals(TipoCargo.SUPER_USUARIO)) {

			superUsuario = new SuperUsuario();

			superUsuario.setNome(nomeFuncField.getText());
			superUsuario.setCpf(cpfFuncField.getText());
			superUsuario.setRg(rgFuncField.getText());
			superUsuario.setCargo(cargoCobBox.getValue());
			superUsuario.setLogin(loginFuncField.getText());
			superUsuario.setSenha(senhaFuncPassField.getText());
			superUsuario.setStatus(situacaoCbox.isSelected());

			try {

				if (senhaFuncPassField.getText().trim().equals(confSenhaFuncPassField.getText().trim())) {
					Facade.getInstance().createOrUpdateSuperUsuario(superUsuario);
					Message.getInstance().viewMessage(AlertType.CONFIRMATION, "Sucesso", "Cadastro realizado!",
							"Cadastro do Super usuário feito com sucesso");

					limparCampos();
					carregarComboBoxTabela();
					try

					{
						usuarios = Facade.getInstance().searchAllUsuario();
						funcListTabela.getItems().setAll(usuarios);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					funcTab.setDisable(true);
					listFuncTab.getTabPane().getSelectionModel().select(listFuncTab);

				} else {

					Message.getInstance().viewMessage(AlertType.INFORMATION, "Atenção!", "Senhas incorretas!",
							"Digite uma senha válida!");
				}

			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao cadastrar Super usuário!",
						e.getMessage());
			}

		}

		/**
		 * 
		 */
		if (cargoCobBox.getValue().equals(TipoCargo.GERENTE)) {

			administrador = new Administrador();

			administrador.setNome(nomeFuncField.getText());
			administrador.setCpf(cpfFuncField.getText());
			administrador.setRg(rgFuncField.getText());
			administrador.setCargo(cargoCobBox.getValue());
			administrador.setLogin(loginFuncField.getText());
			administrador.setSenha(senhaFuncPassField.getText());
			administrador.setStatus(situacaoCbox.isSelected());

			try {

				if (senhaFuncPassField.getText().trim().equals(confSenhaFuncPassField.getText().trim())) {
					Facade.getInstance().createOrUpdateAdministrador(administrador);
					Message.getInstance().viewMessage(AlertType.CONFIRMATION, "Sucesso", "Cadastro realizado!",
							"Cadastro do Administrador feito com sucesso");

					limparCampos();
					carregarComboBoxTabela();
					try

					{
						usuarios = Facade.getInstance().searchAllUsuario();
						funcListTabela.getItems().setAll(usuarios);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					funcTab.setDisable(true);
					listFuncTab.getTabPane().getSelectionModel().select(listFuncTab);

				} else {

					Message.getInstance().viewMessage(AlertType.INFORMATION, "Atenção!", "Senhas incorretas!",
							"Digite uma senha válida!");
				}

			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao cadastrar Administrador!",
						e.getMessage());
			}

		}

		/**
		 * 
		 */
		if (cargoCobBox.getValue().equals(TipoCargo.ATENDENTE)
				|| cargoCobBox.getValue().equals(TipoCargo.AUX_SERV_GERAIS)
				|| cargoCobBox.getValue().equals(TipoCargo.CAMAREIRA)) {

			funcionario = new Funcionario();

			funcionario.setNome(nomeFuncField.getText());
			funcionario.setCpf(cpfFuncField.getText());
			funcionario.setRg(rgFuncField.getText());
			funcionario.setCargo(cargoCobBox.getValue());
			funcionario.setLogin(loginFuncField.getText());
			funcionario.setSenha(senhaFuncPassField.getText());
			funcionario.setStatus(situacaoCbox.isSelected());

			try {

				if (senhaFuncPassField.getText().trim().equals(confSenhaFuncPassField.getText().trim())) {
					Facade.getInstance().createOrUpdateFuncionario(funcionario);
					Message.getInstance().viewMessage(AlertType.CONFIRMATION, "Sucesso", "Cadastro realizado!",
							"Cadastro do Funcionário feito com sucesso");

					limparCampos();
					carregarComboBoxTabela();
					try

					{
						usuarios = Facade.getInstance().searchAllUsuario();
						funcListTabela.getItems().setAll(usuarios);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					funcTab.setDisable(true);
					listFuncTab.getTabPane().getSelectionModel().select(listFuncTab);

				} else {

					Message.getInstance().viewMessage(AlertType.INFORMATION, "Atenção!", "Senhas incorretas!",
							"Digite uma senha válida!");
				}

			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao cadastrar Funcionário!",
						e.getMessage());
			}

		}

	}

	/**
	 * Método para atualizar SuperUsuário, Administrador e funcionário.
	 * 
	 * @param u
	 */
	public void atualizarFuncionario(Usuario u) {

		if (u instanceof SuperUsuario) {

			superUsuarioAtualiza = (SuperUsuario) u;

			superUsuarioAtualiza.setNome(nomeFuncField.getText());
			superUsuarioAtualiza.setCpf(cpfFuncField.getText());
			superUsuarioAtualiza.setRg(rgFuncField.getText());
			superUsuarioAtualiza.setCargo(cargoCobBox.getValue());
			superUsuarioAtualiza.setLogin(loginFuncField.getText());
			superUsuarioAtualiza.setSenha(senhaFuncPassField.getText());
			superUsuarioAtualiza.setStatus(situacaoCbox.isSelected());

			try {

				if (senhaFuncPassField.getText().trim().equals(confSenhaFuncPassField.getText().trim())) {

					Facade.getInstance().createOrUpdateSuperUsuario(superUsuarioAtualiza);

					Message.getInstance().viewMessage(AlertType.CONFIRMATION, "Atualizado!", "Atualização concluida!",
							"Super usuário atualizado com sucesso!");

					limparCampos();
					carregarComboBoxTabela();
					try

					{
						usuarios = Facade.getInstance().searchAllUsuario();
						funcListTabela.getItems().setAll(usuarios);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					funcTab.setDisable(true);
					listFuncTab.getTabPane().getSelectionModel().select(listFuncTab);

				} else {

					Message.getInstance().viewMessage(AlertType.INFORMATION, "Atenção!", "Senhas incorretas!",
							"Digite uma senha válida!");
				}
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro!", "Erro ao atualizar Super usuário",
						e.getMessage());
			}

		}

		if (u instanceof Administrador) {

			administradorAtualiza = (Administrador) u;

			administradorAtualiza.setNome(nomeFuncField.getText());
			administradorAtualiza.setCpf(cpfFuncField.getText());
			administradorAtualiza.setRg(rgFuncField.getText());
			administradorAtualiza.setCargo(cargoCobBox.getValue());
			administradorAtualiza.setLogin(loginFuncField.getText());
			administradorAtualiza.setSenha(senhaFuncPassField.getText());
			administradorAtualiza.setStatus(situacaoCbox.isSelected());

			try {

				if (senhaFuncPassField.getText().trim().equals(confSenhaFuncPassField.getText().trim())) {

					Facade.getInstance().createOrUpdateAdministrador(administradorAtualiza);

					Message.getInstance().viewMessage(AlertType.CONFIRMATION, "Atualizado!", "Atualização concluida!",
							"Administrador atualizado com sucesso!");

					limparCampos();
					carregarComboBoxTabela();

					try {
						usuarios = Facade.getInstance().searchAllUsuario();
						funcListTabela.getItems().setAll(usuarios);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					funcTab.setDisable(true);
					listFuncTab.getTabPane().getSelectionModel().select(listFuncTab);

				} else {
					Message.getInstance().viewMessage(AlertType.INFORMATION, "Atenção!", "Senhas incorretas!",
							"Digite uma senha válida!");
				}
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro!", "Erro ao atualizar Administrador",
						e.getMessage());
			}

		}

		if (u instanceof Funcionario) {

			funcionarioAtualiza = (Funcionario) u;

			funcionarioAtualiza.setNome(nomeFuncField.getText());
			funcionarioAtualiza.setCpf(cpfFuncField.getText());
			funcionarioAtualiza.setRg(rgFuncField.getText());
			funcionarioAtualiza.setCargo(cargoCobBox.getValue());
			funcionarioAtualiza.setLogin(loginFuncField.getText());
			funcionarioAtualiza.setSenha(senhaFuncPassField.getText());
			funcionarioAtualiza.setStatus(situacaoCbox.isSelected());

			try {

				if (senhaFuncPassField.getText().trim().equals(confSenhaFuncPassField.getText().trim())) {

					Facade.getInstance().createOrUpdateFuncionario(funcionarioAtualiza);

					Message.getInstance().viewMessage(AlertType.CONFIRMATION, "Atualizado!", "Atualização concluida!",
							"Funcionário atualizado com sucesso!");

					limparCampos();
					carregarComboBoxTabela();
					try {
						usuarios = Facade.getInstance().searchAllUsuario();
						funcListTabela.getItems().setAll(usuarios);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					funcTab.setDisable(true);
					listFuncTab.getTabPane().getSelectionModel().select(listFuncTab);

				} else {

					Message.getInstance().viewMessage(AlertType.INFORMATION, "Atenção!", "Senhas incorretas!",
							"Digite uma senha válida!");
				}
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro!", "Erro ao atualizar Funcionário",
						e.getMessage());
			}

		}

	}

	/**
	 * Método para preencher os campos dos usuários.
	 */
	public void preencherCampos() {

		usuarioAtualiza = funcListTabela.getSelectionModel().getSelectedItem();

		if (usuarioAtualiza instanceof SuperUsuario) {

			try {
				superUsuarioAtualiza = Facade.getInstance().searchSuperUsuario(usuarioAtualiza.getId());
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao buscar o Super usuário!",
						e.getMessage());
			}

			nomeFuncField.setText(superUsuarioAtualiza.getNome());
			cpfFuncField.setText(superUsuarioAtualiza.getCpf());
			rgFuncField.setText(superUsuarioAtualiza.getRg());
			cargoCobBox.setValue(superUsuarioAtualiza.getCargo());
			loginFuncField.setText(superUsuarioAtualiza.getLogin());
			senhaFuncPassField.setText(superUsuarioAtualiza.getSenha());
			confSenhaFuncPassField.setText(superUsuarioAtualiza.getSenha());
			situacaoCbox.setSelected(superUsuarioAtualiza.isStatus());

		} else if (usuarioAtualiza instanceof Administrador) {

			try {
				administradorAtualiza = Facade.getInstance().searchAdministrador(usuarioAtualiza.getId());
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao buscar o Administrador!",
						e.getMessage());
			}

			nomeFuncField.setText(administradorAtualiza.getNome());
			cpfFuncField.setText(administradorAtualiza.getCpf());
			rgFuncField.setText(administradorAtualiza.getRg());
			cargoCobBox.setValue(administradorAtualiza.getCargo());
			loginFuncField.setText(administradorAtualiza.getLogin());
			senhaFuncPassField.setText(administradorAtualiza.getSenha());
			confSenhaFuncPassField.setText(administradorAtualiza.getSenha());
			situacaoCbox.setSelected(administradorAtualiza.isStatus());

		} else if (usuarioAtualiza instanceof Funcionario) {

			try {
				funcionarioAtualiza = Facade.getInstance().searchFuncionario(usuarioAtualiza.getId());
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao buscar o Funcionário!",
						e.getMessage());
			}

			nomeFuncField.setText(funcionarioAtualiza.getNome());
			cpfFuncField.setText(funcionarioAtualiza.getCpf());
			rgFuncField.setText(funcionarioAtualiza.getRg());
			cargoCobBox.setValue(funcionarioAtualiza.getCargo());
			loginFuncField.setText(funcionarioAtualiza.getLogin());
			senhaFuncPassField.setText(funcionarioAtualiza.getSenha());
			confSenhaFuncPassField.setText(funcionarioAtualiza.getSenha());

		}

	}

	/**
	 * Método para colocar mascaras nos texfields.
	 */
	public void mascarasField() {

		MaskFieldUtil.cpfField(cpfFuncField);

	}

	/**
	 * Método para carregar combo box e customização da tabela
	 */
	public void carregarComboBoxTabela() {

		cargoCobBox.getItems().setAll(TipoCargo.values());

		nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		cargoCol.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		situacaoCol.setCellValueFactory(new PropertyValueFactory<>("status"));

		situacaoCol.setCellFactory(coluna -> {

			return new TableCell<Usuario, Boolean>() {

				protected void updateItem(Boolean item, boolean empty) {

					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						if (item) {
							setText("Vinculado");
						} else {
							setText("Desvinculado");
						}
					}
				}
			};
		});

	}

	/**
	 * Método para limpar campos.
	 */
	public void limparCampos() {

		nomeFuncField.clear();
		cpfFuncField.clear();
		rgFuncField.clear();
		cargoCobBox.getSelectionModel().clearSelection();
		loginFuncField.clear();
		senhaFuncPassField.clear();
		confSenhaFuncPassField.clear();

	}

}
