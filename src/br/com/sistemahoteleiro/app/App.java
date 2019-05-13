/**
 * 
 */
package br.com.sistemahoteleiro.app;

import java.io.IOException;

import br.com.sistemahoteleiro.facade.Facade;
import br.com.sistemahoteleiro.facade.IFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author ayrtons
 *
 */
public class App extends Application {

	private static Pane login;
	private static Pane home;
	private static Pane quarto;
	private static Pane reserva;

	private static Scene sceneLogin;
	private static Scene sceneHome;

	private static Stage stage;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		IFacade facade = Facade.getInstance();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {

			home = FXMLLoader.load(getClass().getClassLoader().
					getResource("br/com/sistemahoteleiro/view/Home.fxml"));
			
			quarto = FXMLLoader.load(getClass().getClassLoader().
					getResource("br/com/sistemahoteleiro/view/Quarto.fxml"));
			
			reserva = FXMLLoader.load(getClass().getClassLoader().
					getResource("br/com/sistemahoteleiro/view/Reserva.fxml"));
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}

		//sceneLogin = new Scene(login);
		sceneHome = new Scene(home);
		
		//primaryStage.setScene(sceneLogin);
		primaryStage.setScene(sceneHome);
		primaryStage.centerOnScreen();
		primaryStage.show();
		stage = primaryStage;
		
		
	}

	public static void changeStage(String nameStage) {
		
		if(nameStage.equals("Home")) {
			stage.setScene(sceneHome);
		}
		
	}
	
	/**
	 * 
	 * @return the Pane home
	 */
	public static Pane getHome() {
		return home;
	}

	/**
	 * @return the Pane login
	 */
	public static Pane getLogin() {
		return login;
	}

	/**
	 * @return the Pane quarto
	 */
	public static Pane getQuarto() {
		return quarto;
	}

	/**
	 * @return the Pane reserva
	 */
	public static Pane getReserva() {
		return reserva;
	}
	
	
	
}
