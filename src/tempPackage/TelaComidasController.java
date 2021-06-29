package tempPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TelaComidasController {

	@FXML private TextField txtFieldNome;
	@FXML private TextField txtFieldValEnergetico;
	@FXML private TextField txtFieldProteina;
	@FXML private TextField txtFieldCarboidratos;
	
	@FXML private ListView<Comida> listViewComidas;
	@FXML private Button btnRemoverComida;
	
	
	/** Refer�ncia � inst�ncia de Application. */
	private Test instanciaDoApp;
	
	public void setInstanciaDoApp(Test instanciaDoApp) {
		this.instanciaDoApp = instanciaDoApp;
		
		// Configura a ListView pra sempre mostrar o conte�do do RepositorioComidas
		listViewComidas.setItems(instanciaDoApp.repoComidas.getObservableList());
	}
	
	/** � chamado quando o bot�o de adicionar comida � clicado. TODO Quire #23 #24 */
	@FXML private void onBtnAddComida(ActionEvent event) {
		
		InfoNutricional infoNut = new InfoNutricional(Double.parseDouble(txtFieldValEnergetico.getText()),
				                                      Double.parseDouble(txtFieldProteina.getText()),
				                                      Double.parseDouble(txtFieldCarboidratos.getText()));
		Comida comida = new Comida(txtFieldNome.getText(), infoNut);
		
		instanciaDoApp.repoComidas.add(comida);
		
		// Limpa os campos
		txtFieldNome.clear();
		txtFieldValEnergetico.clear();
		txtFieldProteina.clear();
		txtFieldCarboidratos.clear();
	}
	
	/** � chamado quando o bot�o de remover comida � clicado. */
	@FXML private void onBtnRemoverComida(ActionEvent event) {
		System.out.println("Bot�o de remover comida foi clicado."); // TODO: tirar isso
		
		Comida comidaASerRemovida = listViewComidas.getSelectionModel().getSelectedItem();
		
		instanciaDoApp.repoComidas.remover(comidaASerRemovida);
		
		// Desseleciona para impedir que o usu�rio delete algo acidentalmente
		listViewComidas.getSelectionModel().clearSelection();
	}
}

