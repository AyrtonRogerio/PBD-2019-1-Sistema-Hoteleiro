/**
 * 
 */
package br.com.sistemahoteleiro.controler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.sistemahoteleiro.view.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * @author ayrtons Sample Skeleton for 'Home.fxml' Controller Class
 */
public class ControlerHome implements Initializable {

	private Pane clientePane, funcionarioPane, quartoPane, reservaPane;

	@FXML
	private AnchorPane pane;

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

		if(event.getSource() == quartosButton) {
			updateFrame("quarto");
		}
		
		if(event.getSource() == reservaButton) {
			updateFrame("reservar");
		}
		
		if(event.getSource() == quartosButton) {
			updateFrame("quarto");
		}
		
		if(event.getSource() == quartosButton) {
			updateFrame("quarto");
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {

			clientePane = FXMLLoader
					.load(getClass().getClassLoader().getResource("br/com/sistemahoteleiro/view/Cliente.fxml"));

			funcionarioPane = FXMLLoader
					.load(getClass().getClassLoader().getResource("br/com/sistemahoteleiro/view/Funcionario.fxml"));

			quartoPane = FXMLLoader
					.load(getClass().getClassLoader().getResource("br/com/sistemahoteleiro/view/Quarto.fxml"));

			reservaPane = FXMLLoader
					.load(getClass().getClassLoader().getResource("br/com/sistemahoteleiro/view/Reserva.fxml"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message.getInstance().viewMessage(AlertType.ERROR, "Erro ao carregar!", "Ocorreu um erro ao tentar carregar os componentes gráficos!", "" + e.getMessage());
		}
	}

	public void updateFrame(String nameFrame) {

		if (nameFrame.equalsIgnoreCase("cliente")) {

			AnchorPane.setBottomAnchor(clientePane, 0.0);
			AnchorPane.setLeftAnchor(clientePane, 0.0);
			AnchorPane.setRightAnchor(clientePane, 0.0);
			AnchorPane.setTopAnchor(clientePane, 0.0);
			pane.getChildren().setAll(clientePane);
		}

		if (nameFrame.equalsIgnoreCase("funcionario")) {

			AnchorPane.setBottomAnchor(funcionarioPane, 0.0);
			AnchorPane.setLeftAnchor(funcionarioPane, 0.0);
			AnchorPane.setRightAnchor(funcionarioPane, 0.0);
			AnchorPane.setTopAnchor(funcionarioPane, 0.0);
			pane.getChildren().setAll(funcionarioPane);
		}

		if (nameFrame.equalsIgnoreCase("quarto")) {

			AnchorPane.setBottomAnchor(quartoPane, 0.0);
			AnchorPane.setLeftAnchor(quartoPane, 0.0);
			AnchorPane.setRightAnchor(quartoPane, 0.0);
			AnchorPane.setTopAnchor(quartoPane, 0.0);
			pane.getChildren().setAll(quartoPane);
		}

		if (nameFrame.equalsIgnoreCase("reserva")) {

			AnchorPane.setBottomAnchor(reservaPane, 0.0);
			AnchorPane.setLeftAnchor(reservaPane, 0.0);
			AnchorPane.setRightAnchor(reservaPane, 0.0);
			AnchorPane.setTopAnchor(reservaPane, 0.0);
			pane.getChildren().setAll(reservaPane);
		}
	}

}
