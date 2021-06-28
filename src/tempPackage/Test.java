package tempPackage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {
	
	public RepositorioComidas repoComidas = new RepositorioComidas();
	
	public static void main(String[] args) {
		Application.launch(); // O JavaFX chama o m�todo start
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		// Inicializa��o dos dados (tempor�rio, s� para testes)
		InfoNutricional infoNutZero = new InfoNutricional(0, 0, 0);
		System.out.println(infoNutZero);
		
		Comida arroz = new Comida("Arroz", infoNutZero);
		System.out.println(arroz);
		
		System.out.println(repoComidas);
		repoComidas.add(arroz);
		System.out.println(repoComidas);
		
		
		inicializarGUI(primaryStage);
	}
	
	private void inicializarGUI(Stage primaryStage) throws IOException {
		
		primaryStage.setTitle("LSSS App nutri��o");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("TelaComidas.fxml"));
		VBox root = (VBox) loader.load();
		
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
		// Fornece ao controller uma refer�ncia a esse objeto
		TelaComidasController controller = loader.getController();
		controller.setInstanciaDoApp(this);
	}
}
