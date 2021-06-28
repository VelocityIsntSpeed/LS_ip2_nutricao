package tempPackage;

import java.io.IOException;
import java.time.LocalDateTime;

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
		System.out.println(repoComidas);
		
		InfoNutricional infoNutZero = new InfoNutricional(0, 0, 0);
		System.out.println(infoNutZero);
		
		Comida arroz = new Comida("Arroz", infoNutZero);
		System.out.println(arroz);
		
		Comida pastaDeAmendoim = new Comida("Pasta de Amendoim", infoNutZero);
		
		repoComidas.add(arroz);
		repoComidas.add(pastaDeAmendoim);
		repoComidas.add(arroz); // duplicado
		System.out.println(repoComidas);
		
		Refeicao refeicao = new Refeicao(new Comida[]{arroz, pastaDeAmendoim}, LocalDateTime.now());
		System.out.println(refeicao);
		
		
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
