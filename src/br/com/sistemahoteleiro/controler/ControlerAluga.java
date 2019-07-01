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
    private TableView<Aluga> alugListTabela;

    @FXML
    private TableColumn<Aluga, ?> alugNomeCliCol;

    @FXML
    private TableColumn<Aluga, ?> alugCpfCliCol;

    @FXML
    private TableColumn<Aluga, ?> alugNumQuartCol;

    @FXML
    private TableColumn<Aluga, ?> alugDataEntradaCol;

    @FXML
    private TableColumn<Aluga, ?> alugHoraEntradaCol;

    @FXML
    private TableColumn<Aluga, ?> alugDataSaidaCol;

    @FXML
    private TableColumn<Aluga, ?> alugHoraSaidaCol;

    @FXML
    private TableColumn<Aluga, ?> alugSituacaoCol;

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
    private TableView<?> alugClienteTabela;

    @FXML
    private TableColumn<?, ?> alugNomeCol;

    @FXML
    private TableColumn<?, ?> alugRgCol;

    @FXML
    private TableColumn<?, ?> alugCpfCol;

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
    private TableColumn<?, ?> alugQuartoCol;

    @FXML
    private TableColumn<?, ?> alugQtCamasCol;

    @FXML
    private TableColumn<?, ?> alugTipoCol;

    @FXML
    private TableColumn<?, ?> alugDisponivelCol;

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

    @FXML
    void action(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

