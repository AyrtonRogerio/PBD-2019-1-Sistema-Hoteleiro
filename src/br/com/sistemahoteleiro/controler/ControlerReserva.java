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

	/**
	 * Atributos de alugar
	 */
	@FXML
	private Tab alugarTab;

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
	private TableView<Aluga> alugListTabela;

	@FXML
	private TableColumn<Aluga, Cliente> alugNomeCliCol;

	@FXML
	private TableColumn<Aluga, Cliente> alugCpfCliCol;

	@FXML
	private TableColumn<Aluga, Quarto> alugNumQuartCol;

	@FXML
	private TableColumn<Aluga, LocalDate> alugDataEntradaCol;

	@FXML
	private TableColumn<Aluga, LocalTime> alugHoraEntradaCol;

	@FXML
	private TableColumn<Aluga, LocalDate> alugDataSaidaCol;

	@FXML
	private TableColumn<Aluga, LocalTime> alugHoraSaidaCol;

	@FXML
	private TableColumn<Aluga, Boolean> alugSituacaoCol;

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
	private TableView<Cliente> alugClienteTabela;

	@FXML
	private TableColumn<Cliente, String> alugNomeCol;

	@FXML
	private TableColumn<Cliente, String> alugRgCol;

	@FXML
	private TableColumn<Cliente, String> alugCpfCol;

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

	@FXML
	private TableView<Quarto> alugQuartoTabela;

	@FXML
	private TableColumn<Quarto, Integer> alugQuartoCol;

	@FXML
	private TableColumn<Quarto, Integer> alugQtCamasCol;

	@FXML
	private TableColumn<Quarto, String> alugTipoCol;

	@FXML
	private TableColumn<Quarto, Boolean> alugDisponivelCol;

	@FXML
	private JFXButton alugVoltarQuartBtn;

	@FXML
	private JFXButton alugContQuartBtn;

	@FXML
	private Tab alugDadosGeralTab;

	@FXML
	private JFXTextField alugValorDiariaField;

	@FXML
	private JFXDatePicker alugSaidaDateP;

	@FXML
	private JFXTimePicker alugSaidaTimeP;

	@FXML
	private JFXButton alugFinalizarBtn;

	@FXML
	private JFXButton alugVoltarDadosGeraisBtn;

	@FXML
	private JFXButton alugAtualizaBtn;

	@FXML
	private JFXDatePicker alugEntradaDateP;

	@FXML
	private JFXTimePicker alugEntradaTimeP;

	@FXML
	private JFXCheckBox alugSituacaoCBox;

	@FXML
	private JFXTextField alugValorTotalField;

	/**
	 * Atributos da reserva
	 */

	@FXML
	private Tab reservaTab;

	@FXML
	private JFXButton pesqReservBtn;

	@FXML
	private JFXTextField pesqReservField;

	@FXML
	private JFXButton reserAtualizaListReservBtn;

	@FXML
	private TableView<Reserva> reservTabela;

	@FXML
	private TableColumn<Reserva, LocalDate> dataReservCol;

	@FXML
	private TableColumn<Reserva, LocalTime> horaReservCol;

	@FXML
	private TableColumn<Reserva, Double> valorReservCol;

	@FXML
	private TableColumn<Reserva, Boolean> situacaoReservCol;

	@FXML
	private Tab novaReservaTab;

	@FXML
	private Tab reserClienteTab;

	@FXML
	private JFXButton reserPesqClientBtn;

	@FXML
	private JFXTextField reserPesqClientField;

	@FXML
	private JFXButton reserAtualizaCliTabelaBtn;

	@FXML
	private TableView<Cliente> reserClienteTabela;

	@FXML
	private TableColumn<Cliente, String> reserNomeCol;

	@FXML
	private TableColumn<Cliente, String> reserRgCol;

	@FXML
	private TableColumn<Cliente, String> reserCpfCol;

	@FXML
	private JFXButton reserVoltarListBtn;

	@FXML
	private JFXButton reserContCadBtn;

	@FXML
	private Tab reserListaQuartosTab;

	@FXML
	private JFXButton reserPesqQuartoBtn;

	@FXML
	private JFXTextField reserPesqQuartoField;

	@FXML
	private JFXButton reserAtualizarQuartTabelaBtn;

	@FXML
	private TableView<Quarto> reserQuartoTabela;

	@FXML
	private TableColumn<Quarto, Integer> reserQuartoCol;

	@FXML
	private TableColumn<Quarto, Integer> reserQtCamasCol;

	@FXML
	private TableColumn<Quarto, String> reserTipoCol;

	@FXML
	private TableColumn<Quarto, Boolean> reserDisponivelCol;

	@FXML
	private JFXButton reserVoltarQuartBtn;

	@FXML
	private JFXButton reserContQuartBtn;

	@FXML
	private Tab reserDadosGeraisTab;

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

	/**
	 * Método de tratamento de evento do aluguel
	 * 
	 * @param event
	 */
	@FXML
	void actionAluguel(ActionEvent event) {

	}

	/**
	 * Método de tratamento de evento da reserva
	 * 
	 * @param event
	 */
	@FXML
	void actionReserva(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	/**
	 * Método para carregar componentes de aluguel.
	 */
	public void carregarComponentesDeAluguel() {

		/**
		 * Tabela Aluga List
		 */

		alugNomeCliCol.setCellValueFactory(new PropertyValueFactory<>("cliente"));

		alugCpfCliCol.setCellValueFactory(new PropertyValueFactory<>("cliente"));

		alugNumQuartCol.setCellValueFactory(new PropertyValueFactory<>("quarto"));

		alugDataEntradaCol.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));

		alugHoraEntradaCol.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));

		alugDataSaidaCol.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));

		alugHoraSaidaCol.setCellValueFactory(new PropertyValueFactory<>("horaSaida"));

		alugSituacaoCol.setCellValueFactory(new PropertyValueFactory<>("status"));

		/**
		 * Tabela Cliente da Tab Alugar
		 */

		alugNomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

		alugRgCol.setCellValueFactory(new PropertyValueFactory<>("rg"));

		alugCpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));

		/**
		 * Tabela Quarto da Tab Alugar
		 */

		alugQuartoCol.setCellValueFactory(new PropertyValueFactory<>("numQuarto"));

		alugQtCamasCol.setCellValueFactory(new PropertyValueFactory<>("qtdCamas"));

		alugTipoCol.setCellValueFactory(new PropertyValueFactory<>("tipoQuarto"));

		alugDisponivelCol.setCellValueFactory(new PropertyValueFactory<>("disponivel"));

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

		reserNomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

		reserRgCol.setCellValueFactory(new PropertyValueFactory<>("rg"));

		reserCpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));

		/**
		 * Tabela Quarto da Tab Reserva
		 */

		reserQuartoCol.setCellValueFactory(new PropertyValueFactory<>("numQuarto"));

		reserQtCamasCol.setCellValueFactory(new PropertyValueFactory<>("qtdCamas"));

		reserTipoCol.setCellValueFactory(new PropertyValueFactory<>("tipoQuarto"));

		reserDisponivelCol.setCellValueFactory(new PropertyValueFactory<>("disponivel"));

	}

	/**
	 * Método para cadastrar o Aluguel
	 */
	public void cadastrarAluguel() {

		aluga = new Aluga();

		aluga.setCaixa(caixa);
		aluga.setCliente(clienteAluga);
		aluga.setDataEntrada(alugEntradaDateP.getValue());
		aluga.setDataSaida(alugSaidaDateP.getValue());

		long aux = ChronoUnit.DAYS.between(alugEntradaDateP.getValue(), alugSaidaDateP.getValue());
		aluga.setDiaria(Integer.parseInt("" + aux));

		aluga.setFuncionario(funcionario);
		aluga.setHoraEntrada(alugEntradaTimeP.getValue());
		aluga.setHoraSaida(alugSaidaTimeP.getValue());

		aluga.setStatus(alugSituacaoCBox.isSelected());
		
	}

	/**
	 * Método para cadastrar a Reserva
	 */
	public void cadastrarReserva() {

		reserva = new Reserva();

	}

	/**
	 * Método para limpar os campos de Aluguel
	 */
	public void limparCamposAluga() {

		pesqAluguelField.clear();
		alugPesqClientField.clear();
		alugPesqQuartoField.clear();
		alugValorDiariaField.clear();

		alugEntradaDateP.setValue(null);
		alugEntradaTimeP.setValue(null);
		alugSaidaDateP.setValue(null);
		alugSaidaTimeP.setValue(null);

		alugSituacaoCBox.setSelected(true);

	}

	/**
	 * Método para limpar os campos de Reserva
	 */
	public void limparCamposReserva() {

		pesqReservField.clear();

		reserPesqClientField.clear();

		reserPesqQuartoField.clear();

		reserValorField.clear();

		reserDateP.setValue(null);

		reserTimeP.setValue(null);

		reserSituacaoCBox.setSelected(true);
		

	}
}
