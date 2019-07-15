/**
 * 
 */
package br.com.sistemahoteleiro.app;

import java.io.IOException;

import br.com.sistemahoteleiro.enuns.TipoCargo;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.facade.Facade;
import br.com.sistemahoteleiro.facade.IFacade;
import br.com.sistemahoteleiro.model.SuperUsuario;
import br.com.sistemahoteleiro.model.Usuario;
import br.com.sistemahoteleiro.util.Backup;
import br.com.sistemahoteleiro.view.Message;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author ayrtons
 *
 */
public class App extends Application {
	
	private static Pane login;
	private static Pane home;

	private static Scene sceneLogin;
	private static Scene sceneHome;

	private static Stage stage;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IFacade facade = Facade.getInstance();
		
//		SuperUsuario superUsuario = new SuperUsuario();
//		
//		superUsuario.setCargo(TipoCargo.SUPER_USUARIO);
//		superUsuario.setCpf("111.424.924-60");
//		superUsuario.setLogin("ayrton");
//		superUsuario.setSenha("ayrton");
//		superUsuario.setNome("Ayrton Rogerio");
//		superUsuario.setRg("9.169.254");
//		superUsuario.setStatus(true);
//		
//		try {
//			facade.createOrUpdateSuperUsuario(superUsuario);
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		launch(args);
		
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {

			
			home = FXMLLoader.load(getClass().getClassLoader().
					getResource("br/com/sistemahoteleiro/view/Home.fxml"));
			login = FXMLLoader.load(getClass().getClassLoader().
					getResource("br/com/sistemahoteleiro/view/Login.fxml"));
			
			
		} catch (IOException e) {
			// TODO: handle exception
//			Message.getInstance().viewMessage(AlertType.ERROR, "Erro ao carregar!", "Ocorreu um erro ao tentar carregar os componentes gráficos!", "" + e.getMessage());
		}

		sceneLogin = new Scene(login);
		sceneHome = new Scene(home);
		
		primaryStage.setScene(sceneLogin);
//		primaryStage.setScene(sceneHome);
		primaryStage.centerOnScreen();
		primaryStage.show();
		stage = primaryStage;
		
		
	}

	
	
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		super.stop();
		
		Backup.backup(System.getProperty("user.home")+"/Backup Sistema Hoteleiro");
		System.exit(0);
	}

	public static void changeStage(String nameStage) {
		
		if(nameStage.equals("Home")) {
			stage.setScene(sceneHome);
		}
		
		if(nameStage.equals("Login")) {
			stage.setScene(sceneLogin);
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


	
	
	
}
