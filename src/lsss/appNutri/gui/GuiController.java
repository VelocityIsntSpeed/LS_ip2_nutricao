package lsss.appNutri.gui;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.InfoNutricional;
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
	
	
	/** Refer�ncia � inst�ncia de Main. */
	private Main instanciaDeMain;
	
	public void setInstanciaDeMain(Main instanciaDoApp) {
		this.instanciaDeMain = instanciaDoApp;
		
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
		
		instanciaDeMain.repoComidas.add(comida);
		
		// Limpa os campos
		txtFieldNome.clear();
		txtFieldValEnergetico.clear();
		txtFieldProteina.clear();
		txtFieldCarboidratos.clear();
	}
	
	/** � chamado quando o bot�o de adicionar refei��o � clicado. */
	@FXML private void onBtnAddRefeicao(ActionEvent event) {
		System.out.println("Bot�o de add refei��o foi acionado.");
		
		var dialog = new Dialog<Refeicao>();
		
		// A raiz do FXML � um DialogPane
		var loader = new FXMLLoader(getClass().getResource("AddEditRefeicao.fxml"));
		try {
			dialog.setDialogPane(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		// O result converter deve retornar a nova comida, ou nulo se o buttonType for de cancelamento.
		// TODO: De onde o resultConverter vai pegar o input do usuario pra gerar a refeicao corretamente?
		dialog.setResultConverter(buttonType -> (buttonType == ButtonType.OK) ?
				new Refeicao(new Comida[]{}, LocalDateTime.now()) : null);
		
		
		dialog.showAndWait().ifPresent(refeicao -> {
			instanciaDeMain.repoRefeicoes.add(refeicao);
		});
	}
	
	/** � chamado quando o bot�o de remover comida � clicado. */
	@FXML private void onBtnRemoverComida(ActionEvent event) {
		
		var alert = new Alert(AlertType.CONFIRMATION,
				"Tem certeza de que quer remover as comidas selecionadas? Essa a��o n�o pode ser desfeita.");
		
		alert.showAndWait().ifPresent(response -> {
			if (response == ButtonType.OK) {
				instanciaDeMain.repoComidas.remover(
					listViewComidas.getSelectionModel().getSelectedItem()
				);
				// Desseleciona pq outro item � selecionado automaticamente dps da remo��o:
				listViewComidas.getSelectionModel().clearSelection();
			}
		});
	}
	
	/** � chamado quando o bot�o de remover refei��o � clicado. */
	@FXML private void onBtnRemoverRefeicao(ActionEvent event) {
		
		Refeicao refeicaoASerRemovida = listViewRefeicoes.getSelectionModel().getSelectedItem();
		
		instanciaDeMain.repoRefeicoes.remover(refeicaoASerRemovida);

		// Desseleciona pq outro item � selecionado automaticamente dps da remo��o:
		listViewRefeicoes.getSelectionModel().clearSelection();
	}
}

