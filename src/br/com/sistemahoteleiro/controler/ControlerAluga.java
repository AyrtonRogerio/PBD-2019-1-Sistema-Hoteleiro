package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaView;
import br.com.sistemahoteleiro.model.Caixa;
import br.com.sistemahoteleiro.model.Cliente;
import br.com.sistemahoteleiro.model.PessoaFisica;
import br.com.sistemahoteleiro.model.PessoaJuridica;
import br.com.sistemahoteleiro.model.Quarto;
import br.com.sistemahoteleiro.model.QuartoView;
import br.com.sistemahoteleiro.model.Usuario;
import br.com.sistemahoteleiro.util.MaskFieldUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author ayrton
 *
 */
public class ControlerAluga implements Initializable {

	private Quarto quarto;
	private Aluga aluga;
	private Cliente Cliente;
	private Caixa caixa;
	private Usuario usuario;

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

	//Tabela de listagem de alugueis de cliente físico 
	@FXML
	private TableView<AlugaView> cliFisTabela;

	@FXML
	private TableColumn<AlugaView, Cliente> nomeCliFisCol;

	@FXML
	private TableColumn<AlugaView, Cliente> cpfCliFisCol;

	@FXML
	private TableColumn<AlugaView, QuartoView> quartoCliFisCol;

	@FXML
	private TableColumn<AlugaView, LocalDate> dataEntCliFisCol;

	@FXML
	private TableColumn<AlugaView, LocalTime> horaEntCliFisCol;

	@FXML
	private TableColumn<AlugaView, LocalDate> dataSaidaCliFisCol;

	@FXML
	private TableColumn<AlugaView, LocalTime> horaSaidaCliFisCol;

	@FXML
	private TableColumn<AlugaView, Boolean> situacaoCliFisCol;

	//Fim tabela
	
	
	//Tabela de listagem de alugueis de cliente jurídico
	@FXML
	private Tab cliJuriTab;

	@FXML
	private TableView<AlugaView> cliJuriTabela;

	@FXML
	private TableColumn<AlugaView, Cliente> nomeCliJurCol;

	@FXML
	private TableColumn<AlugaView, Cliente> cnpjCliJurCol;

	@FXML
	private TableColumn<AlugaView, QuartoView> quartoCliJurCol;

	@FXML
	private TableColumn<AlugaView, LocalDate> dataEntCliJurCol;

	@FXML
	private TableColumn<AlugaView, LocalTime> horaEntCliJurCol;

	@FXML
	private TableColumn<AlugaView, LocalDate> dataSaidaCliJurCol;

	@FXML
	private TableColumn<AlugaView, LocalTime> horaSaidaCliJurCol;

	@FXML
	private TableColumn<AlugaView, Boolean> situacaoCliJurCol;

	//Fim tabela
	
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

	
	//Tabela de listagem de cliente físico para novo aluguel
	@FXML
	private Tab novoCliFisiTab;

	@FXML
	private TableView<PessoaFisica> novoCliTabela;

	@FXML
	private TableColumn<PessoaFisica, String> nomeCliCol;

	@FXML
	private TableColumn<PessoaFisica, String> cpfCliCol;

	//Fim tabela
	
	
	//Tabela de listagem de cliente juridico para novo aluguel
	@FXML
	private Tab novoCliJuriTab;

	@FXML
	private TableView<PessoaJuridica> novoCliJuriTabela;

	@FXML
	private TableColumn<PessoaJuridica, String> nomeCliJuriCol;

	@FXML
	private TableColumn<PessoaJuridica, String> cnpjJuriCol;

	//Fim tabela
	
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

	//Tabela de listagem de quartos disponiveis para um novo aluguel
	
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

	//Fim tabela
	
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
	void action(ActionEvent event) {

		//Eventos da seção de listagem de alugueis
		
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
		
		/**
		 * Buscar alugueis 
		 */
		if(event.getSource() == pesqAluguelBtn) {
			
			
			/**
			 * Buscar por cliente físico 
			 */
			if(cliFisiRadio.isSelected()) {
				
				cliFisiRadio.setSelected(true);
				cliJuriRadio.setSelected(false);
		
			}
			
			/**
			 * Buscar por cliente juridico
			 */
			if(cliJuriRadio.isSelected()) {
				
				cliJuriRadio.setSelected(true);
				cliFisiRadio.setSelected(false);
		
			}
			
		}
		
		
		if(event.getSource() == novoAluguelBtn) {
			
			
			novoAluguelTab.setDisable(false);
			novoAluguelTab.getTabPane().getSelectionModel().select(novoAluguelTab);
			
		}
		
		
		if(event.getSource() == editarAluguelBtn) {
			
			
			
		}
		
		//Fim dos eventos da seção de listagem de alugueis
		
		//--------------------------------------------------------------------------------
		
		//eventos da seção de novo aluguel - Cliente
		
		if(event.getSource() == novoCliFisiRadio) {
			
			novoCliFisiRadio.setSelected(true);
			novoCliJuriRadio.setSelected(false);
			novoCliFisiTab.setDisable(false);
			novoCliJuriTab.setDisable(true);
			novoCliFisiTab.getTabPane().getSelectionModel().select(novoCliFisiTab);
			
		}
		
		if(event.getSource() == novoCliJuriRadio) {
			
			novoCliFisiRadio.setSelected(false);
			novoCliJuriRadio.setSelected(true);
			novoCliFisiTab.setDisable(true);
			novoCliJuriTab.setDisable(false);
			novoCliJuriTab.getTabPane().getSelectionModel().select(novoCliJuriTab);
		}
		
		
		if(event.getSource() == alugPesqClientBtn) {
			
			
			/**
			 * cliente fisico selecionado
			 */
			if(novoCliFisiRadio.isSelected()) {
				
			}
			
			/**
			 * cliente juridico selecionado
			 */
			if(novoCliJuriRadio.isSelected()) {
				
			}
			
		}
		
		/**
		 * Volta para a seção de listagem de alugueis
		 */
		if(event.getSource() == alugVoltarListAlugBtn) {
			
			novoAluguelTab.setDisable(true);
			alugadosListTab.getTabPane().getSelectionModel().select(alugadosListTab);
			
		}
		
		/**
		 * Continua para o Tab quartos
		 */
		if(event.getSource() == alugContCadBtn) {
			
			
			alugListQuartTab.setDisable(false);
			alugListQuartTab.getTabPane().getSelectionModel().select(alugListQuartTab);
			
		}
		
		// Fim dos eventos da seção de novo aluguel - Cliente
		
		//-------------------------------------------------------------
		
		//eventos da seção de novo aluguel - Quarto
		
		if(event.getSource() == alugPesqQuartoBtn) {
			
			
			
		}
		
		/**
		 * volta para a seção do cliente 
		 */
		if(event.getSource() == alugVoltarQuartBtn) {
			
			alugClienteTab.getTabPane().getSelectionModel().select(alugClienteTab);
			
		}
		
		/**
		 * continua para a seção do dados do aluguel
		 */
		if(event.getSource() == alugContQuartBtn) {
			
			alugDadosGeralTab.setDisable(false);
			alugDadosGeralTab.getTabPane().getSelectionModel().select(alugDadosGeralTab);
			
		}		
		//Fim dos eventos da seção de quartos
		
		//-------------------------------------------------------------------------------
		
		//Eventos da seção de dados gerais 
		
		
		/**
		 * Voltar pra seção de listagem de quartos
		 */
		if(event.getSource() == alugVoltarDadosGeraisBtn) {
			
			alugListQuartTab.getTabPane().getSelectionModel().select(alugListQuartTab);
			
		}
		
		
		/**
		 * Finalizar o cadastro de um aluguel
		 */
		if(event.getSource() == alugFinalizarBtn) {
			
			
			
		}
		
		/**
		 * Atualizar o aluguel
		 */
		if(event.getSource() == alugAtualizaBtn) {
			
			
			
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
		nomeCliFisCol.setCellValueFactory(new PropertyValueFactory<>(""));

		cpfCliFisCol.setCellValueFactory(new PropertyValueFactory<>(""));

		quartoCliFisCol.setCellValueFactory(new PropertyValueFactory<>(""));

		dataEntCliFisCol.setCellValueFactory(new PropertyValueFactory<>(""));

		horaEntCliFisCol.setCellValueFactory(new PropertyValueFactory<>(""));

		dataSaidaCliFisCol.setCellValueFactory(new PropertyValueFactory<>(""));

		horaSaidaCliFisCol.setCellValueFactory(new PropertyValueFactory<>(""));

		situacaoCliFisCol.setCellValueFactory(new PropertyValueFactory<>(""));

		/**
		 * dados da tabela de alugados para cliente jurídico
		 */
		nomeCliJurCol.setCellValueFactory(new PropertyValueFactory<>(""));

		cnpjCliJurCol.setCellValueFactory(new PropertyValueFactory<>(""));

		quartoCliJurCol.setCellValueFactory(new PropertyValueFactory<>(""));

		dataEntCliJurCol.setCellValueFactory(new PropertyValueFactory<>(""));

		horaEntCliJurCol.setCellValueFactory(new PropertyValueFactory<>(""));

		dataSaidaCliJurCol.setCellValueFactory(new PropertyValueFactory<>(""));

		horaSaidaCliJurCol.setCellValueFactory(new PropertyValueFactory<>(""));

		situacaoCliJurCol.setCellValueFactory(new PropertyValueFactory<>(""));

		/**
		 * Tabela do cliente físico para um novo cadastro de aluguel.
		 */
		nomeCliCol.setCellValueFactory(new PropertyValueFactory<>(""));

		cpfCliCol.setCellValueFactory(new PropertyValueFactory<>(""));

		/**
		 * Tabela do cliente jurídico para um novo cadastro de aluguel.
		 */
		nomeCliJuriCol.setCellValueFactory(new PropertyValueFactory<>(""));

		cnpjJuriCol.setCellValueFactory(new PropertyValueFactory<>(""));

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

	public void limparCampos() {

		pesqAluguelField.clear();

		alugPesqClientField.clear();

		alugPesqQuartoField.clear();

		novoValorDiariaField.clear();

		novoSaidaDateP.getEditor().clear();

		novoSaidaTimeP.getEditor().clear();

		novoEntradaDateP.getEditor().clear();

		novoEntradaTimeP.getEditor().clear();

		novoSituacaoCBox.setSelected(true);

		novoValorTotalField.clear();

	}

	public void atualizarAluguel() {

		
		
		
	}

	public void cadastrarAluguel() {

		
		
		
	}

}
