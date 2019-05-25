/**
 * 
 */
package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.com.sistemahoteleiro.model.Cliente;
import br.com.sistemahoteleiro.model.Reserva;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author ayrtons
 *
 */
public class ControlerReserva implements Initializable {

	@FXML
	private Tab listaReservaTab;

	@FXML
	private JFXButton pesqReservBtn;

	@FXML
	private JFXTextField pesqReservField;

	@FXML
	private TableView<Reserva> reservTabela;

	@FXML
	private TableColumn<Reserva, LocalDate> dataReservCol;

	@FXML
	private TableColumn<Reserva, LocalTime> horaReservCol;

	@FXML
	private TableColumn<Reserva, Double> valorReservCol;

	@FXML
	private TableColumn<Reserva, Boolean> situacaoReservCol;

	@FXML
	private Tab novaReservaTabela;

	@FXML
	private JFXButton pesqClientBtn;

	@FXML
	private JFXTextField pesqClientField;

	@FXML
	private TableView<Cliente> clienteTabela;

	@FXML
	private TableColumn<Cliente, ?> nomeCol;

	@FXML
	private TableColumn<Cliente, ?> rgCol;

	@FXML
	private TableColumn<Cliente, ?> cpfCol;

	@FXML
	private JFXButton voltarListBtn;

	@FXML
	private JFXButton contCadBtn;

	@FXML
	private Tab listaQuartosTab;

	@FXML
	private JFXButton pesqQuartoBtn;

	@FXML
	private JFXTextField pesqQuartoField;

	@FXML
	private TableView<?> quartoTabela;

	@FXML
	private TableColumn<?, ?> quartoCol;

	@FXML
	private TableColumn<?, ?> qtCamasCol;

	@FXML
	private TableColumn<?, ?> tipoCol;

	@FXML
	private TableColumn<?, ?> disponivelCol;

	@FXML
	private JFXButton novaReservBtn;

	@FXML
	void action(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
