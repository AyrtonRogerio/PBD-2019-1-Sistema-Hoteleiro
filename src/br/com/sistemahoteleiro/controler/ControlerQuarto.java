/**
 * 
 */
package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @author ayrtons
 *
 */
public class ControlerQuarto implements Initializable {

	
	@FXML // fx:id="listaQuartosTab"
    private Tab listaQuartosTab; // Value injected by FXMLLoader

    @FXML // fx:id="pesquisaField"
    private TextField pesquisaField; // Value injected by FXMLLoader

    @FXML // fx:id="pesquisaButton"
    private Button pesquisaButton; // Value injected by FXMLLoader

    @FXML // fx:id="tabelaQuarto"
    private TableView<?> tabelaQuarto; // Value injected by FXMLLoader

    @FXML // fx:id="quartoCollum"
    private TableColumn<?, ?> quartoCollum; // Value injected by FXMLLoader

    @FXML // fx:id="qtCamasCollum"
    private TableColumn<?, ?> qtCamasCollum; // Value injected by FXMLLoader

    @FXML // fx:id="tipoColum"
    private TableColumn<?, ?> tipoColum; // Value injected by FXMLLoader

    @FXML // fx:id="tvCaboColum"
    private TableColumn<?, ?> tvCaboColum; // Value injected by FXMLLoader

    @FXML // fx:id="cofreColum"
    private TableColumn<?, ?> cofreColum; // Value injected by FXMLLoader

    @FXML // fx:id="tvLedColum"
    private TableColumn<?, ?> tvLedColum; // Value injected by FXMLLoader

    @FXML // fx:id="telColum"
    private TableColumn<?, ?> telColum; // Value injected by FXMLLoader

    @FXML // fx:id="arCondColum"
    private TableColumn<?, ?> arCondColum; // Value injected by FXMLLoader

    @FXML // fx:id="wifiColum"
    private TableColumn<?, ?> wifiColum; // Value injected by FXMLLoader

    @FXML // fx:id="miniBarColum"
    private TableColumn<?, ?> miniBarColum; // Value injected by FXMLLoader

    @FXML // fx:id="disponivelColum"
    private TableColumn<?, ?> disponivelColum; // Value injected by FXMLLoader

    @FXML // fx:id="editarButton"
    private Button editarButton; // Value injected by FXMLLoader

    @FXML // fx:id="novoAlugelTab"
    private Tab novoAlugelTab; // Value injected by FXMLLoader

    @FXML // fx:id="numQuartoField"
    private TextField numQuartoField; // Value injected by FXMLLoader

    @FXML // fx:id="qtdCamaField"
    private TextField qtdCamaField; // Value injected by FXMLLoader

    @FXML // fx:id="tipoField"
    private TextField tipoField; // Value injected by FXMLLoader

    @FXML // fx:id="tvCaboCBox"
    private CheckBox tvCaboCBox; // Value injected by FXMLLoader

    @FXML // fx:id="cofreCBox"
    private CheckBox cofreCBox; // Value injected by FXMLLoader

    @FXML // fx:id="tvLedCBox"
    private CheckBox tvLedCBox; // Value injected by FXMLLoader

    @FXML // fx:id="telefoneCBox"
    private CheckBox telefoneCBox; // Value injected by FXMLLoader

    @FXML // fx:id="arCondCBox"
    private CheckBox arCondCBox; // Value injected by FXMLLoader

    @FXML // fx:id="wifiCBox"
    private CheckBox wifiCBox; // Value injected by FXMLLoader

    @FXML // fx:id="miniBarCBox"
    private CheckBox miniBarCBox; // Value injected by FXMLLoader

    @FXML // fx:id="disponivelCBox"
    private CheckBox disponivelCBox; // Value injected by FXMLLoader

    @FXML // fx:id="cancelarButton"
    private Button cancelarButton; // Value injected by FXMLLoader

    @FXML // fx:id="cadastrarButton"
    private Button cadastrarButton; // Value injected by FXMLLoader

    @FXML
    void action(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
