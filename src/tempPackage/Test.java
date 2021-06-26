package tempPackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {

	@FXML private TextField txtFieldNome;
	@FXML private TextField txtFieldValEnergetico;
	@FXML private TextField txtFieldProteina;
	@FXML private TextField txtFieldCarboidratos;
	
	private RepositorioComidas repoComidas = new RepositorioComidas();
	
	public static void main(String[] args) {
		InfoNutricional infoNut = new InfoNutricional(0, 0, 0);
		System.out.println(infoNut);
		
		Comida c1 = new Comida("Arroz", infoNut);
		System.out.println(c1);
		
		
		
		
		Application.launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("LSSS App nutrição");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("TelaComidas.fxml"));
		VBox root = (VBox) loader.load();
		
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	@FXML
	private void btnAddComida(ActionEvent event) {
		
	}
}
