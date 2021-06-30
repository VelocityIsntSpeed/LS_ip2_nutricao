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
	
	
	/** Referência à instância de Application. */
	private Main instanciaDoApp;
	
	public void setInstanciaDoApp(Main instanciaDoApp) {
		this.instanciaDoApp = instanciaDoApp;
		
		// Configura as ListViews pra sempre mostrar os conteúdos do repositorios
		listViewComidas.setItems(instanciaDoApp.repoComidas.getObservableList());
		listViewRefeicoes.setItems(instanciaDoApp.repoRefeicoes.getObservableList());
		
		// Faz com que os botões de remover fiquem desativados se não houver nada selecionado na lista
		listViewComidas.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> btnRemoverComida.setDisable(newValue == null));
		listViewRefeicoes.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> btnRemoverRefeicao.setDisable(newValue == null));
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

