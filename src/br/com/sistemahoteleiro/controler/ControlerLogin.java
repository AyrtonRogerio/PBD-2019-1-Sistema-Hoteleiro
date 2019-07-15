/**
 * 
 */
package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.com.sistemahoteleiro.app.App;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.facade.Facade;
import br.com.sistemahoteleiro.model.Caixa;
import br.com.sistemahoteleiro.model.Usuario;
import br.com.sistemahoteleiro.util.Cryptography;
import br.com.sistemahoteleiro.view.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;

/**
 * @author ayrton
 *
 */
public class ControlerLogin implements Initializable {

	private String pass;

	private static Caixa caixa;

	@FXML
	private JFXTextField loginField;

	@FXML
	private JFXPasswordField senhaField;

	@FXML
	private JFXButton entrarBtn;

	@FXML
	private JFXButton sairBtn;

	private static Usuario usuario;

	private Facade facade = Facade.getInstance();

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == entrarBtn) {
			if (efetuarLogin()) {
//    			App.changeStage("Home");
			}
		}

		if (event.getSource() == sairBtn) {
			System.exit(0);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public boolean efetuarLogin() {

		try {
//			senhaField.setText(Cryptography.cryptography(senhaField.getText().getBytes()));
			usuario = facade.searchLoginUsuario(loginField.getText(), senhaField.getText());

			if (usuario == null) {
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro ao Logar", "O usuário não EXISTE!",
						"Usuário inexiste");
				return false;
			}
			App.changeStage("Home");
			Message.getInstance().viewMessage(AlertType.INFORMATION, "Logado", "Login efetuado", "Logado com sucesso!");
			loginField.clear();
			senhaField.clear();
			abrirCaixa();
			return true;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}

	}

	public void abrirCaixa() {

		try {
			LocalDate localDate = LocalDate.now();
			caixa = Facade.getInstance().buscarCaixaPorData(localDate);
			System.out.println("passou da primeira busca");
			if (caixa == null) {
				System.out.println("Novo caixa");

				Caixa c = Facade.getInstance().buscarCaixaPorAnterior();
				caixa = new Caixa();

				if (c != null) {

					
					caixa.setEntrada(c.getSaldo());
					caixa.setSaida(0.00);
					caixa.setSaldo(caixa.getEntrada() - caixa.getSaida());
					caixa.setDataAbertura(localDate);
					caixa.setDataFechamento(localDate);

				}
				else {
					caixa.setEntrada(500.00);
					caixa.setSaida(0.00);
					caixa.setSaldo(caixa.getEntrada() - caixa.getSaida());
					caixa.setDataAbertura(localDate);
					caixa.setDataFechamento(localDate);
				}

				
				Facade.getInstance().createOrUpdateCaixa(caixa);
			}

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static Caixa getCaixa() { 
		
		return caixa;
		
	}

	public static Usuario getUsuario() {
		
		return usuario;
		
	}
	
}
