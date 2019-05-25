/**
 * 
 */
package br.com.sistemahoteleiro.controler;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import br.com.sistemahoteleiro.exception.BusinessException;
import br.com.sistemahoteleiro.facade.Facade;
import br.com.sistemahoteleiro.model.Quarto;
import br.com.sistemahoteleiro.util.MaskFieldUtil;
import br.com.sistemahoteleiro.view.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author ayrtons
 *
 */
public class ControlerQuarto implements Initializable {

	private Quarto quarto;
	private List<Quarto> quartos = null;
	
	@FXML
	private Tab listaQuartosTab;

	@FXML
	private JFXTextField pesqQuartField;

	@FXML
	private JFXButton pesqQuartBtn;

	@FXML
	private JFXButton novoQuartBtn;

	@FXML
	private TableView<Quarto> quartoTabela;

	@FXML
	private TableColumn<Quarto, Integer> quartoCol;

	@FXML
	private TableColumn<Quarto, Integer> qtCamasCol;

	@FXML
	private TableColumn<Quarto, String> tipoCol;

	@FXML
	private TableColumn<Quarto, Boolean> tvCaboCol;

	@FXML
	private TableColumn<Quarto, Boolean> cofreCol;

	@FXML
	private TableColumn<Quarto, Boolean> tvLedCol;

	@FXML
	private TableColumn<Quarto, Boolean> telCol;

	@FXML
	private TableColumn<Quarto, Boolean> arCondCol;

	@FXML
	private TableColumn<Quarto, Boolean> wifiCol;

	@FXML
	private TableColumn<Quarto, Boolean> miniBarCol;

	@FXML
	private TableColumn<Quarto, Boolean> disponivelCol;

	@FXML
	private JFXButton editarQuartBtn;

	@FXML
	private Tab novoAlugelTab;

	@FXML
	private JFXTextField numQuartCadField;

	@FXML
	private JFXTextField qtdCamaCadField;

	@FXML
	private JFXTextField tipoQuartCadField;

	@FXML
	private JFXCheckBox tvCaboCBox;

	@FXML
	private JFXCheckBox cofreCBox;

	@FXML
	private JFXCheckBox tvLedCBox;

	@FXML
	private JFXCheckBox miniBarCBox;

	@FXML
	private JFXCheckBox telefoneCBox;

	@FXML
	private JFXCheckBox arCondCBox;

	@FXML
	private JFXCheckBox wifiCBox;

	@FXML
	private JFXCheckBox disponivelCBox;

	@FXML
	private JFXCheckBox statusCBox;

	@FXML
	private JFXButton cancelQuartCadBtn;

	@FXML
	private JFXButton cadQuartBtn;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == novoQuartBtn) {

			novoAlugelTab.setDisable(false);
			novoAlugelTab.getTabPane().getSelectionModel().select(novoAlugelTab);

		}

		if (event.getSource() == cancelQuartCadBtn) {
			listaQuartosTab.getTabPane().getSelectionModel().select(listaQuartosTab);
			novoAlugelTab.setDisable(true);
		}
		
		if(event.getSource() == cadQuartBtn) {
			cadastrarQuarto();
			try {
				Facade.getInstance().createOrUpdateQuarto(quarto);
				quartos = Facade.getInstance().searchAllQuarto();
				quartoTabela.getItems().setAll(quartos);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao salvar o quarto", e.getMessage());
			}			
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		MaskFieldUtil.numericField(numQuartCadField);
		MaskFieldUtil.numericField(qtdCamaCadField);

		quartoCol.setCellValueFactory(new PropertyValueFactory<>("numQuarto"));
		qtCamasCol.setCellValueFactory(new PropertyValueFactory<>("qtdCamas"));
		tipoCol.setCellValueFactory(new PropertyValueFactory<>("tipoQuarto"));
		tvCaboCol.setCellValueFactory(new PropertyValueFactory<>("tvACabo"));
		cofreCol.setCellValueFactory(new PropertyValueFactory<>("cofre"));
		tvLedCol.setCellValueFactory(new PropertyValueFactory<>("tvLed"));
		telCol.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		arCondCol.setCellValueFactory(new PropertyValueFactory<>("arCondicionado"));
		wifiCol.setCellValueFactory(new PropertyValueFactory<>("wifi"));
		miniBarCol.setCellValueFactory(new PropertyValueFactory<>("miniBar"));
		disponivelCol.setCellValueFactory(new PropertyValueFactory<>("disponivel"));

		try {
			quartos = Facade.getInstance().searchAllQuarto();
			quartoTabela.getItems().setAll(quartos);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message.getInstance().viewMessage(AlertType.ERROR, "Erro", "Erro ao buscar registros dos quartos"
					, e.getMessage());
		}
		
	}

	public void cadastrarQuarto() {

		quarto = new Quarto();

		quarto.setNumQuarto(Integer.parseInt(numQuartCadField.getText()));
		quarto.setQtdCamas(Integer.parseInt(qtdCamaCadField.getText()));

		quarto.setTipoQuarto(tipoQuartCadField.getText());

		quarto.setArCondicionado(arCondCBox.isSelected());
		quarto.setCofre(cofreCBox.isSelected());
		quarto.setDisponivel(disponivelCBox.isSelected());
		quarto.setMiniBar(miniBarCBox.isSelected());
		quarto.setTelefone(telefoneCBox.isSelected());
		quarto.setTvACabo(tvCaboCBox.isSelected());
		quarto.setTvLed(tvLedCBox.isSelected());
		quarto.setWifi(wifiCBox.isSelected());

		quarto.setStatus(statusCBox.isSelected());

	}

	public void atualizarQuarto() {
		
		Quarto q = quartoTabela.getSelectionModel().getSelectedItem();
		
		numQuartCadField.setText(""+q.getNumQuarto());
		qtdCamaCadField.setText(""+q.getQtdCamas());

		tipoQuartCadField.setText(q.getTipoQuarto());

		arCondCBox.setSelected(q.isArCondicionado());
		cofreCBox.setSelected(q.isCofre());
		disponivelCBox.setSelected(q.isDisponivel());
		miniBarCBox.setSelected(q.isMiniBar());
		telefoneCBox.setSelected(q.isTelefone());
		tvCaboCBox.setSelected(q.isTvACabo());
		tvLedCBox.setSelected(q.isTvLed());
		wifiCBox.setSelected(q.isWifi());

		statusCBox.setSelected(q.isStatus());

		
	}
	
}
