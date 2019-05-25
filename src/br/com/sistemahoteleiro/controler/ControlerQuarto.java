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

	 @FXML
	    private Tab listaQuartosTab;

	    @FXML
	    private TextField pesqField;

	    @FXML
	    private Button pesqBtn;

	    @FXML
	    private TableView<?> quartoTabela;

	    @FXML
	    private TableColumn<?, ?> quartoCol;

	    @FXML
	    private TableColumn<?, ?> qtCamasCol;

	    @FXML
	    private TableColumn<?, ?> tipoCol;

	    @FXML
	    private TableColumn<?, ?> tvCaboCol;

	    @FXML
	    private TableColumn<?, ?> cofreCol;

	    @FXML
	    private TableColumn<?, ?> tvLedCol;

	    @FXML
	    private TableColumn<?, ?> telCol;

	    @FXML
	    private TableColumn<?, ?> arCondCol;

	    @FXML
	    private TableColumn<?, ?> wifiCol;

	    @FXML
	    private TableColumn<?, ?> miniBarCol;

	    @FXML
	    private TableColumn<?, ?> dispCol;

	    @FXML
	    private Button editarBtn;

	    @FXML
	    private Tab novoAlugelTab;

	    @FXML
	    private TextField numQuartoField;

	    @FXML
	    private TextField qtdCamaField;

	    @FXML
	    private TextField tipoField;

	    @FXML
	    private CheckBox tvCaboCBox;

	    @FXML
	    private CheckBox cofreCBox;

	    @FXML
	    private CheckBox tvLedCBox;

	    @FXML
	    private CheckBox telefoneCBox;

	    @FXML
	    private CheckBox arCondCBox;

	    @FXML
	    private CheckBox wifiCBox;

	    @FXML
	    private CheckBox miniBarCBox;

	    @FXML
	    private CheckBox disponivelCBox;

	    @FXML
	    private Button cancelarBtn;

	    @FXML
	    private Button cadastBtn;

	    @FXML
	    void action(ActionEvent event) {

	    }
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
