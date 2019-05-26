/**
 * 
 */
package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * @author ayrton
 *
 */
public class ControlerLogin implements Initializable{

	
    @FXML
    private JFXTextField loginField;

    @FXML
    private JFXPasswordField senhaField;

    @FXML
    private JFXButton entrarBtn;

    @FXML
    private JFXButton sairBtn;

    @FXML
    void action(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
