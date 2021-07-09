package lsss.appNutri.gui;

import java.io.IOException;
import java.time.LocalDateTime;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.Refeicao;

public class JanelaPrincipal {

	@FXML private TableView<Refeicao> tableViewRefeicoes;
	@FXML private Button btnRemoverRefeicao;
	@FXML private TableColumn<Refeicao, LocalDateTime> refeicoesColDateTime;
	@FXML private TableColumn<Refeicao, Double> refeicoesColValEnergetico;
	@FXML private TableColumn<Refeicao, Double> refeicoesColProteina;
	@FXML private TableColumn<Refeicao, Double> refeicoesColCarboidratos;
	
	@FXML private TableView<Comida> tableViewComidas;
	@FXML private Button btnRemoverComida;
	@FXML private TableColumn<Comida, String> comidasColNome;
	@FXML private TableColumn<Comida, Double> comidasColValEnergetico;
	@FXML private TableColumn<Comida, Double> comidasColProteina;
	@FXML private TableColumn<Comida, Double> comidasColCarboidratos;
	
	/** Refer�ncia � inst�ncia de Main. */
	private Main instanciaDeMain;
	
	/** Construtor.
	 * @param instanciaDeMain Refer�ncia � inst�ncia de Main
	 * @param primaryStage    Stage fornecido no m�todo start
	 */
	public JanelaPrincipal(Stage primaryStage, Main instanciaDeMain) {
		
		this.instanciaDeMain = instanciaDeMain;
		
		try {
			// Obs.: O controller do FXML � a inst�ncia atual.
			var loader = new FXMLLoader(getClass().getResource("JanelaPrincipal.fxml"));
			loader.setController(this);
			Parent root = loader.load();
			primaryStage.setScene(new Scene(root));
		}
		catch (IOException e) { e.printStackTrace(); }
		
		primaryStage.setTitle("LSSS App nutri��o");
		primaryStage.show();
	}
	
	// � Chamado ap�s o JavaFX seta os atributos FXML
	@FXML private void initialize() {
		
		// Configura TableView comidas
		tableViewComidas.setItems(instanciaDeMain.repoComidas.getObservableList());

		comidasColNome.setCellValueFactory(cellDataFeatures ->
				new ReadOnlyStringWrapper(cellDataFeatures.getValue().getNome()));

		comidasColValEnergetico.setCellValueFactory(cellDataFeatures ->
				new ReadOnlyObjectWrapper<Double>(
						cellDataFeatures.getValue().getInfoNutricional().getValEnergetico()));
		
		comidasColProteina.setCellValueFactory(cellDataFeatures ->
				new ReadOnlyObjectWrapper<Double>(
						cellDataFeatures.getValue().getInfoNutricional().getProteina()));
		
		comidasColCarboidratos.setCellValueFactory(cellDataFeatures ->
				new ReadOnlyObjectWrapper<Double>(
						cellDataFeatures.getValue().getInfoNutricional().getCarboidratos()));
		
		
		// Configura TableView refeicoes
		tableViewRefeicoes.setItems(instanciaDeMain.repoRefeicoes.getObservableList());

		refeicoesColDateTime.setCellValueFactory(cellDataFeatures ->
				new ReadOnlyObjectWrapper<LocalDateTime>(cellDataFeatures.getValue().getDateTime()));

		refeicoesColValEnergetico.setCellValueFactory(cellDataFeatures ->
				new ReadOnlyObjectWrapper<Double>(
						cellDataFeatures.getValue().getInfoNutricional().getValEnergetico()));
		
		refeicoesColProteina.setCellValueFactory(cellDataFeatures ->
				new ReadOnlyObjectWrapper<Double>(
						cellDataFeatures.getValue().getInfoNutricional().getProteina()));
		
		refeicoesColCarboidratos.setCellValueFactory(cellDataFeatures ->
				new ReadOnlyObjectWrapper<Double>(
						cellDataFeatures.getValue().getInfoNutricional().getCarboidratos()));
		

		
		// Faz com que os bot�es de remover fiquem ativados se e apenas se houver algum
		// item selecionado.
		tableViewComidas.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) ->
						btnRemoverComida.setDisable(newValue == null));
		
		tableViewRefeicoes.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) ->
						btnRemoverRefeicao.setDisable(newValue == null));
	}
	
	
	/** � chamado quando o bot�o de adicionar comida � clicado. */
	@FXML private void onBtnAddComida(ActionEvent event) {
		
		(new DialogAddEditComida()).showAndWait().ifPresent(comida -> {
			instanciaDeMain.repoComidas.add(comida);
		});
	}
	
	/** � chamado quando o bot�o de adicionar refei��o � clicado. */
	@FXML private void onBtnAddRefeicao(ActionEvent event) {
		
		(new DialogAddEditRefeicao()).showAndWait().ifPresent(refeicao -> {
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
						tableViewComidas.getSelectionModel().getSelectedItem());
				// Desseleciona pq outro item � selecionado automaticamente dps da remo��o:
				tableViewComidas.getSelectionModel().clearSelection();
			}
		});
	}
	
	/** � chamado quando o bot�o de remover refei��o � clicado. */
	@FXML private void onBtnRemoverRefeicao(ActionEvent event) {
		
		var alert = new Alert(AlertType.CONFIRMATION,
				"Tem certeza de que quer remover as refei��es selecionadas? Essa a��o n�o pode ser desfeita.");
		
		alert.showAndWait().ifPresent(response -> {
			if (response == ButtonType.OK) {
				instanciaDeMain.repoRefeicoes.remover(
						tableViewRefeicoes.getSelectionModel().getSelectedItem());
				// Desseleciona pq outro item � selecionado automaticamente dps da remo��o:
				tableViewRefeicoes.getSelectionModel().clearSelection();
			}
		});
	}
}

