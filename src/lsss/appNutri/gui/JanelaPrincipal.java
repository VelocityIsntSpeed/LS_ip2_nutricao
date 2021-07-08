package lsss.appNutri.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.Refeicao;

public class JanelaPrincipal {

	@FXML private ListView<Refeicao> listViewRefeicoes;
	@FXML private Button btnRemoverRefeicao;
	
	@FXML private ListView<Comida> listViewComidas;
	@FXML private Button btnRemoverComida;
	
	/** Referência à instância de Main. */
	private Main instanciaDeMain;
	
	/** Construtor.
	 * @param instanciaDeMain Referência à instância de Main
	 * @param primaryStage    Stage fornecido no método start
	 */
	public JanelaPrincipal(Stage primaryStage, Main instanciaDeMain) {
		
		this.instanciaDeMain = instanciaDeMain;
		
		try {
			// Obs.: O controller do FXML é a instância atual.
			var loader = new FXMLLoader(getClass().getResource("JanelaPrincipal.fxml"));
			loader.setController(this);
			Parent root = loader.load();
			primaryStage.setScene(new Scene(root));
		}
		catch (IOException e) { e.printStackTrace(); }
		
		primaryStage.setTitle("LSSS App nutrição");
		primaryStage.show();
	}
	
	// É Chamado após o JavaFX seta os atributos FXML
	@FXML private void initialize() {
		// Configura as ListViews pra sempre mostrar os conteúdos do repositorios
		listViewComidas.setItems(instanciaDeMain.repoComidas.getObservableList());
		listViewRefeicoes.setItems(instanciaDeMain.repoRefeicoes.getObservableList());
		
		// Faz com que os botões de remover fiquem ativados se e apenas se houver algum
		// item selecionado na lista.
		listViewComidas.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) ->
						btnRemoverComida.setDisable(newValue == null));
		
		listViewRefeicoes.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) ->
						btnRemoverRefeicao.setDisable(newValue == null));
	}
	
	
	/** É chamado quando o botão de adicionar comida é clicado. */
	@FXML private void onBtnAddComida(ActionEvent event) {
		
		(new DialogAddEditComida()).showAndWait().ifPresent(comida -> {
			instanciaDeMain.repoComidas.add(comida);
		});
	}
	
	/** É chamado quando o botão de adicionar refeição é clicado. */
	@FXML private void onBtnAddRefeicao(ActionEvent event) {
		
		(new DialogAddEditRefeicao()).showAndWait().ifPresent(refeicao -> {
			instanciaDeMain.repoRefeicoes.add(refeicao);
		});
	}
	
	/** É chamado quando o botão de remover comida é clicado. */
	@FXML private void onBtnRemoverComida(ActionEvent event) {
		
		var alert = new Alert(AlertType.CONFIRMATION,
				"Tem certeza de que quer remover as comidas selecionadas? Essa ação não pode ser desfeita.");
		
		alert.showAndWait().ifPresent(response -> {
			if (response == ButtonType.OK) {
				instanciaDeMain.repoComidas.remover(
					listViewComidas.getSelectionModel().getSelectedItem()
				);
				// Desseleciona pq outro item é selecionado automaticamente dps da remoção:
				listViewComidas.getSelectionModel().clearSelection();
			}
		});
	}
	
	/** É chamado quando o botão de remover refeição é clicado. */
	@FXML private void onBtnRemoverRefeicao(ActionEvent event) {
		
		Refeicao refeicaoASerRemovida = listViewRefeicoes.getSelectionModel().getSelectedItem();
		
		instanciaDeMain.repoRefeicoes.remover(refeicaoASerRemovida);

		// Desseleciona pq outro item é selecionado automaticamente dps da remoção:
		listViewRefeicoes.getSelectionModel().clearSelection();
	}
}

