package lsss.appNutri.negocios;

import java.io.IOException;
import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lsss.appNutri.gui.GuiController;

public class Main extends Application {
	
	public RepositorioComidas repoComidas = new RepositorioComidas();
	public RepositorioRefeicoes repoRefeicoes = new RepositorioRefeicoes();
	
	public static void main(String[] args) {
		Application.launch(); // O JavaFX chama o método start
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		// Inicialização dos dados (temporário, só para testes)
		System.out.println(repoComidas);
		System.out.println(repoRefeicoes);
		
		InfoNutricional infoNutZero = new InfoNutricional(0, 0, 0);
		
		Comida arroz = new Comida("Arroz", infoNutZero);
		Comida pastaDeAmendoim = new Comida("Pasta de Amendoim", infoNutZero);
		Comida sucoDeLaranja = new Comida("Suco de Laranja", infoNutZero);
		
		repoComidas.add(arroz);
		repoComidas.add(pastaDeAmendoim);
		repoComidas.add(arroz); // duplicado
		System.out.println(repoComidas);
		
		Refeicao r1 = new Refeicao(new Comida[]{arroz, pastaDeAmendoim}, LocalDateTime.now());
		System.out.println(r1);
		Refeicao r2 = new Refeicao(new Comida[]{arroz, pastaDeAmendoim, sucoDeLaranja}, LocalDateTime.now());
		
		repoRefeicoes.add(r1);
		repoRefeicoes.add(r2);
		System.out.println(repoRefeicoes);
		
		
		inicializarGUI(primaryStage);
	}
	
	private void inicializarGUI(Stage primaryStage) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/GUI.fxml"));
		Parent root = loader.load();
		
		// Fornece ao controller uma referência ao objeto atual
		GuiController controller = loader.getController();
		controller.setInstanciaDoApp(this);

		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("LSSS App nutrição");
		primaryStage.show();
	}
}
