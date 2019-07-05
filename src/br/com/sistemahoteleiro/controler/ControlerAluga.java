package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import br.com.sistemahoteleiro.model.Aluga;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author ayrton
 *
 */
public class ControlerAluga implements Initializable {

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
	private TableView<?> alugListTabela;

	@FXML
	private TableColumn<?, ?> alugNomeCliCol;

	@FXML
	private TableColumn<?, ?> alugCpfCliCol;

	@FXML
	private TableColumn<?, ?> alugCnpjCol;

	@FXML
	private TableColumn<?, ?> alugNumQuartCol;

	@FXML
	private TableColumn<?, ?> alugDataEntradaCol;

	@FXML
	private TableColumn<?, ?> alugHoraEntradaCol;

	@FXML
	private TableColumn<?, ?> alugDataSaidaCol;

	@FXML
	private TableColumn<?, ?> alugHoraSaidaCol;

	@FXML
	private TableColumn<?, ?> alugSituacaoCol;

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
	private TableView<?> novoClienteTabela;

	@FXML
	private TableColumn<?, ?> novoNomeCol;

	@FXML
	private TableColumn<?, ?> novoRgCol;

	@FXML
	private TableColumn<?, ?> novoCpfCol;

	@FXML
	private TableColumn<?, ?> novoCnpjCol;

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

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
