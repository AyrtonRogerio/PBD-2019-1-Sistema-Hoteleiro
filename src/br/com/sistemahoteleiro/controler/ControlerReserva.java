/**
 * 
 */
package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.facade.Facade;
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaPessoaFisicaView;
import br.com.sistemahoteleiro.model.AlugaPessoaJuridicaView;
import br.com.sistemahoteleiro.model.Caixa;
import br.com.sistemahoteleiro.model.Cliente;
import br.com.sistemahoteleiro.model.Funcionario;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaJuridica;
import br.com.sistemahoteleiro.model.Quarto;
import br.com.sistemahoteleiro.model.QuartoView;
import br.com.sistemahoteleiro.model.Reserva;
import br.com.sistemahoteleiro.model.ReservaViewFisica;
import br.com.sistemahoteleiro.model.ReservaViewJuridica;
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
 * @author ayrtons
 *
 */
public class ControlerReserva implements Initializable {

	/**
	 * Atributos
	 */
	private Reserva reserva;
	private Cliente cliente;
	private Caixa caixa;
//	private Funcionario funcionario;
	private QuartoView quartoView;



	@FXML
    private Tab reservaTab;

    @FXML
    private JFXButton pesqReservBtn;

    @FXML
    private JFXTextField pesqReservField;

    @FXML
    private JFXButton atualizaListReservBtn;

    @FXML
    private JFXButton novaReservaBtn;

    @FXML
    private JFXRadioButton cliFisiRadio;

    @FXML
    private JFXRadioButton cliJuriRadio;

    @FXML
    private Tab cliFisiTab;

    @FXML
    private TableView<ReservaViewFisica> cliFisTabela;

    @FXML
    private TableColumn<ReservaViewFisica, String> nomeCliFisCol;

    @FXML
    private TableColumn<ReservaViewFisica, String> cpfCliFisCol;

    @FXML
    private TableColumn<ReservaViewFisica, Quarto> quartoCliFisCol;

    @FXML
    private TableColumn<ReservaViewFisica, LocalDate> dataEntCliFisCol;

    @FXML
    private TableColumn<ReservaViewFisica, LocalTime> horaEntCliFisCol;

    @FXML
    private TableColumn<ReservaViewFisica, Boolean> situacaoCliFisCol;

    @FXML
    private Tab cliJuriTab;

    @FXML
    private TableView<ReservaViewJuridica> cliJuriTabela;

    @FXML
    private TableColumn<ReservaViewJuridica, String> nomeCliJurCol;

    @FXML
    private TableColumn<ReservaViewJuridica, String> cnpjCliJurCol;

    @FXML
    private TableColumn<ReservaViewJuridica, Quarto> quartoCliJurCol;

    @FXML
    private TableColumn<ReservaViewJuridica, LocalDate> dataEntCliJurCol;

    @FXML
    private TableColumn<ReservaViewJuridica, LocalTime> horaEntCliJurCol;

    @FXML
    private TableColumn<ReservaViewJuridica, Boolean> situacaoCliJurCol;

    @FXML
    private JFXButton editarBtn;

    @FXML
    private Tab novaReservaTab;

    @FXML
    private Tab clienteTab;

    @FXML
    private JFXButton pesqClientBtn;

    @FXML
    private JFXTextField pesqClientField;

    @FXML
    private JFXButton atualizaCliTabelaBtn;

    @FXML
    private JFXRadioButton novoCliFisiRadio;

    @FXML
    private JFXRadioButton novoCliJuriRadio;

    @FXML
    private Tab novoCliFisiTab;

    @FXML
    private TableView<PessoaFisica> novoCliTabela;

    @FXML
    private TableColumn<PessoaFisica, String> nomeCliCol;

    @FXML
    private TableColumn<PessoaFisica, String> cpfCliCol;

    @FXML
    private Tab novoCliJuriTab;

    @FXML
    private TableView<PessoaJuridica> novoCliJuriTabela;

    @FXML
    private TableColumn<PessoaJuridica, String> nomeCliJuriCol;

    @FXML
    private TableColumn<PessoaJuridica, String> cnpjJuriCol;

    @FXML
    private JFXButton voltarListBtn;

    @FXML
    private JFXButton contCadBtn;

    @FXML
    private Tab listaQuartosTab;

    @FXML
    private JFXButton pesqQuartoBtn;

    @FXML
    private JFXTextField pesqQuartoField;

    @FXML
    private JFXButton atualizarQuartTabelaBtn;

    @FXML
    private TableView<QuartoView> alugQuartoTabela;

    @FXML
    private TableColumn<QuartoView, Integer> novoQuartoCol;

    @FXML
    private TableColumn<QuartoView, Integer> novoQtCamasCol;

    @FXML
    private TableColumn<QuartoView, String> novoTipoCol;

    @FXML
    private TableColumn<QuartoView, Boolean> novoDisponivelCol;

    @FXML
    private JFXButton voltarQuartBtn;

    @FXML
    private JFXButton contQuartBtn;

    @FXML
    private Tab dadosGeraisTab;

    @FXML
    private JFXTextField valorField;

    @FXML
    private JFXDatePicker reservaDateP;

    @FXML
    private JFXTimePicker reservaTimeP;

    @FXML
    private JFXButton finalizarReservBtn;

    @FXML
    private JFXButton voltarDadosGBtn;

    @FXML
    private JFXCheckBox situacaoCBox;

    @FXML
    private Tab infoTab;

    @FXML
    private JFXDatePicker dataInicioDateP;

    @FXML
    private JFXDatePicker dataFimDateP;

    @FXML
    private JFXTextField saldoInfoField;

    @FXML
    private JFXButton buscarInfoBtn;

    @FXML
    private JFXButton voltarListBtn1;
    
    @FXML
    void action(ActionEvent event) {

    	
    	
    	if(event.getSource() == cliFisiRadio) {
    	
    		cliFisiRadio.setSelected(true);
			cliJuriRadio.setSelected(false);
			cliFisiTab.setDisable(false);
			cliJuriTab.setDisable(true);
			cliFisiTab.getTabPane().getSelectionModel().select(cliFisiTab);
    	}
    	
    	if(event.getSource() == cliJuriRadio) {
    		
    		cliJuriRadio.setSelected(true);
			cliFisiRadio.setSelected(false);
			cliFisiTab.setDisable(true);
			cliJuriTab.setDisable(false);
			cliJuriTab.getTabPane().getSelectionModel().select(cliJuriTab);
    	}
    	
    	if(event.getSource() == pesqReservBtn) {
    		
    		/**
			 * Buscar por cliente físico
			 */
			if (cliFisiRadio.isSelected()) {

				cliFisiRadio.setSelected(true);
				cliJuriRadio.setSelected(false);

				try {
					
					
					
					cliFisTabela.getItems()
							.setAll(Facade.getInstance().buscarReservadosFisicosView(pesqReservField.getText()));
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			/**
			 * Buscar por cliente juridico
			 */
			if (cliJuriRadio.isSelected()) {

				cliJuriRadio.setSelected(true);
				cliFisiRadio.setSelected(false);

				try {
					cliJuriTabela.getItems().setAll(Facade.getInstance().buscarReservadosJuridicosView(pesqReservField.getText()));
				} catch (BusinessException e) {
//					 TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
    		
    	}
    	
    	if(event.getSource() == novaReservaBtn) {
    		
    		novaReservaTab.setDisable(false);
    		novaReservaTab.getTabPane().getSelectionModel().select(novaReservaTab);
    		
    	}
    	
    	if(event.getSource() == editarBtn) {
    		
    	}
    	
    	//Fim dos eventos da seção de listagem de reservas
    	
    	//---------------------------------------------------------------------------
    	
    	//eventos da seção de nova reserva - Cliente
    	
    	if (event.getSource() == novoCliFisiRadio) {

			novoCliFisiRadio.setSelected(true);
			novoCliJuriRadio.setSelected(false);
			novoCliFisiTab.setDisable(false);
			novoCliJuriTab.setDisable(true);
			novoCliFisiTab.getTabPane().getSelectionModel().select(novoCliFisiTab);

		}

		if (event.getSource() == novoCliJuriRadio) {

			novoCliFisiRadio.setSelected(false);
			novoCliJuriRadio.setSelected(true);
			novoCliFisiTab.setDisable(true);
			novoCliJuriTab.setDisable(false);
			novoCliJuriTab.getTabPane().getSelectionModel().select(novoCliJuriTab);
		}
    	
		if (event.getSource() == pesqClientBtn) {

			/**
			 * cliente fisico selecionado
			 */
			if (novoCliFisiRadio.isSelected()) {

				try {

					novoCliTabela.getItems()
							.setAll(Facade.getInstance().buscarPessoasFisica(pesqClientField.getText()));
					limparCamposPesquisa();
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			/**
			 * cliente juridico selecionado
			 */
			if (novoCliJuriRadio.isSelected()) {

				try {
					novoCliJuriTabela.getItems()
							.setAll(Facade.getInstance().buscarPessoasJuridica(pesqClientField.getText()));
					limparCamposPesquisa();
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		/**
		 * Volta para a seção de listagem de alugueis
		 */
		if (event.getSource() == voltarListBtn) {

			novaReservaTab.setDisable(true);
			reservaTab.getTabPane().getSelectionModel().select(reservaTab);

		}
		
		/**
		 * Continua para o Tab quartos
		 */
		if (event.getSource() == contCadBtn) {

			if (novoCliTabela.getSelectionModel().getSelectedItem() != null) {

				cliente = novoCliTabela.getSelectionModel().getSelectedItem();

			} else if (novoCliJuriTabela.getSelectionModel().getSelectedItem() != null) {

				cliente = novoCliJuriTabela.getSelectionModel().getSelectedItem();

			}

			listaQuartosTab.setDisable(false);
			listaQuartosTab.getTabPane().getSelectionModel().select(listaQuartosTab);

		}
		
		// Fim dos eventos da seção de novo aluguel - Cliente

				// -------------------------------------------------------------

				// eventos da seção de novo aluguel - Quarto

				if (event.getSource() == pesqQuartoBtn) {

					try {
						alugQuartoTabela.getItems()
								.setAll(Facade.getInstance().buscarQuartoViewDisponivel(pesqQuartoField.getText()));
						limparCamposPesquisa();
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				/**
				 * volta para a seção do cliente
				 */
				if (event.getSource() == voltarQuartBtn) {

					clienteTab.getTabPane().getSelectionModel().select(clienteTab);

				}

				/**
				 * continua para a seção do dados do aluguel
				 */
				if (event.getSource() == contQuartBtn) {

					if (alugQuartoTabela.getSelectionModel().getSelectedItem() != null) {
						quartoView = alugQuartoTabela.getSelectionModel().getSelectedItem();

						dadosGeraisTab.setDisable(false);
						dadosGeraisTab.getTabPane().getSelectionModel().select(dadosGeraisTab);

					} else {
						Message.getInstance().viewMessage(AlertType.WARNING, "Atenção!", "Quarto não selecionado!",
								"Selecione um quarto para prosseguir!");
					}

				}
				// Fim dos eventos da seção de quartos

				// -------------------------------------------------------------------------------
		
				// Eventos da seção de dados gerais

				/**
				 * Voltar pra seção de listagem de quartos
				 */
				if (event.getSource() == voltarDadosGBtn) {

					dadosGeraisTab.getTabPane().getSelectionModel().select(dadosGeraisTab);

				}

				/**
				 * Finalizar o cadastro de um aluguel
				 */
				if (event.getSource() == finalizarReservBtn) {

					try {
						cadastrarReserva(quartoView);

					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Message.getInstance().viewMessage(AlertType.ERROR, "Erro!", "Erro ao cadastrar!", e.getMessage());
					}

				}

				
		if(event.getSource() == buscarInfoBtn) {
			
			try {
				saldoInfoField.setText(""+Facade.getInstance().buscarValorTotalDeReservas(dataInicioDateP.getValue(), dataFimDateP.getValue()));
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao buscar", "Erro ao buscar valores!");
			}
			
		}

		
    }
    	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		mascaras();
		carregarCamposReserva();
		
	}

	/**
	 * Método para carregar componentes de reserva.
	 */
	public void carregarCamposReserva() {

		/**
		 * Dados da tabela de reservados para cliente físico
		 */
		nomeCliFisCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

		cpfCliFisCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));

		quartoCliFisCol.setCellValueFactory(new PropertyValueFactory<>("quarto"));

		dataEntCliFisCol.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));

		horaEntCliFisCol.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));

		situacaoCliFisCol.setCellValueFactory(new PropertyValueFactory<>("status"));

		nomeCliFisCol.setCellFactory(coluna -> {
			return new TableCell<ReservaViewFisica, String>() {
				protected void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item);
					}
				}
			};
		});

		cpfCliFisCol.setCellFactory(coluna -> {
			return new TableCell<ReservaViewFisica, String>() {
				protected void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item);
					}
				}
			};
		});

		quartoCliFisCol.setCellFactory(coluna -> {
			return new TableCell<ReservaViewFisica, Quarto>() {
				protected void updateItem(Quarto item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item.getNumQuarto());
					}

				}
			};
		});
		
		/**
		 * dados da tabela de alugados para cliente jurídico
		 */
		nomeCliJurCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

		cnpjCliJurCol.setCellValueFactory(new PropertyValueFactory<>("cnpj"));

		quartoCliJurCol.setCellValueFactory(new PropertyValueFactory<>("quarto"));

		dataEntCliJurCol.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));

		horaEntCliJurCol.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));

		situacaoCliJurCol.setCellValueFactory(new PropertyValueFactory<>("status"));

		nomeCliJurCol.setCellFactory(coluna -> {
			return new TableCell<ReservaViewJuridica, String>() {
				protected void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item);
					}
				}
			};
		});

		cnpjCliJurCol.setCellFactory(coluna -> {
			return new TableCell<ReservaViewJuridica, String>() {
				protected void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item);
					}
				}
			};
		});

		quartoCliJurCol.setCellFactory(coluna -> {
			return new TableCell<ReservaViewJuridica, Quarto>() {
				protected void updateItem(Quarto item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText("" + item.getNumQuarto());
					}

				}
			};
		});

		
		
		/**
		 * Tabela do cliente físico para um novo cadastro de reserva.
		 */
		nomeCliCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

		cpfCliCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));

		/**
		 * Tabela do cliente jurídico para um novo cadastro de reserva.
		 */
		nomeCliJuriCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

		cnpjJuriCol.setCellValueFactory(new PropertyValueFactory<>("cnpj"));

		/**
		 * Tabela de quartos
		 */
		novoQuartoCol.setCellValueFactory(new PropertyValueFactory<>("numQuarto"));

		novoQtCamasCol.setCellValueFactory(new PropertyValueFactory<>("qtdCamas"));

		novoTipoCol.setCellValueFactory(new PropertyValueFactory<>("tipoQuarto"));

		novoDisponivelCol.setCellValueFactory(new PropertyValueFactory<>("disponivel"));

	}


	public void mascaras() {
		
		MaskFieldUtil.monetaryField(valorField);
		
	}
	
	public void limparCamposPesquisa() {

		pesqReservField.clear();

		pesqClientField.clear();

		pesqQuartoField.clear();

	}

	/**
	 * Método para limpar os campos de Reserva
	 */
	public void limparCamposReserva() {


		pesqQuartoField.clear();

		valorField.clear();

		reservaDateP.setValue(null);

		reservaTimeP.setValue(null);

		situacaoCBox.setSelected(true);

	}
	
	
	/**
	 * Método para cadastrar a Reserva
	 * @throws BusinessException 
	 */
	public void cadastrarReserva(QuartoView q) throws BusinessException {

		reserva = new Reserva();

		caixa = Facade.getInstance().searchCaixa(ControlerLogin.getCaixa().getId());
		
		reserva.setCaixa(caixa);
		
		reserva.setFuncionario(ControlerLogin.getUsuario());
		
		reserva.setCliente(cliente);
		
		reserva.setDataReserva(reservaDateP.getValue());
		
		reserva.setHoraReserva(reservaTimeP.getValue());
		
		reserva.setSituacao(situacaoCBox.isSelected());
		
		reserva.setQuarto(Facade.getInstance().searchQuarto(q.getId()));
		
		reserva.setValor(Double.parseDouble(valorField.getText()));
		
		Facade.getInstance().createOrUpdateReserva(reserva);
	}
	
	
}