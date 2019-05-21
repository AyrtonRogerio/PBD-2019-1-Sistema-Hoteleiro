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

/**
 * @author ayrtons
 * Sample Skeleton for 'Home.fxml' Controller Class
 */
public class ControlerHome implements Initializable{

	

    @FXML // fx:id="homeButton"
    private Button homeButton; // Value injected by FXMLLoader

    @FXML // fx:id="quartosButton"
    private Button quartosButton; // Value injected by FXMLLoader

    @FXML // fx:id="reservaButton"
    private Button reservaButton; // Value injected by FXMLLoader

    @FXML // fx:id="checkinButton"
    private Button checkinButton; // Value injected by FXMLLoader

    @FXML // fx:id="checkouButton"
    private Button checkouButton; // Value injected by FXMLLoader

    @FXML // fx:id="pagamentoButton"
    private Button pagamentoButton; // Value injected by FXMLLoader

    @FXML // fx:id="logoutButton"
    private Button logoutButton; // Value injected by FXMLLoader

    @FXML
    void action(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void atualizarFrame(String nameFrame) {
		
	}
	
}
