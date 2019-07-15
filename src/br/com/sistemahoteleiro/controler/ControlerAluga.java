package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;
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
import br.com.sistemahoteleiro.model.Endereco;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaFisicaView;
import br.com.sistemahoteleiro.model.PessoaJuridica;
import br.com.sistemahoteleiro.model.Quarto;
import br.com.sistemahoteleiro.model.QuartoView;
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
public class ControlerAluga implements Initializable {

	private QuartoView quartoView;
	private Aluga aluga;
	private Cliente cliente;
	private Caixa caixa;
	private Usuario usuario;
	private List<AlugaPessoaFisicaView>  fisicas;
//	private List<Al>
	
	@FXML
	private Tab alugadosListTab;

	@FXML
	private JFXButton pesqAluguelBtn;

	@FXML
	private JFXTextField pesqAluguelField;

	@FXML
	private JFXButton novoAluguelBtn;

	@FXML
	private JFXButton atualizarAluguelTabelaBtn;

	@FXML
	private JFXRadioButton cliFisiRadio;

	@FXML
	private JFXRadioButton cliJuriRadio;

	@FXML
	private Tab cliFisiTab;

	// Tabela de listagem de alugueis de cliente físico
	@FXML
	private TableView<AlugaPessoaFisicaView> cliFisTabela;

	@FXML
	private TableColumn<AlugaPessoaFisicaView, String> nomeCliFisCol;

	@FXML
	private TableColumn<AlugaPessoaFisicaView, String> cpfCliFisCol;

	@FXML
	private TableColumn<AlugaPessoaFisicaView, Quarto> quartoCliFisCol;

	@FXML
	private TableColumn<AlugaPessoaFisicaView, LocalDate> dataEntCliFisCol;

	@FXML
	private TableColumn<AlugaPessoaFisicaView, LocalTime> horaEntCliFisCol;

	@FXML
	private TableColumn<AlugaPessoaFisicaView, LocalDate> dataSaidaCliFisCol;

	@FXML
	private TableColumn<AlugaPessoaFisicaView, LocalTime> horaSaidaCliFisCol;

	@FXML
	private TableColumn<AlugaPessoaFisicaView, Boolean> situacaoCliFisCol;

	// Fim tabela

	// Tabela de listagem de alugueis de cliente jurídico
	@FXML
	private Tab cliJuriTab;

	@FXML
	private TableView<AlugaPessoaJuridicaView> cliJuriTabela;

	@FXML
	private TableColumn<AlugaPessoaJuridicaView, String> nomeCliJurCol;

	@FXML
	private TableColumn<AlugaPessoaJuridicaView, String> cnpjCliJurCol;

	@FXML
	private TableColumn<AlugaPessoaJuridicaView, Quarto> quartoCliJurCol;

	@FXML
	private TableColumn<AlugaPessoaJuridicaView, LocalDate> dataEntCliJurCol;

	@FXML
	private TableColumn<AlugaPessoaJuridicaView, LocalTime> horaEntCliJurCol;

	@FXML
	private TableColumn<AlugaPessoaJuridicaView, LocalDate> dataSaidaCliJurCol;

	@FXML
	private TableColumn<AlugaPessoaJuridicaView, LocalTime> horaSaidaCliJurCol;

	@FXML
	private TableColumn<AlugaPessoaJuridicaView, Boolean> situacaoCliJurCol;

	// Fim tabela

	@FXML
	private JFXButton editarAluguelBtn;

	@FXML
	private Tab novoAluguelTab;

	@FXML
	private Tab alugClienteTab;

	@FXML
	private JFXButton alugPesqClientBtn;

	@FXML
	private JFXTextField alugPesqClientField;

	@FXML
	private JFXButton alugAtualizarCliTabelaBtn;

	@FXML
	private JFXRadioButton novoCliFisiRadio;

	@FXML
	private JFXRadioButton novoCliJuriRadio;

	// Tabela de listagem de cliente físico para novo aluguel
	@FXML
	private Tab novoCliFisiTab;

	@FXML
	private TableView<PessoaFisica> novoCliTabela;

	@FXML
	private TableColumn<PessoaFisica, String> nomeCliCol;

	@FXML
	private TableColumn<PessoaFisica, String> cpfCliCol;

	// Fim tabela

	// Tabela de listagem de cliente juridico para novo aluguel
	@FXML
	private Tab novoCliJuriTab;

	@FXML
	private TableView<PessoaJuridica> novoCliJuriTabela;

	@FXML
	private TableColumn<PessoaJuridica, String> nomeCliJuriCol;

	@FXML
	private TableColumn<PessoaJuridica, String> cnpjJuriCol;

	// Fim tabela

	@FXML
	private JFXButton alugVoltarListAlugBtn;

	@FXML
	private JFXButton alugContCadBtn;

	@FXML
	private Tab alugListQuartTab;

	@FXML
	private JFXButton alugPesqQuartoBtn;

	@FXML
	private JFXTextField alugPesqQuartoField;

	@FXML
	private JFXButton alugAtualizaQuartTabelaBtn;

	// Tabela de listagem de quartos disponiveis para um novo aluguel

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

	// Fim tabela

	@FXML
	private JFXButton alugVoltarQuartBtn;

	@FXML
	private JFXButton alugContQuartBtn;

	@FXML
	private Tab alugDadosGeralTab;

	@FXML
	private JFXTextField novoValorDiariaField;

	@FXML
	private JFXDatePicker novoSaidaDateP;

	@FXML
	private JFXTimePicker novoSaidaTimeP;

	@FXML
	private JFXButton alugFinalizarBtn;

	@FXML
	private JFXButton alugVoltarDadosGeraisBtn;

	@FXML
	private JFXButton alugAtualizaBtn;

	@FXML
	private JFXDatePicker novoEntradaDateP;

	@FXML
	private JFXTimePicker novoEntradaTimeP;

	@FXML
	private JFXCheckBox novoSituacaoCBox;

	@FXML
	private JFXTextField novoValorTotalField;

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
    private JFXButton voltarListBtn;
	
	@FXML
	void action(ActionEvent event) {

		// Eventos da seção de listagem de alugueis

		if (event.getSource() == cliFisiRadio) {

			cliFisiRadio.setSelected(true);
			cliJuriRadio.setSelected(false);
			cliFisiTab.setDisable(false);
			cliJuriTab.setDisable(true);
			cliFisiTab.getTabPane().getSelectionModel().select(cliFisiTab);
		}

		if (event.getSource() == cliJuriRadio) {

			cliJuriRadio.setSelected(true);
			cliFisiRadio.setSelected(false);
			cliFisiTab.setDisable(true);
			cliJuriTab.setDisable(false);
			cliJuriTab.getTabPane().getSelectionModel().select(cliJuriTab);
		}

		/**
		 * Buscar alugueis
		 */
		if (event.getSource() == pesqAluguelBtn) {

			/**
			 * Buscar por cliente físico
			 */
			if (cliFisiRadio.isSelected()) {

				cliFisiRadio.setSelected(true);
				cliJuriRadio.setSelected(false);

				try {
					
					fisicas = Facade.getInstance().buscarAlugadosFisicosView(pesqAluguelField.getText());
					
					cliFisTabela.getItems()
							.setAll(fisicas);
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
					cliJuriTabela.getItems().setAll(Facade.getInstance().buscarAlugadosJuridicosView(pesqAluguelField.getText()));
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}

		if (event.getSource() == novoAluguelBtn) {

			novoAluguelTab.setDisable(false);
			novoAluguelTab.getTabPane().getSelectionModel().select(novoAluguelTab);

		}

		if (event.getSource() == editarAluguelBtn) {

		}

		// Fim dos eventos da seção de listagem de alugueis

		// --------------------------------------------------------------------------------

		// eventos da seção de novo aluguel - Cliente

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

		if (event.getSource() == alugPesqClientBtn) {

			/**
			 * cliente fisico selecionado
			 */
			if (novoCliFisiRadio.isSelected()) {

				try {

					novoCliTabela.getItems()
							.setAll(Facade.getInstance().buscarPessoasFisica(alugPesqClientField.getText()));
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
							.setAll(Facade.getInstance().buscarPessoasJuridica(alugPesqClientField.getText()));
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
		if (event.getSource() == alugVoltarListAlugBtn) {

			novoAluguelTab.setDisable(true);
			alugadosListTab.getTabPane().getSelectionModel().select(alugadosListTab);

		}

		/**
		 * Continua para o Tab quartos
		 */
		if (event.getSource() == alugContCadBtn) {

			if (novoCliTabela.getSelectionModel().getSelectedItem() != null) {

				cliente = novoCliTabela.getSelectionModel().getSelectedItem();

			} else if (novoCliJuriTabela.getSelectionModel().getSelectedItem() != null) {

				cliente = novoCliJuriTabela.getSelectionModel().getSelectedItem();

			}

			alugListQuartTab.setDisable(false);
			alugListQuartTab.getTabPane().getSelectionModel().select(alugListQuartTab);

		}

		// Fim dos eventos da seção de novo aluguel - Cliente

		// -------------------------------------------------------------

		// eventos da seção de novo aluguel - Quarto

		if (event.getSource() == alugPesqQuartoBtn) {

			try {
				alugQuartoTabela.getItems()
						.setAll(Facade.getInstance().buscarQuartoViewDisponivel(alugPesqQuartoField.getText()));
				limparCamposPesquisa();
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		/**
		 * volta para a seção do cliente
		 */
		if (event.getSource() == alugVoltarQuartBtn) {

			alugClienteTab.getTabPane().getSelectionModel().select(alugClienteTab);

		}

		/**
		 * continua para a seção do dados do aluguel
		 */
		if (event.getSource() == alugContQuartBtn) {

			if (alugQuartoTabela.getSelectionModel().getSelectedItem() != null) {
				quartoView = alugQuartoTabela.getSelectionModel().getSelectedItem();

				alugDadosGeralTab.setDisable(false);
				alugDadosGeralTab.getTabPane().getSelectionModel().select(alugDadosGeralTab);

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
		if (event.getSource() == alugVoltarDadosGeraisBtn) {

			alugListQuartTab.getTabPane().getSelectionModel().select(alugListQuartTab);

		}

		/**
		 * Finalizar o cadastro de um aluguel
		 */
		if (event.getSource() == alugFinalizarBtn) {

			try {
				cadastrarAluguel(quartoView);

			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro!", "Erro ao cadastrar!", e.getMessage());
			}

		}

		/**
		 * Atualizar o aluguel
		 */
		if (event.getSource() == alugAtualizaBtn) {

		}
		
		if(event.getSource() == voltarListBtn) {
			
			alugadosListTab.getTabPane().getSelectionModel().select(alugadosListTab);
			
		}

		if(event.getSource() == buscarInfoBtn) {
			
			
			try {
				saldoInfoField.setText(""+Facade.getInstance().buscarValorTotalDeAlugados(dataInicioDateP.getValue(), dataFimDateP.getValue()));
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro!", "Erro ao buscar!", "Erro ao buscar valores totais!");
			}
			
			
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		inicializar();

	}

	/**
	 * Método para iniciar componentes da tela de aluguel
	 */
	public void inicializar() {

		/**
		 * Dados da tabela de alugados para cliente físico
		 */
		nomeCliFisCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

		cpfCliFisCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));

		quartoCliFisCol.setCellValueFactory(new PropertyValueFactory<>("quarto"));

		dataEntCliFisCol.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));

		horaEntCliFisCol.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));

		dataSaidaCliFisCol.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));

		horaSaidaCliFisCol.setCellValueFactory(new PropertyValueFactory<>("horaSaida"));

		situacaoCliFisCol.setCellValueFactory(new PropertyValueFactory<>("status"));

		nomeCliFisCol.setCellFactory(coluna -> {
			return new TableCell<AlugaPessoaFisicaView, String>() {
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
			return new TableCell<AlugaPessoaFisicaView, String>() {
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
			return new TableCell<AlugaPessoaFisicaView, Quarto>() {
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

		dataSaidaCliJurCol.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));

		horaSaidaCliJurCol.setCellValueFactory(new PropertyValueFactory<>("horaSaida"));

		situacaoCliJurCol.setCellValueFactory(new PropertyValueFactory<>("status"));

		nomeCliJurCol.setCellFactory(coluna -> {
			return new TableCell<AlugaPessoaJuridicaView, String>() {
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
			return new TableCell<AlugaPessoaJuridicaView, String>() {
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
			return new TableCell<AlugaPessoaJuridicaView, Quarto>() {
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
		 * Tabela do cliente físico para um novo cadastro de aluguel.
		 */
		nomeCliCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

		cpfCliCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));

		/**
		 * Tabela do cliente jurídico para um novo cadastro de aluguel.
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

		MaskFieldUtil.monetaryField(novoValorTotalField);
		MaskFieldUtil.monetaryField(novoValorDiariaField);

	}

	public void limparCamposPesquisa() {

		pesqAluguelField.clear();

		alugPesqClientField.clear();

		alugPesqQuartoField.clear();

	}

	public void limparCampos() {

		novoValorDiariaField.clear();

		novoSaidaDateP.getEditor().clear();

		novoSaidaTimeP.getEditor().clear();

		novoEntradaDateP.getEditor().clear();

		novoEntradaTimeP.getEditor().clear();

		novoSituacaoCBox.setSelected(true);

		novoValorTotalField.clear();

	}

	public void atualizarAluguel(Aluga aluga) {

	}

	public void cadastrarAluguel(QuartoView q) throws BusinessException {

		aluga = new Aluga();

		caixa = Facade.getInstance().searchCaixa(ControlerLogin.getCaixa().getId());

		int dias = novoSaidaDateP.getValue().compareTo(novoEntradaDateP.getValue());

		System.out.println("dias da reserva: " + dias);

		aluga.setDiaria(dias);
		aluga.setValorDiaria(Double.parseDouble(novoValorDiariaField.getText()));

		aluga.setValorTotal((aluga.getValorDiaria() * dias));
		caixa.setEntrada(caixa.getSaldo() + aluga.getValorTotal());

		aluga.setCaixa(caixa);

		aluga.setDataEntrada(novoEntradaDateP.getValue());
		aluga.setHoraEntrada(novoEntradaTimeP.getValue());

		aluga.setDataSaida(novoSaidaDateP.getValue());
		aluga.setHoraSaida(novoSaidaTimeP.getValue());

		aluga.setStatus(novoSituacaoCBox.isSelected());

		aluga.setFuncionario(ControlerLogin.getUsuario());

		aluga.setCliente(cliente);

		aluga.setQuarto(Facade.getInstance().searchQuarto(q.getId()));

		Facade.getInstance().createOrUpdateAluga(aluga);

	}

}
