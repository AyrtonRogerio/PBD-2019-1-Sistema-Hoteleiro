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
import br.com.sistemahoteleiro.model.Aluga;
import br.com.sistemahoteleiro.model.AlugaPessoaFisicaView;
import br.com.sistemahoteleiro.model.AlugaPessoaJuridicaView;
import br.com.sistemahoteleiro.model.Caixa;
import br.com.sistemahoteleiro.model.Cliente;
import br.com.sistemahoteleiro.model.Funcionario;
import br.com.sistemahoteleiro.model.Quarto;
import br.com.sistemahoteleiro.model.Reserva;
import br.com.sistemahoteleiro.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	private Aluga aluga;
	private Cliente clienteReserva, clienteAluga;
	private Caixa caixa;
	private Funcionario funcionario;

	/**
	 * Atributos List
	 */
	private List<Quarto> quartos = null;
	private List<Cliente> clientes = null;
	private List<Reserva> reservas = null;
	private List<Aluga> alugas = null;

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
    private TableView<?> cliFisTabela;

    @FXML
    private TableColumn<?, ?> nomeCliFisCol;

    @FXML
    private TableColumn<?, ?> cpfCliFisCol;

    @FXML
    private TableColumn<?, ?> quartoCliFisCol;

    @FXML
    private TableColumn<?, ?> dataEntCliFisCol;

    @FXML
    private TableColumn<?, ?> horaEntCliFisCol;

    @FXML
    private TableColumn<?, ?> situacaoCliFisCol;

    @FXML
    private Tab cliJuriTab;

    @FXML
    private TableView<?> cliJuriTabela;

    @FXML
    private TableColumn<?, ?> nomeCliJurCol;

    @FXML
    private TableColumn<?, ?> cnpjCliJurCol;

    @FXML
    private TableColumn<?, ?> quartoCliJurCol;

    @FXML
    private TableColumn<?, ?> dataEntCliJurCol;

    @FXML
    private TableColumn<?, ?> horaEntCliJurCol;

    @FXML
    private TableColumn<?, ?> situacaoCliJurCol;

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
    private TableView<?> novoCliTabela;

    @FXML
    private TableColumn<?, ?> nomeCliCol;

    @FXML
    private TableColumn<?, ?> cpfCliCol;

    @FXML
    private Tab novoCliJuriTab;

    @FXML
    private TableView<?> novoCliJuriTabela;

    @FXML
    private TableColumn<?, ?> nomeCliJuriCol;

    @FXML
    private TableColumn<?, ?> cnpjJuriCol;

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
    private TableView<?> alugQuartoTabela;

    @FXML
    private TableColumn<?, ?> novoQuartoCol;

    @FXML
    private TableColumn<?, ?> novoQtCamasCol;

    @FXML
    private TableColumn<?, ?> novoTipoCol;

    @FXML
    private TableColumn<?, ?> novoDisponivelCol;

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
    void action(ActionEvent event) {

    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

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

//		nomeCliFisCol.setCellFactory(coluna -> {
//			return new TableCell<AlugaPessoaFisicaView, String>() {
//				protected void updateItem(String item, boolean empty) {
//					super.updateItem(item, empty);
//
//					if (item == null || empty) {
//						setText(null);
//					} else {
//						setText("" + item);
//					}
//				}
//			};
//		});
//
//		cpfCliFisCol.setCellFactory(coluna -> {
//			return new TableCell<AlugaPessoaFisicaView, String>() {
//				protected void updateItem(String item, boolean empty) {
//					super.updateItem(item, empty);
//
//					if (item == null || empty) {
//						setText(null);
//					} else {
//						setText("" + item);
//					}
//				}
//			};
//		});
//
//		quartoCliFisCol.setCellFactory(coluna -> {
//			return new TableCell<AlugaPessoaFisicaView, Quarto>() {
//				protected void updateItem(Quarto item, boolean empty) {
//					super.updateItem(item, empty);
//
//					if (item == null || empty) {
//						setText(null);
//					} else {
//						setText("" + item.getNumQuarto());
//					}
//
//				}
//			};
//		});
		
		/**
		 * dados da tabela de alugados para cliente jurídico
		 */
		nomeCliJurCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

		cnpjCliJurCol.setCellValueFactory(new PropertyValueFactory<>("cnpj"));

		quartoCliJurCol.setCellValueFactory(new PropertyValueFactory<>("quarto"));

		dataEntCliJurCol.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));

		horaEntCliJurCol.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));

		situacaoCliJurCol.setCellValueFactory(new PropertyValueFactory<>("status"));

//		nomeCliJurCol.setCellFactory(coluna -> {
//			return new TableCell<AlugaPessoaJuridicaView, String>() {
//				protected void updateItem(String item, boolean empty) {
//					super.updateItem(item, empty);
//
//					if (item == null || empty) {
//						setText(null);
//					} else {
//						setText("" + item);
//					}
//				}
//			};
//		});
//
//		cnpjCliJurCol.setCellFactory(coluna -> {
//			return new TableCell<AlugaPessoaJuridicaView, String>() {
//				protected void updateItem(String item, boolean empty) {
//					super.updateItem(item, empty);
//
//					if (item == null || empty) {
//						setText(null);
//					} else {
//						setText("" + item);
//					}
//				}
//			};
//		});
//
//		quartoCliJurCol.setCellFactory(coluna -> {
//			return new TableCell<AlugaPessoaJuridicaView, Quarto>() {
//				protected void updateItem(Quarto item, boolean empty) {
//					super.updateItem(item, empty);
//
//					if (item == null || empty) {
//						setText(null);
//					} else {
//						setText("" + item.getNumQuarto());
//					}
//
//				}
//			};
//		});

		
		
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

	/**
	 * Método para cadastrar a Reserva
	 */
	public void cadastrarReserva() {

		reserva = new Reserva();

	}

	/**
	 * Método para limpar os campos de Reserva
	 */
	public void limparCamposReserva() {

		pesqReservField.clear();

		pesqClientField.clear();

		pesqQuartoField.clear();

		valorField.clear();

		reservaDateP.setValue(null);

		reservaTimeP.setValue(null);

		situacaoCBox.setSelected(true);

	}
}
