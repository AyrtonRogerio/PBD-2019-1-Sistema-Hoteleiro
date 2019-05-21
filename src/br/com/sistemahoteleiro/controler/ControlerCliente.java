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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @author ayrton
 *
 */
public class ControlerCliente implements Initializable{

	@FXML
    private Tab listaClienteTab;

    @FXML
    private TextField buscaCliField;

    @FXML
    private Button buscaCliBtn;

    @FXML
    private Button novoCliBtn;

    @FXML
    private TableView<?> cliTabela;

    @FXML
    private TableColumn<?, ?> nomeCliCol;

    @FXML
    private TableColumn<?, ?> cpfCliCol;

    @FXML
    private TableColumn<?, ?> nascCliCol;

    @FXML
    private TableColumn<?, ?> ruaCliCol;

    @FXML
    private TableColumn<?, ?> bairroCliCol;

    @FXML
    private TableColumn<?, ?> numCliCol;

    @FXML
    private Button detalhesCliBtn;

    @FXML
    private Button editarCliBtn;

    @FXML
    private Tab dadosCliTab;

    @FXML
    private TextField nomeCliField;

    @FXML
    private TextField cpfCliField;

    @FXML
    private ComboBox<?> sexoCliCbox;

    @FXML
    private ComboBox<?> estadCivCliCbox;

    @FXML
    private ComboBox<?> ocupacaoCliCbox;

    @FXML
    private DatePicker dataCli;

    @FXML
    private Button voltarCliBtn;

    @FXML
    private Button continuarCliBtn;

    @FXML
    private Tab endClienteTab;

    @FXML
    private TextField ruaEndCliField;

    @FXML
    private TextField cepEndCliField;

    @FXML
    private TextField numEndCliField;

    @FXML
    private TextField bairroEndCliField;

    @FXML
    private TextField cidadeEndCliField;

    @FXML
    private TextField ufEndCliField;

    @FXML
    private Button voltarEndCliBtn;

    @FXML
    private Button continEndCliBtn;

    @FXML
    private Tab contClienteTab;

    @FXML
    private TextField foneContCliField;

    @FXML
    private TextField emailContCliField;

    @FXML
    private TextField foneContCliField2;

    @FXML
    private Button voltarContCliBtn;

    @FXML
    private Button cadastCliBtn;

    @FXML
    void action(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
