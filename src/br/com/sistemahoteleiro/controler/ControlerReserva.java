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
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import br.com.sistemahoteleiro.model.Aluga;
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
	private TableView<Reserva> reservTabela;

	@FXML
	private TableColumn<Reserva, ?> dataReservCol;

	@FXML
	private TableColumn<Reserva, ?> horaReservCol;

	@FXML
	private TableColumn<Reserva, ?> valorReservCol;

	@FXML
	private TableColumn<Reserva, ?> situacaoReservCol;

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
	private TableView<Cliente> clienteTabela;

	@FXML
	private TableColumn<?, ?> nomeCol;

	@FXML
	private TableColumn<?, ?> rgCol;

	@FXML
	private TableColumn<?, ?> cpfCol;

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
	private TableView<?> quartoTabela;

	@FXML
	private TableColumn<?, ?> quartoCol;

	@FXML
	private TableColumn<?, ?> qtCamasCol;

	@FXML
	private TableColumn<?, ?> tipoCol;

	@FXML
	private TableColumn<?, ?> disponivelCol;

	@FXML
	private JFXButton voltarQuartBtn;

	@FXML
	private JFXButton contQuartBtn;

	@FXML
	private Tab dadosGeraisTab;

	@FXML
	private JFXTextField reserValorField;

	@FXML
	private JFXDatePicker reserDateP;

	@FXML
	private JFXTimePicker reserTimeP;

	@FXML
	private JFXButton reserFinalBtn;

	@FXML
	private JFXButton reserVoltarDadosGBtn;

	@FXML
	private JFXCheckBox reserSituacaoCBox;

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
		 * Tabela Reserva List
		 */

		dataReservCol.setCellValueFactory(new PropertyValueFactory<>("dataReserva"));

		horaReservCol.setCellValueFactory(new PropertyValueFactory<>("horaReserva"));

		valorReservCol.setCellValueFactory(new PropertyValueFactory<>("valor"));

		situacaoReservCol.setCellValueFactory(new PropertyValueFactory<>("situacao"));

		/**
		 * Tabela Cliente da Tab Reserva
		 */

		nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

		rgCol.setCellValueFactory(new PropertyValueFactory<>("rg"));

		cpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));

		/**
		 * Tabela Quarto da Tab Reserva
		 */

		quartoCol.setCellValueFactory(new PropertyValueFactory<>("numQuarto"));

		qtCamasCol.setCellValueFactory(new PropertyValueFactory<>("qtdCamas"));

		tipoCol.setCellValueFactory(new PropertyValueFactory<>("tipoQuarto"));

		disponivelCol.setCellValueFactory(new PropertyValueFactory<>("disponivel"));

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

		reserValorField.clear();

		reserDateP.setValue(null);

		reserTimeP.setValue(null);

		reserSituacaoCBox.setSelected(true);

	}
}
