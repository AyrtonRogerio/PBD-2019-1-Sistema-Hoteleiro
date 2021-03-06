/**
 * 
 */
package br.com.sistemahoteleiro.controler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.sistemahoteleiro.app.App;
import br.com.sistemahoteleiro.view.Message;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * @author ayrtons Sample Skeleton for 'Home.fxml' Controller Class
 */
public class ControlerHome implements Initializable {

	private Pane clientePane;
	private Pane funcionarioPane;
	private Pane quartoPane;
	private Pane reservaPane;
	private Pane configurarPane;
	private Pane alugaPane;
	private Pane caixaPane;

	@FXML
	private MenuItem inicioMenuItem;

	@FXML
	private MenuItem quartosMenuItem;

	@FXML
	private MenuItem clientesMenuItem;

	@FXML
	private MenuItem reservasMenuItem;

	@FXML
	private MenuItem checkInMenuItem;

	@FXML
	private MenuItem checkOutMenuItem;

	@FXML
	private MenuItem pgmntMenuItem;

	@FXML
	private MenuItem funcMenuItem;

	@FXML
	private MenuItem configMenuItem;

	@FXML
	private MenuItem logoutMenuItem;

	@FXML
	private MenuItem sairMenuItem;

	@FXML
	private MenuItem caixaMenuItem;

	@FXML
	private MenuItem alugarMenuItem;

	@FXML
	private AnchorPane pane;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == sairMenuItem) {
			System.exit(0);
		}

		if (event.getSource() == logoutMenuItem) {

			App.changeStage("Login");

		}

		if (event.getSource() == reservasMenuItem) {
			updateFrame("reserva");
		}

		if (event.getSource() == clientesMenuItem) {
			updateFrame("cliente");
		}

		if (event.getSource() == quartosMenuItem) {
			updateFrame("quarto");
		}

		if (event.getSource() == funcMenuItem) {
			updateFrame("funcionario");
		}

		if (event.getSource() == configMenuItem) {
			updateFrame("configurar");
		}
		
		if(event.getSource() == alugarMenuItem) {
			updateFrame("alugar");
		}

		if(event.getSource() == caixaMenuItem) {
			updateFrame("caixa");
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

			configurarPane = FXMLLoader
					.load(getClass().getClassLoader().getResource("br/com/sistemahoteleiro/view/ResetarSenha.fxml"));

			alugaPane = FXMLLoader
					.load(getClass().getClassLoader().getResource("br/com/sistemahoteleiro/view/Aluga.fxml"));
			
			caixaPane = FXMLLoader
					.load(getClass().getClassLoader().getResource("br/com/sistemahoteleiro/view/Caixa.fxml"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message.getInstance().viewMessage(AlertType.ERROR, "Erro ao carregar!",
					"Ocorreu um erro ao tentar carregar os componentes gráficos!", "" + e.getMessage());
		}
	}

	
	/**
	 * Método que recebe uma string referente a tela para ser exibida
	 * @param nameFrame
	 */
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

		if (nameFrame.equalsIgnoreCase("configurar")) {

			AnchorPane.setBottomAnchor(configurarPane, 0.0);
			AnchorPane.setLeftAnchor(configurarPane, 0.0);
			AnchorPane.setRightAnchor(configurarPane, 0.0);
			AnchorPane.setTopAnchor(configurarPane, 0.0);
			pane.getChildren().setAll(configurarPane);
		}

		if (nameFrame.equalsIgnoreCase("alugar")) {

			AnchorPane.setBottomAnchor(alugaPane, 0.0);
			AnchorPane.setLeftAnchor(alugaPane, 0.0);
			AnchorPane.setRightAnchor(alugaPane, 0.0);
			AnchorPane.setTopAnchor(alugaPane, 0.0);
			pane.getChildren().setAll(alugaPane);
		}

		if (nameFrame.equalsIgnoreCase("caixa")) {

			AnchorPane.setBottomAnchor(caixaPane, 0.0);
			AnchorPane.setLeftAnchor(caixaPane, 0.0);
			AnchorPane.setRightAnchor(caixaPane, 0.0);
			AnchorPane.setTopAnchor(caixaPane, 0.0);
			pane.getChildren().setAll(caixaPane);
		}
		
	}

}
