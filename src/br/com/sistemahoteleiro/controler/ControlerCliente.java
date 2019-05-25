/**
 * 
 */
package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.com.sistemahoteleiro.model.Cliente;
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
import javafx.scene.layout.GridPane;

/**
 * @author ayrton
 *
 */
public class ControlerCliente implements Initializable{

	 @FXML
	    private Tab listaClienteTab;

	    @FXML
	    private TableView<Cliente> cliTabela;

	    @FXML
	    private TableColumn<Cliente, String> nomeCliCol;

	    @FXML
	    private TableColumn<Cliente, String> cpfCliCol;

	    @FXML
	    private TableColumn<Cliente, String> cnpjCliCol;

	    @FXML
	    private TableColumn<Cliente, String> ruaCliCol;

	    @FXML
	    private TableColumn<Cliente, String> bairroCliCol;

	    @FXML
	    private TableColumn<Cliente, String> numCliCol;

	    @FXML
	    private JFXButton detalhesCliBtn;

	    @FXML
	    private JFXButton editarCliBtn;

	    @FXML
	    private Tab dadosCliTab;

	    @FXML
	    private JFXButton voltarCliBtn;

	    @FXML
	    private JFXButton contCliBtn;

	    @FXML
	    private GridPane CliJuriGridLay;

	    @FXML
	    private JFXTextField razaoSociCliField;

	    @FXML
	    private JFXTextField cnpjCliField;

	    @FXML
	    private JFXTextField nomeCliField;

	    @FXML
	    private GridPane CliFisGridLay;

	    @FXML
	    private JFXTextField cpfCliField;

	    @FXML
	    private JFXDatePicker dataCli;

	    @FXML
	    private JFXComboBox<?> sexoCliCbox;

	    @FXML
	    private JFXComboBox<?> estadCivCliCbox;

	    @FXML
	    private JFXComboBox<?> ocupacaoCliCbox;

	    @FXML
	    private Tab endClienteTab;

	    @FXML
	    private JFXButton voltarEndCliBtn;

	    @FXML
	    private JFXButton continEndCliBtn;

	    @FXML
	    private JFXTextField ruaEndCliField;

	    @FXML
	    private JFXTextField cepEndCliField;

	    @FXML
	    private JFXTextField numEndCliField;

	    @FXML
	    private JFXTextField bairroEndCliField;

	    @FXML
	    private JFXTextField cidadeEndCliField;

	    @FXML
	    private JFXTextField ufEndCliField;

	    @FXML
	    private Tab contClienteTab;

	    @FXML
	    private JFXTextField foneContCliField;

	    @FXML
	    private JFXTextField foneContCliField2;

	    @FXML
	    private JFXTextField emailContCliField;

	    @FXML
	    private JFXButton voltarContCliBtn;

	    @FXML
	    private JFXButton cadastCliBtn;

	    @FXML
	    void action(ActionEvent event) {

	    	
	    	
	    	
	    	
	    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
