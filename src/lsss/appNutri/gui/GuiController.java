package lsss.appNutri.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.InfoNutricional;
import lsss.appNutri.negocios.Main;

public class GuiController {

	@FXML private TextField txtFieldNome;
	@FXML private TextField txtFieldValEnergetico;
	@FXML private TextField txtFieldProteina;
	@FXML private TextField txtFieldCarboidratos;
	
	@FXML private ListView<Comida> listViewComidas;
	@FXML private Button btnRemoverComida;
	
	
	/** Referência à instância de Application. */
	private Main instanciaDoApp;
	
	public void setInstanciaDoApp(Main instanciaDoApp) {
		this.instanciaDoApp = instanciaDoApp;
		
		// Configura a ListView pra sempre mostrar o conteúdo do RepositorioComidas
		listViewComidas.setItems(instanciaDoApp.repoComidas.getObservableList());
		
		// Faz com que o botão de remover comida fique desativado se não houver comida selecionada
		listViewComidas.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> btnRemoverComida.setDisable(newValue == null));
	}
	
	/** É chamado quando o botão de adicionar comida é clicado. TODO Quire #23 #24 */
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
	
	/** É chamado quando o botão de remover comida é clicado. */
	@FXML private void onBtnRemoverComida(ActionEvent event) {
		
		Comida comidaASerRemovida = listViewComidas.getSelectionModel().getSelectedItem();
		
		instanciaDoApp.repoComidas.remover(comidaASerRemovida);
		
		// Desseleciona para impedir que o usuário delete algo acidentalmente
		listViewComidas.getSelectionModel().clearSelection();
	}
}

