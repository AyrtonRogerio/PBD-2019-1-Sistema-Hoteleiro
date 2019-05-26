/**
 * 
 */
package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import br.com.sistemahoteleiro.enuns.TipoCargo;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.facade.Facade;
import br.com.sistemahoteleiro.model.SuperUsuario;
import br.com.sistemahoteleiro.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author ayrton
 *
 */
public class ControlerResetarSenha implements Initializable{

	private static final String SENHA = "admin123";
	private Usuario user;
	private List<Usuario> usuarios;
	private SuperUsuario superUser;
	
	@FXML
    private JFXPasswordField senhaSuperUsuPassField;

    @FXML
    private JFXTextField buscarUsuarioField;

    @FXML
    private JFXTextField loginSuperUsuField;

    @FXML
    private JFXButton buscarUsuarioBtn;

    @FXML
    private JFXButton autenticarSuperUsuBtn;

    @FXML
    private TableView<Usuario> usuarioTabela;

    @FXML
    private TableColumn<Usuario, String> nomeCol;

    @FXML
    private TableColumn<Usuario, String> cpfCol;

    @FXML
    private TableColumn<Usuario, String> loginCol;

    @FXML
    private TableColumn<Usuario, TipoCargo> cargoCol;

    @FXML
    private TableColumn<Usuario, Boolean> situacaoCol;

    @FXML
    private JFXButton resetarSenhaBtn;

    @FXML
    void action(ActionEvent event) {

    	if(event.getSource() == autenticarSuperUsuBtn) {
    		autenticarSuperUsuario();
    		
    	}
    	
    	if(event.getSource() == buscarUsuarioBtn) {
    		buscarUsuario();
    		
    	}
    	
    	if(event.getSource() == resetarSenhaBtn) {
    		
    		user = usuarioTabela.getSelectionModel().getSelectedItem();
    		
    		user.setSenha(SENHA);
    		
    		try {
				Facade.getInstance().createOrUpdateUsuario(user);
				
				buscarUsuarioField.setDisable(true);
				buscarUsuarioBtn.setDisable(true);
				usuarioTabela.setDisable(true);
				resetarSenhaBtn.setDisable(true);
				
				usuarioTabela.getItems().clear();
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		loginCol.setCellValueFactory(new PropertyValueFactory<>("login"));
		cargoCol.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		situacaoCol.setCellValueFactory(new PropertyValueFactory<>("status"));

		situacaoCol.setCellFactory(coluna -> {

			return new TableCell<Usuario, Boolean>() {

				protected void updateItem(Boolean item, boolean empty) {

					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						if (item) {
							setText("Vinculado");
						} else {
							setText("Desvinculado");
						}
					}
				}
			};
		});

	}

	
	
	
	public void autenticarSuperUsuario() {
		
		try {
			user =  Facade.getInstance().searchLoginUsuario(loginSuperUsuField.getText().trim(),
					senhaSuperUsuPassField.getText().trim());
			if(user instanceof SuperUsuario) {
//				System.out.println("superuser");
				
				buscarUsuarioField.setDisable(false);
				buscarUsuarioBtn.setDisable(false);
				usuarioTabela.setDisable(false);
				resetarSenhaBtn.setDisable(false);
				
				loginSuperUsuField.clear();
				senhaSuperUsuPassField.clear();
				
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void buscarUsuario() {
				
		try {
			usuarios = Facade.getInstance().seearchBuscarTodosUsuario(buscarUsuarioField.getText().trim());
			usuarioTabela.getItems().setAll(usuarios);
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
