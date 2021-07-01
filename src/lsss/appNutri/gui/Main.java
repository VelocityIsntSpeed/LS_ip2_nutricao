package lsss.appNutri.gui;

import java.io.IOException;
import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.InfoNutricional;
import lsss.appNutri.negocios.Refeicao;
import lsss.appNutri.negocios.RepositorioComidas;
import lsss.appNutri.negocios.RepositorioRefeicoes;

public class Main extends Application {
	
	public final RepositorioComidas repoComidas = new RepositorioComidas();
	public final RepositorioRefeicoes repoRefeicoes = new RepositorioRefeicoes();
	
	public static void main(String[] args) {
		Application.launch(); // O JavaFX chama o m�todo start
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		// Inicializa��o dos dados (tempor�rio, s� para testes)
		
		System.out.println(repoComidas);
		System.out.println(repoRefeicoes);
		
		InfoNutricional infoNut1 = new InfoNutricional(100, 1, 20);
		
		Comida arroz = new Comida("Arroz", infoNut1);
		Comida pastaDeAmendoim = new Comida("Pasta de Amendoim", infoNut1);
		Comida sucoDeLaranja = new Comida("Suco de Laranja", infoNut1);
		
		repoComidas.add(arroz);
		repoComidas.add(pastaDeAmendoim);
		repoComidas.add(arroz); // duplicado
		System.out.println(repoComidas);
		
		Refeicao r1 = new Refeicao(new Comida[]{arroz, pastaDeAmendoim}, LocalDateTime.now());
		Refeicao r2 = new Refeicao(new Comida[]{arroz, pastaDeAmendoim, sucoDeLaranja}, LocalDateTime.now());
		
		repoRefeicoes.add(r1);
		repoRefeicoes.add(r2);
		System.out.println(repoRefeicoes);
		
		InfoNutricional infoNut2 = new InfoNutricional(240, 8, 15);
		System.out.println(infoNut1.mais(infoNut2));
		
		
		inicializarGUI(primaryStage);
	}
	
	private void inicializarGUI(Stage primaryStage) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/GUI.fxml"));
		Parent root = loader.load();
		
		// Fornece ao controller uma refer�ncia ao objeto atual
		GuiController controller = loader.getController();
		controller.setInstanciaDoApp(this);

		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("LSSS App nutri��o");
		primaryStage.show();
	}
}
