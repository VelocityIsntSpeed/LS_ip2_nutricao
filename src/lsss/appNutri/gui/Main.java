package lsss.appNutri.gui;

import java.io.IOException;
import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.stage.Stage;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.InfoNutricional;
import lsss.appNutri.negocios.Refeicao;
import lsss.appNutri.negocios.RepositorioComidas;
import lsss.appNutri.negocios.RepositorioRefeicoes;

public class Main extends Application {
	
	public static void main(String[] args) {
		Application.launch(); // O JavaFX cria uma instancia de Main e chama o metodo start nela
	}
	
	// Atributos
	public final RepositorioComidas repoComidas = new RepositorioComidas();
	public final RepositorioRefeicoes repoRefeicoes = new RepositorioRefeicoes();

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		// Inicialização dos dados (temporário, só para testes)
		
		InfoNutricional infoNut1 = new InfoNutricional(100, 1, 20);
		InfoNutricional infoNut2 = new InfoNutricional(240, 8, 15);
		System.out.println(infoNut1.mais(infoNut2));
		
		Comida arroz = new Comida("Arroz", infoNut2);
		Comida pastaDeAmendoim = new Comida("Pasta de Amendoim", infoNut1);
		Comida sucoDeLaranja = new Comida("Suco de Laranja", infoNut1);
		
		repoComidas.add(arroz);
		repoComidas.add(pastaDeAmendoim);
		repoComidas.add(sucoDeLaranja);
		repoComidas.add(arroz); // duplicado
		
		repoRefeicoes.add(new Refeicao(new Comida[]{arroz},
                                       LocalDateTime.now().minusDays(10)));
		repoRefeicoes.add(new Refeicao(new Comida[]{arroz, pastaDeAmendoim},
				                       LocalDateTime.now().minusHours(30)));
		repoRefeicoes.add(new Refeicao(new Comida[]{arroz, pastaDeAmendoim, sucoDeLaranja},
							           LocalDateTime.now().minusHours(1)));
		
		
		
		new JanelaPrincipal(primaryStage, this);
	}
}
