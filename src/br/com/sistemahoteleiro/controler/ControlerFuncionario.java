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
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
/**
 * @author ayrton
 *
 */
public class ControlerFuncionario implements Initializable {

	 @FXML
	    private Tab listFuncTab;

	    @FXML
	    private TextField buscaField;

	    @FXML
	    private Button buscaFuncBtn;

	    @FXML
	    private Button editarFuncBtn;

	    @FXML
	    private Button novoFuncBtn;

	    @FXML
	    private TableView<?> funcListTabela;

	    @FXML
	    private TableColumn<?, ?> nomeCol;

	    @FXML
	    private TableColumn<?, ?> cpfCol;

	    @FXML
	    private TableColumn<?, ?> cargoCol;

	    @FXML
	    private TableColumn<?, ?> ruaCol;

	    @FXML
	    private TableColumn<?, ?> bairroCol;

	    @FXML
	    private TableColumn<?, ?> situacaoCol;

	    @FXML
	    private Tab funcTab;

	    @FXML
	    private Button voltarFuncBtn;

	    @FXML
	    private Button contFuncBtn;

	    @FXML
	    private TextField nomeField;

	    @FXML
	    private TextField cpfField;

	    @FXML
	    private TextField cargoField;

	    @FXML
	    private TextField loginField;

	    @FXML
	    private PasswordField senhaField;

	    @FXML
	    private PasswordField confSenhaField;

	    @FXML
	    private CheckBox situacaoCbox;

	    @FXML
	    void action(ActionEvent event) {

	    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
