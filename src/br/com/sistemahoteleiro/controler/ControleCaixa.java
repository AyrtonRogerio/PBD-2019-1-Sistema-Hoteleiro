package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;


/**
 * 
 * @author ayrton
 *
 */
public class ControleCaixa implements Initializable{

    @FXML
    private Tab caixaTab;

    @FXML
    private JFXButton relatorioBtn;

    @FXML
    private JFXDatePicker deDataP;

    @FXML
    private JFXDatePicker ateDataP;

    @FXML
    private JFXTextField entradaField;

    @FXML
    private JFXTextField saidaField;

    @FXML
    private JFXTextField saldoField;

    @FXML
    void action(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

