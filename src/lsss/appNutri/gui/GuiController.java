package lsss.appNutri.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.InfoNutricional;
import lsss.appNutri.negocios.Main;
import lsss.appNutri.negocios.Refeicao;

public class GuiController {

	@FXML private TextField txtFieldNome;
	@FXML private TextField txtFieldValEnergetico;
	@FXML private TextField txtFieldProteina;
	@FXML private TextField txtFieldCarboidratos;
	
	@FXML private ListView<Comida> listViewComidas;
	@FXML private Button btnRemoverComida;
	
	@FXML private ListView<Refeicao> listViewRefeicoes;
	@FXML private Button btnRemoverRefeicao;
	
	
	/** Refer�ncia � inst�ncia de Application. */
	private Main instanciaDoApp;
	
	public void setInstanciaDoApp(Main instanciaDoApp) {
		this.instanciaDoApp = instanciaDoApp;
		
		// Configura as ListViews pra sempre mostrar os conte�dos do repositorios
		listViewComidas.setItems(instanciaDoApp.repoComidas.getObservableList());
		listViewRefeicoes.setItems(instanciaDoApp.repoRefeicoes.getObservableList());
		
		// Faz com que os bot�es de remover fiquem desativados se n�o houver nada selecionado na lista
		listViewComidas.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> btnRemoverComida.setDisable(newValue == null));
		listViewRefeicoes.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> btnRemoverRefeicao.setDisable(newValue == null));
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
		
		Comida comidaASerRemovida = listViewComidas.getSelectionModel().getSelectedItem();
		
		instanciaDoApp.repoComidas.remover(comidaASerRemovida);
		
		// Desseleciona para impedir que o usu�rio delete algo acidentalmente
		listViewComidas.getSelectionModel().clearSelection();
	}
}

